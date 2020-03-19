package com.sdzs.zsdev.ac.feedback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sdzs.zsdev.ac.task.TaskRequest;
import com.sdzs.zsdev.ac.task.TaskService;
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
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 任务反馈查询.
     *
     * @return String字符串
     */
    @RequestMapping("/feedbackquery")
    public String feedbackquery(@RequestBody String requestData) {

        WebRequest<FeedbackRequest> feedbackRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<FeedbackRequest>>() {
        });
        log.info("web任务查询---------->传入的参数为：{}", requestData);
        return feedbackService.taskFeedbackQuery(feedbackRequest);
    }


    /**
     * 任务反馈添加.
     *
     * @return String字符串
     */
    @RequestMapping("/taskFeedback")
    public String taskFeedback(@RequestBody String requestData) {

        WebRequest<FeedbackRequest> feedbackRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<FeedbackRequest>>() {
        });
        log.info("web任务反馈---------->传入的参数为：{}", requestData);
        return feedbackService.taskFeedbackAdd(feedbackRequest);
    }

    /**
     * 任务修改.
     *
     * @return String字符串
     */
    @RequestMapping("/feedbackedit")
    public String feedbackedit(@RequestBody String requestData) {

        WebRequest<FeedbackRequest> feedbackRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<FeedbackRequest>>() {
        });
        log.info("web任务修改---------->传入的参数为：{}", requestData);
        return feedbackService.feedbackEdit(feedbackRequest);
    }

    /**
     * 任务删除.
     *
     * @return String字符串
     */
    @RequestMapping("/feedbackdelete")
    public String feedbackdelete(@RequestBody String requestData) {

        WebRequest<FeedbackRequest> feedbackRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<FeedbackRequest>>() {
        });
        log.info("web任务删除---------->传入的参数为：{}", requestData);
        return feedbackService.feedbackDelete(feedbackRequest);
    }
}
