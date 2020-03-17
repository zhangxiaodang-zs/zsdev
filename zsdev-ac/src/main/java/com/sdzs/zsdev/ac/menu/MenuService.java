package com.sdzs.zsdev.ac.menu;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sdzs.zsdev.core.request.WebRequest;
import com.sdzs.zsdev.core.response.SysErrResponse;
import com.sdzs.zsdev.core.response.SysResponse;
import com.sdzs.zsdev.core.response.WebResponse;
import com.sdzs.zsdev.core.utils.CommonUtil;
import com.sdzs.zsdev.core.utils.DateTimeUtil;
import com.sdzs.zsdev.core.utils.SdyfJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * web端菜单信息操作service.
 *
 * @author 张明亮 2019/08/08.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2019/08/08 张明亮 创建.
 */

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

//    @Autowired
//    private YfRedisService yfRedisService;

    /**
     * 菜单查询接口实现.
     *
     * @return Json字符串数据
     */
    public String menuQuery(WebRequest<MenuRequest> requestData) {
        //获取报文体
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        if (requestData.getRequest().getStartindex() != null && !"".equals(requestData.getRequest().getStartindex()) && requestData.getRequest().getPagesize() != null && !"".equals(requestData.getRequest().getPagesize())) {
            //为防止分页查询出错，把这俩个属性强转为int类型
            map.put("startindex", Integer.parseInt(requestData.getRequest().getStartindex()));
            map.put("pagesize", Integer.parseInt(requestData.getRequest().getPagesize()));
            map.put("pagingOrNot", "1");
        }
        ;
        //查询所有的机构信息（包含父机构和子机构）
        List<Map<String, Object>> lstData = menuRepository.menuQueryLists(map);
        // 构建机构树
        HashMap<String, Object> menulist = new HashMap<String, Object>();
        this.getJgTree(lstData, "", menulist);
        //创建接收对象
        WebResponse<MenuResponse> web = new WebResponse<>();
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setMenulist(menulist.get("menulist"));
        menuResponse.setDraw(requestData.getRequest().getDraw());
        menuResponse.setTotalcount(String.valueOf(menuRepository.number()));
        web.setResponse(menuResponse);
        return JSONObject.toJSON(web).toString();
    }

    /**
     * 菜单添加接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String menuAdd(WebRequest<MenuRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        // 查询code是否存在
        int number = menuRepository.menuOnly(requestData.getRequest().getMenucode());
        if (number <= 0) {
            map.put("uuid", CommonUtil.getUUid());
            map.put("addTime", DateTimeUtil.getTimeformat());
            map.put("operator", requestData.getUserid());
            menuRepository.menuAdd(map);
            return new SysResponse().toJsonString();
        } else {
            return new SysErrResponse("您输入的菜单代码已存在，请重新添加！").toJsonString();
        }
    }

    /**
     * 菜单修改接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String menuUpdate(WebRequest<MenuRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        map.put("updateTime", DateTimeUtil.getTimeformat());
        map.put("operator", requestData.getUserid());
        menuRepository.menuUpdate(map);
        return new SysResponse().toJsonString();
    }

    /**
     * 菜单删除接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String menuDelete(WebRequest<MenuRequest> requestData) {
        //批量删除  通过，分割  循环
        String[] menuidlist = requestData.getRequest().getMenuidlist();
        //通过循环查询是否存在子机构，如果存在，记录在number中
        String number = "";
        for (int i = 0; i < menuidlist.length; i++) {
            int num = menuRepository.sonMenu(menuidlist[i]);
            if (num != 0) {
                if (number.equals("")) {
                    number = (i + 1) + "";
                } else {
                    number = "," + (i + 1);
                }
            }
        }
        if (number.equals("")) {
            for (int i = 0; i < menuidlist.length; i++) {
                menuRepository.menuDelete(menuidlist[i]);
            }
            return new SysResponse().toJsonString();
        } else {
            return new SysErrResponse( "您选中的第" + number + "条数据存在子菜单，无法删除，请重新选择！").toJsonString();
        }
    }


    /**
     * 构建机构树.
     *
     * @param lstData 原始数据.
     * @param pid     上级节点ID.
     * @return 机构树.
     */
    private void getJgTree(List<Map<String, Object>> lstData, String pid, Map<String, Object> treeData) {

        List<Map<String, Object>> childrenData = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map : lstData) {
            if (map.get("fjdid").toString().equals(pid)) {
                childrenData.add(map);
            }
        }

        if (childrenData.size() != 0) {
            treeData.put("menulist", childrenData);
            for (Map<String, Object> m : childrenData) {
                getJgTree(lstData, m.get("menuid").toString(), m);
            }
        }
    }

}
