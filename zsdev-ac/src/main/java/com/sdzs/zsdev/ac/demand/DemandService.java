package com.sdzs.zsdev.ac.demand;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sdzs.zsdev.ac.project.ProjectRepository;
import com.sdzs.zsdev.ac.project.ProjectRequest;
import com.sdzs.zsdev.ac.project.ProjectResponse;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * web端需求信息操作service.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */

@Service
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;

    /**
     * 需求查询接口实现.
     *
     * @return Json字符串数据
     */
    public String demandQuery(WebRequest<DemandRequest> requestData) {
        //获取报文体
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        if (requestData.getRequest().getStartindex() != null && !"".equals(requestData.getRequest().getStartindex()) && requestData.getRequest().getPagesize() != null && !"".equals(requestData.getRequest().getPagesize())) {
            //为防止分页查询出错，把这俩个属性强转为int类型
            map.put("startindex", Integer.parseInt(requestData.getRequest().getStartindex()));
            map.put("pagesize", Integer.parseInt(requestData.getRequest().getPagesize()));
            map.put("pagingOrNot", "1");
        }
        //查询所有的需求信息
        List<Map<String, Object>> lstData = demandRepository.demandQueryList(map);
        //创建接收对象
        WebResponse<DemandResponse> web = new WebResponse<>();
        DemandResponse demandResponse = new DemandResponse();

        demandResponse.setDraw(requestData.getRequest().getDraw());
        demandResponse.setTotalcount(String.valueOf(demandRepository.number()));
        demandResponse.setDemandlist(lstData);
        web.setResponse(demandResponse);
        return JSONObject.toJSON(web).toString();
    }

    /**
     * 需求添加接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String demandAdd(WebRequest<DemandRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap("");
        HashMap<String, Object> hashMap = new HashMap<>();
        // 查询需求名称是否存在
        map.put("demandnamejq",requestData.getRequest().getDemandname());
        //精确查询
        List<Map<String, Object>> lstData = demandRepository.demandQueryListjq(map);
        if(null != lstData && lstData.size() != 0){
            //重复
            return new SysErrResponse( "您输入的需求名称已存在，请重新输入！").toJsonString();
        }else{
            //不重复
            map = SdyfJsonUtil.beanToMap(requestData.getRequest());
            map.put("id", CommonUtil.getUUid());
            map.put("addTime", DateTimeUtil.getTimeformat());
            map.put("updTime", DateTimeUtil.getTimeformat());
            map.put("operator", requestData.getUserid());
            int adddemand = demandRepository.adddemand(map);
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 需求修改接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String demandEdit(WebRequest<DemandRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        map.put("updateTime", DateTimeUtil.getTimeformat());
        map.put("operator", requestData.getUserid());
        // 查询需求名称是否存在
        map.put("demandnamejq",requestData.getRequest().getDemandname());
        //精确查询
        List<Map<String, Object>> lstData = demandRepository.demandQueryListjq(map);
        if(null != lstData && lstData.size() != 0 ){
            //重复
            if(requestData.getRequest().getId().equals(lstData.get(0).get("id"))){
                //不重复
                int editdemand = demandRepository.editdemand(map);
                if(editdemand <=0){
                    return new SysErrResponse( "修改发生错误").toJsonString();
                }
            }else{
                return new SysErrResponse( "您要修改的需求名称已存在，请重新输入！").toJsonString();
            }
        }else{
            //不重复
            int editdemand = demandRepository.editdemand(map);
            if(editdemand <=0){
                return new SysErrResponse( "修改发生错误").toJsonString();
            }
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 需求删除接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String demandDel(WebRequest<DemandRequest> requestData) {
        //批量删除  通过，分割  循环
        int result = 0;
        for (String advertId : requestData.getRequest().getDemandidlist()) {
            DemandRequest demandRequest = JSON.parseObject(advertId, new TypeReference<DemandRequest>() {
            });
            Map<String, String> param = new HashMap<>();
            param.put("id", demandRequest.getId());
            result = this.demandRepository.deldemand(param);
            if (result <= 0) {
                return new SysErrResponse("id:"+demandRequest.getId()+" 删除失败，请重新操作！").toJsonString();
            }
        }
        return new SysResponse().toJsonString();
    }
}
