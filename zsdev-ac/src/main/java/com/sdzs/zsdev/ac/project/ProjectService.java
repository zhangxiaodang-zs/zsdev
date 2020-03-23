package com.sdzs.zsdev.ac.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sdzs.zsdev.ac.organ.OrganRepository;
import com.sdzs.zsdev.ac.organ.OrganRequest;
import com.sdzs.zsdev.ac.organ.OrganResponse;
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
 * web端项目信息操作service.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * 项目查询接口实现.
     *
     * @return Json字符串数据
     */
    public String projectQuery(WebRequest<ProjectRequest> requestData) {
        //获取报文体
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        if (requestData.getRequest().getStartindex() != null && !"".equals(requestData.getRequest().getStartindex()) && requestData.getRequest().getPagesize() != null && !"".equals(requestData.getRequest().getPagesize())) {
            //为防止分页查询出错，把这俩个属性强转为int类型
            map.put("startindex", Integer.parseInt(requestData.getRequest().getStartindex()));
            map.put("pagesize", Integer.parseInt(requestData.getRequest().getPagesize()));
            map.put("pagingOrNot", "1");
        }
        //查询所有的项目信息
        List<Map<String, Object>> lstData = projectRepository.projectQueryList(map);
        //创建接收对象
        WebResponse<ProjectResponse> web = new WebResponse<>();
        ProjectResponse projectResponse = new ProjectResponse();

        projectResponse.setDraw(requestData.getRequest().getDraw());
        projectResponse.setTotalcount(String.valueOf(projectRepository.number()));
        projectResponse.setProjectlist(lstData);
        web.setResponse(projectResponse);
        return JSONObject.toJSON(web).toString();
    }

    /**
     * 项目添加接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String projectAdd(WebRequest<ProjectRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap("");
        HashMap<String, Object> hashMap = new HashMap<>();
        // 查询项目名称是否存在
        map.put("projectnamejq",requestData.getRequest().getProjectname());
        //精确查询
        List<Map<String, Object>> lstData = projectRepository.projectQueryListjq(map);
        String uuid = CommonUtil.getUUid();
        if(null != lstData && lstData.size() != 0){
            //重复
            return new SysErrResponse( "您输入的项目名称已存在，请重新输入！").toJsonString();
        }else{
            //不重复
            //项目编号最大值 来确定新的项目编号
            //1.取今天的时间戳的项目编号最大值 没有就新建
            map.put("projectnamejq","");
            map.put("todaytime",DateTimeUtil.getTimeformat().substring(0,8));
            List<Map<String, Object>> lstData2 = projectRepository.projectQueryList(map);
            String projectnumber = "";
            if(null != lstData2 && lstData2.size() != 0){
                //有当天新建的项目
                projectnumber = "ZS"+ DateTimeUtil.getTimeformat().substring(0,8) + "_" + frontCompWithZore(3,Integer.parseInt(lstData2.get(0).get("projectnumber").toString())+1);
            }else{
                //当天无新建的项目
                projectnumber = "ZS"+ DateTimeUtil.getTimeformat().substring(0,8) + "_001";
            }
            map.put("id", uuid);
            map.put("projectid",projectnumber);
            map.put("projectname",requestData.getRequest().getProjectname());
            map.put("actualsttime",requestData.getRequest().getActualsttime());
            map.put("actualentime",requestData.getRequest().getActualentime());
            map.put("expectedsttime",requestData.getRequest().getExpectedsttime());
            map.put("expectedentime",requestData.getRequest().getExpectedentime());
            map.put("introduction",requestData.getRequest().getIntroduction());
            map.put("principal",requestData.getRequest().getPrincipal());
            map.put("addTime", DateTimeUtil.getTimeformat());
            map.put("updTime", DateTimeUtil.getTimeformat());
            map.put("operator", requestData.getUserid());
            int addproject = projectRepository.addproject(map);
            if(addproject<=0){
                return new SysErrResponse("添加项目失败！").toJsonString();
            }
            int result=0;
            for (String advertId : requestData.getRequest().getProjectUpload()) {
                ProjectRequest projectRequest = JSON.parseObject(advertId, new TypeReference<ProjectRequest>() {
                });
                Map<String, String> param = new HashMap<>();
                param.put("fileid", projectRequest.getFileid());
                param.put("filename", projectRequest.getFilename());
                param.put("filepath", projectRequest.getFilepath());
                param.put("glid", projectnumber);
                param.put("filemark", "1");
                param.put("addTime", DateTimeUtil.getTimeformat());
                param.put("updTime", DateTimeUtil.getTimeformat());
                param.put("operator", requestData.getUserid());
                result = this.projectRepository.addannex(param);
                if (result <= 0) {
                    return new SysErrResponse("文件:"+projectRequest.getFilename()+" 插入失败，请重新操作！").toJsonString();
                }
            }
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 项目修改接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String projectEdit(WebRequest<ProjectRequest> requestData) {
        //对象转换成map集合 并给dao传值
        HashMap map = SdyfJsonUtil.beanToMap(requestData.getRequest());
        map.put("updateTime", DateTimeUtil.getTimeformat());
        map.put("operator", requestData.getUserid());
        // 查询项目名称是否存在
        map.put("projectnamejq",requestData.getRequest().getProjectname());
        //精确查询
        List<Map<String, Object>> lstData = projectRepository.projectQueryListjq(map);
        if(null != lstData && lstData.size() != 0){
            //重复
            if(requestData.getRequest().getId().equals(lstData.get(0).get("id"))){
                //不重复
                int editdemand = projectRepository.editproject(map);
                if(editdemand <=0){
                    return new SysErrResponse( "修改发生错误").toJsonString();
                }
            }else{
                return new SysErrResponse( "您要修改的项目名称已存在，请重新输入！").toJsonString();
            }
        }else{
            //不重复
            int editproject = projectRepository.editproject(map);
            if(editproject <=0){
                return new SysErrResponse( "修改发生错误").toJsonString();
            }
            int result = 0;
            for (String advertId : requestData.getRequest().getProjectUpload()) {
                ProjectRequest projectRequest = JSON.parseObject(advertId, new TypeReference<ProjectRequest>() {
                });
                Map<String, String> param = new HashMap<>();
                param.put("fileid", projectRequest.getFileid());
                param.put("filename", projectRequest.getFilename());
                param.put("filepath", projectRequest.getFilepath());
                param.put("glid", requestData.getRequest().getProjectid());
                param.put("filemark", "1");
                param.put("addTime", DateTimeUtil.getTimeformat());
                param.put("updTime", DateTimeUtil.getTimeformat());
                param.put("operator", requestData.getUserid());
                result = this.projectRepository.addannex(param);
                if (result <= 0) {
                    return new SysErrResponse("文件:"+projectRequest.getFilename()+" 插入失败，请重新操作！").toJsonString();
                }
            }
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 项目删除接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String projectDelete(WebRequest<ProjectRequest> requestData) {
        //批量删除  通过，分割  循环
        int result = 0;
        for (String advertId : requestData.getRequest().getProjectidlist()) {
            ProjectRequest projectRequest = JSON.parseObject(advertId, new TypeReference<ProjectRequest>() {
            });
            Map<String, String> param = new HashMap<>();
            param.put("id", projectRequest.getProjectid());
            result = this.projectRepository.delproject(param);
            if (result <= 0) {
                return new SysErrResponse("id:"+projectRequest.getProjectid()+" 删除失败，请重新操作！").toJsonString();
            }
        }
        return new SysResponse().toJsonString();
    }

    /**
     * 附件删除接口实现.
     *
     * @return Json字符串数据
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    public String uploadDelete(WebRequest<UploadRequest> requestData) {
        //批量删除  通过，分割  循环
        int result = 0;
        Map<String, String> param = new HashMap<>();
        param.put("id", requestData.getRequest().getFileid());
        result = this.projectRepository.delfile(param);
        if (result <= 0) {
            return new SysErrResponse("id:"+requestData.getRequest().getFileid()+" 删除失败，请重新操作！").toJsonString();
        }
        return new SysResponse().toJsonString();
    }
    
    //补位
    public static String frontCompWithZore(int formatLength,int formatNumber){
        /**
         * 0 指前面补充零
         * formatLength 字符总长度为 formatLength
         * inputNumber 格式化数字
         * d 代表为正数。
         */
        String newString = String.format("%0"+formatLength+"d", formatNumber);
        return newString;
    }

    /**
     * 附件查询接口实现.
     *
     * @return Json字符串数据
     */
    public String fileQuery(WebRequest<ProjectRequest> requestData) {
        HashMap map = SdyfJsonUtil.beanToMap("");
        map.put("glid",requestData.getRequest().getProjectid());
        //查询项目下附件
        List<Map<String, Object>> fileData = projectRepository.queryFileList(map);
        //创建接收对象
        WebResponse<UploadResponse> web = new WebResponse<>();
        UploadResponse uploadResponse = new UploadResponse();

        uploadResponse.setProjectUpload(fileData);
        web.setResponse(uploadResponse);
        return JSONObject.toJSON(web).toString();
    }

}
