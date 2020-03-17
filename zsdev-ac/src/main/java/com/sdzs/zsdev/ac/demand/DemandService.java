package com.sdzs.zsdev.ac.demand;

import com.alibaba.fastjson.JSONObject;
import com.sdzs.zsdev.ac.project.ProjectRepository;
import com.sdzs.zsdev.ac.project.ProjectRequest;
import com.sdzs.zsdev.ac.project.ProjectResponse;
import com.sdzs.zsdev.core.request.WebRequest;
import com.sdzs.zsdev.core.response.WebResponse;
import com.sdzs.zsdev.core.utils.SdyfJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * web端项目信息操作service.
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
     * 项目查询接口实现.
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
        //查询所有的项目信息
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

}
