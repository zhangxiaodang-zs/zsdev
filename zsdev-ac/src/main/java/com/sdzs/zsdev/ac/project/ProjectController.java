package com.sdzs.zsdev.ac.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sdzs.zsdev.ac.organ.OrganRequest;
import com.sdzs.zsdev.ac.organ.OrganService;
import com.sdzs.zsdev.core.request.WebRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * web端项目信息操作controller.
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
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 项目查询.
     *
     * @return String字符串
     */
    @RequestMapping("/projectquery")
    public String projectquery(@RequestBody String requestData) {

        WebRequest<ProjectRequest> projectRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<ProjectRequest>>() {
        });
        log.info("web项目查询---------->传入的参数为：{}", requestData);
        return projectService.projectQuery(projectRequest);
    }

    /**
     * 项目添加.
     *
     * @return String字符串
     */
    @RequestMapping("/projectadd")
    public String projectadd(@RequestBody String requestData) {

        WebRequest<ProjectRequest> projectRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<ProjectRequest>>() {
        });
        log.info("web项目添加---------->传入的参数为：{}", requestData);
        return projectService.projectAdd(projectRequest);
    }

    /**
     * 项目修改.
     *
     * @return String字符串
     */
    @RequestMapping("/projectedit")
    public String projectedit(@RequestBody String requestData) {

        WebRequest<ProjectRequest> projectRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<ProjectRequest>>() {
        });
        log.info("web项目修改---------->传入的参数为：{}", requestData);
        return projectService.projectEdit(projectRequest);
    }

    /**
     * 项目删除.
     *
     * @return String字符串
     */
    @RequestMapping("/projectdelete")
    public String projectdelete(@RequestBody String requestData) {

        WebRequest<ProjectRequest> projectRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<ProjectRequest>>() {
        });
        log.info("web项目删除---------->传入的参数为：{}", requestData);
        return projectService.projectDelete(projectRequest);
    }
}
