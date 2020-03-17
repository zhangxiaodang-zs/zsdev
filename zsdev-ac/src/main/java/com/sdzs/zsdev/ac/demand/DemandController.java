package com.sdzs.zsdev.ac.demand;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sdzs.zsdev.core.request.WebRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright(C) ZhiSheng 2019.
 * <p>
 * web端功能信息操作controller.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */
@Slf4j
@RequestMapping("/web/front")
@RestController
@CrossOrigin(origins = "*")
public class DemandController {

    @Autowired
    private DemandService demandService;

    /**
     * 查询一览.
     */
    @RequestMapping("demandquery")
    public String query(@RequestBody String requestData) {
        log.info("查询需求一览开始..................");

        log.info("请求参数为：{}", requestData);
        WebRequest<DemandRequest> demandRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<DemandRequest>>() {
        });
        log.info("web项目查询---------->传入的参数为：{}", requestData);
        return demandService.demandQuery(demandRequest);
    }

}
