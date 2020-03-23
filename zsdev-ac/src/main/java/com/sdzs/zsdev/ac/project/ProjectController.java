package com.sdzs.zsdev.ac.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sdzs.zsdev.core.request.WebRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

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
    /**
     * 文件上传
     *
     * */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile files,HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        response.setCharacterEncoding("utf-8");
        String msg = "添加成功";
        log.info("-------------------开始调用上传文件upload接口-------------------");
        try{
            String path = "D:/"+new Date().getTime()+ "/" + files.getOriginalFilename();
            File fileDir = new File(path);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            files.transferTo(fileDir);
        }catch(Exception e){
            msg="添加失败";
        }
        log.info("-------------------结束调用上传文件upload接口-------------------");
        json.put("msg", msg);
        return msg;
    }

}
