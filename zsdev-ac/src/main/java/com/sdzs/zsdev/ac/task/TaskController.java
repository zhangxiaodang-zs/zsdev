package com.sdzs.zsdev.ac.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sdzs.zsdev.ac.project.ProjectRequest;
import com.sdzs.zsdev.ac.project.ProjectService;
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
 * web端任务信息操作controller.
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
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 任务查询.
     *
     * @return String字符串
     */
    @RequestMapping("/taskquery")
    public String taskquery(@RequestBody String requestData) {

        WebRequest<TaskRequest> taskRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<TaskRequest>>() {
        });
        log.info("web任务查询---------->传入的参数为：{}", requestData);
        return taskService.taskQuery(taskRequest);
    }

    /**
     * 任务添加.
     *
     * @return String字符串
     */
    @RequestMapping("/taskadd")
    public String taskadd(@RequestBody String requestData) {

        WebRequest<TaskRequest> taskRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<TaskRequest>>() {
        });
        log.info("web任务添加---------->传入的参数为：{}", requestData);
        return taskService.taskAdd(taskRequest);
    }

    /**
     * 任务修改.
     *
     * @return String字符串
     */
    @RequestMapping("/taskedit")
    public String taskedit(@RequestBody String requestData) {

        WebRequest<TaskRequest> taskRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<TaskRequest>>() {
        });
        log.info("web任务修改---------->传入的参数为：{}", requestData);
        return taskService.taskEdit(taskRequest);
    }

    /**
     * 任务删除.
     *
     * @return String字符串
     */
    @RequestMapping("/taskdelete")
    public String taskdelete(@RequestBody String requestData) {

        WebRequest<TaskRequest> taskRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<TaskRequest>>() {
        });
        log.info("web任务删除---------->传入的参数为：{}", requestData);
        return taskService.taskDelete(taskRequest);
    }

}
