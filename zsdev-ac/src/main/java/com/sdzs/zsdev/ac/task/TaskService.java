package com.sdzs.zsdev.ac.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
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
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * 任务查询接口实现.
     *
     * @return Json字符串数据
     */
    public String taskQuery(WebRequest<TaskRequest> requestData) {
        //获取报文体
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        if (requestData.getRequest().getStartindex() != null && !"".equals(requestData.getRequest().getStartindex()) && requestData.getRequest().getPagesize() != null && !"".equals(requestData.getRequest().getPagesize())) {
            //为防止分页查询出错，把这俩个属性强转为int类型
            map.put("startindex", Integer.parseInt(requestData.getRequest().getStartindex()));
            map.put("pagesize", Integer.parseInt(requestData.getRequest().getPagesize()));
            map.put("pagingOrNot", "1");
        }
        //查询所有的任务信息
        List<Map<String, Object>> lstData = taskRepository.taskQueryList(map);
        //创建接收对象
        WebResponse<TaskResponse> web = new WebResponse<>();
        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setDraw(requestData.getRequest().getDraw());
        taskResponse.setTotalcount(String.valueOf(taskRepository.number()));
        taskResponse.setTasklist(lstData);
        web.setResponse(taskResponse);
        return JSONObject.toJSON(web).toString();
    }

    /**
     * 任务添加接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String taskAdd(WebRequest<TaskRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap("");
        HashMap<String, Object> hashMap = new HashMap<>();
        // 查询任务名称是否存在
        map.put("tasknamejq",requestData.getRequest().getTaskname());
        //精确查询
        List<Map<String, Object>> lstData = taskRepository.taskQueryListjq(map);
        if(null != lstData && lstData.size() != 0){
            //重复
            return new SysErrResponse( "您输入的任务名称已存在，请重新输入！").toJsonString();
        }else{
            //不重复
            map.put("id", CommonUtil.getUUid());
            map.put("demandid",requestData.getRequest().getDemandid());
            map.put("taskname",requestData.getRequest().getTaskname());
            map.put("actualsttime",requestData.getRequest().getActualsttime());
            map.put("actualentime",requestData.getRequest().getActualentime());
            map.put("expectedsttime",requestData.getRequest().getExpectedsttime());
            map.put("expectedentime",requestData.getRequest().getExpectedentime());
            map.put("taskcontent",requestData.getRequest().getTaskcontent());
            map.put("principal",requestData.getRequest().getPrincipal());
            map.put("schedule",requestData.getRequest().getSchedule());
            map.put("addTime", DateTimeUtil.getTimeformat());
            map.put("updTime", DateTimeUtil.getTimeformat());
            map.put("operator", requestData.getUserid());
            int addtask = taskRepository.addtask(map);
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 任务修改接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String taskEdit(WebRequest<TaskRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        map.put("updateTime", DateTimeUtil.getTimeformat());
        map.put("operator", requestData.getUserid());
        // 查询任务名称是否存在
        map.put("tasknamejq",requestData.getRequest().getTaskname());
        //精确查询
        List<Map<String, Object>> lstData = taskRepository.taskQueryListjq(map);
        if(null != lstData && lstData.size() != 0){
            //重复
            if(requestData.getRequest().getId().equals(lstData.get(0).get("id"))){
                //不重复
                int editdemand = taskRepository.edittask(map);
                if(editdemand <=0){
                    return new SysErrResponse( "修改发生错误").toJsonString();
                }
            }else{
                return new SysErrResponse( "您要修改的任务名称已存在，请重新输入！").toJsonString();
            }
        }else{
            //不重复
            int edittask = taskRepository.edittask(map);
            if(edittask <=0){
                return new SysErrResponse( "修改发生错误").toJsonString();
            }
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 任务删除接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String taskDelete(WebRequest<TaskRequest> requestData) {
        //批量删除  通过，分割  循环
        int result = 0;
        for (String advertId : requestData.getRequest().getTaskidlist()) {
            TaskRequest taskRequest = JSON.parseObject(advertId, new TypeReference<TaskRequest>() {
            });
            Map<String, String> param = new HashMap<>();
            param.put("id", taskRequest.getId());
            result = this.taskRepository.deltask(param);
            if (result <= 0) {
                return new SysErrResponse("id:"+taskRequest.getId()+" 删除失败，请重新操作！").toJsonString();
            }
        }
        return new SysResponse().toJsonString();
    }

}
