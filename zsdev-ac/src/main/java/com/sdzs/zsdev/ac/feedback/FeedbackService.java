package com.sdzs.zsdev.ac.feedback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sdzs.zsdev.ac.task.TaskRepository;
import com.sdzs.zsdev.ac.task.TaskRequest;
import com.sdzs.zsdev.ac.task.TaskResponse;
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
 * web端任务信息操作service.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private TaskRepository taskRepository;

    /**
     * 任务查询接口实现.
     *
     * @return Json字符串数据
     */
    public String taskFeedbackQuery(WebRequest<FeedbackRequest> requestData) {
        //获取报文体
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        //查询所有的任务信息
        List<Map<String, Object>> lstData = feedbackRepository.feedbackQueryList(map);
        //创建接收对象
        WebResponse<FeedbackResponse> web = new WebResponse<>();
        FeedbackResponse feedbackResponse = new FeedbackResponse();

        feedbackResponse.setDraw(requestData.getRequest().getDraw());
        feedbackResponse.setTotalcount(String.valueOf(feedbackRepository.number()));
        feedbackResponse.setFeedbacklist(lstData);
        web.setResponse(feedbackResponse);
        return JSONObject.toJSON(web).toString();
    }

    /**
     * 任务反馈添加接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String taskFeedbackAdd(WebRequest<FeedbackRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询今日这个任务是否已经反馈
        map.put("todaytime",requestData.getRequest().getFeedbacktime().substring(0,8));
        List<Map<String, Object>> lstData = feedbackRepository.feedbackQueryListjq(map);
        if(null != lstData && lstData.size()>0){
            //今日已经提交反馈
            return new SysErrResponse( "今日已经提交反馈").toJsonString();
        }else{
            //今日未提交
            //向反馈表插入数据
            map.put("id", CommonUtil.getUUid());
            map.put("addTime", DateTimeUtil.getTimeformat());
            map.put("updTime", DateTimeUtil.getTimeformat());
            map.put("operator",  requestData.getUserid());
            int addtask = feedbackRepository.addtaskFeedback(map);
            if(addtask > 0){
                //反馈完成
                //查询最大完成度 向任务表插入进度 (废弃 现改为最后一次插入的进度)
                HashMap map1 = SdyfJsonUtil.beanToMap("");
//                map1.put("mark","1");
                //查该任务下的工时总和
                map1.put("taskid",requestData.getRequest().getTaskid());
                List<Map<String, Object>> results = feedbackRepository.feedbackQueryListjq(map1);
                int gs = 0;
                for(int i=0;i<results.size();i++){
                    gs += Integer.parseInt(results.get(i).get("workinghours").toString());
                }
                map1.put("workhours",gs);
                map1.put("id",requestData.getRequest().getTaskid());
                map1.put("updateTime", DateTimeUtil.getTimeformat());
                map1.put("operator",  requestData.getUserid());

                map1.put("schedule",requestData.getRequest().getFeedschedule());
                map1.put("actualsttime",requestData.getRequest().getActualsttime());
                map1.put("actualentime",requestData.getRequest().getActualentime());
                //更新任务表
                int taskresult = taskRepository.edittask(map1);
                if(taskresult <= 0){
                    return new SysErrResponse( "任务表更新进度失败 请确认是否提交反馈").toJsonString();
                }
            }else{
                return new SysErrResponse( "反馈失败").toJsonString();
            }
        }


        return new SysResponse().toJsonString();
    }

    /**
     * 任务反馈修改接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String feedbackEdit(WebRequest<FeedbackRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        map.put("updateTime", DateTimeUtil.getTimeformat());
        map.put("operator", requestData.getUserid());
        //check反馈内容不为空
        if(requestData.getRequest().getFeedbackcontent().equals("") || null == requestData.getRequest().getFeedbackcontent()){
            return new SysErrResponse( "反馈内容不能为空").toJsonString();
        }else if(requestData.getRequest().getFeedschedule().equals("") || null == requestData.getRequest().getFeedschedule()){
            return new SysErrResponse( "反馈进度不能为空").toJsonString();
        }else if(requestData.getRequest().getWorkinghours().equals("") || null == requestData.getRequest().getWorkinghours()){
            return new SysErrResponse( "反馈工时不能为空").toJsonString();
        }else{
            int feedresult = feedbackRepository.editfeedback(map);
            if(feedresult <= 0){
                return new SysErrResponse( "操作失败").toJsonString();
            }
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 任务反馈删除接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String feedbackDelete(WebRequest<FeedbackRequest> requestData) {
        //批量删除  通过，分割  循环
        int result = 0;
        for (String advertId : requestData.getRequest().getFeedbackidlist()) {
            FeedbackRequest feedbackRequest = JSON.parseObject(advertId, new TypeReference<FeedbackRequest>() {
            });
            Map<String, String> param = new HashMap<>();
            param.put("id", feedbackRequest.getId());
            result = this.feedbackRepository.delfeedback(param);
            if (result <= 0) {
                return new SysErrResponse("id:"+feedbackRequest.getId()+" 删除失败，请重新操作！").toJsonString();
            }
        }
        return new SysResponse().toJsonString();
    }
}
