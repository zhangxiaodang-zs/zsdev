package com.sdzs.zsdev.ac.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sdzs.zsdev.core.request.WebRequest;
import com.sdzs.zsdev.core.response.WebResponse;
import com.sdzs.zsdev.core.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("utf-8");
        String msg = "添加成功";
        log.info("-------------------开始调用上传文件upload接口-------------------");

        //创建接收对象
        WebResponse<UploadResponse> web = new WebResponse<>();
        UploadResponse uploadResponse = new UploadResponse();
        try {
            String path = "/home/zsdev/upload/" + new Date().getTime() + "/" + files.getOriginalFilename();
            File fileDir = new File(path);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            files.transferTo(fileDir);

            uploadResponse.setFilename(files.getOriginalFilename());
            uploadResponse.setFilepath(path);
            uploadResponse.setFileid(CommonUtil.getUUid());
            uploadResponse.setMsg("上传成功");
            web.setResponse(uploadResponse);

        } catch (Exception e) {
            uploadResponse.setMsg("上传失败");
            web.setResponse(uploadResponse);
        }
        log.info("-------------------结束调用上传文件upload接口-------------------");
        return JSONObject.toJSON(web).toString();
    }

    /**
     * 文件下载
     */
    @GetMapping(value = "/doPost")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String filename = request.getParameter("filename");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            //获取下载文件所在路径
            String path = request.getParameter("filepath");
            //文件
            File file = new File(path);
            //判断文件是否存在
            if(file.exists()){
                //且仅当此对象抽象路径名表示的文件或目录存在时，返回true
                response.setContentType("application/" + filename.substring(filename.lastIndexOf(".") + 1));
                //控制下载文件的名字
                response.addHeader("Content-Disposition", "attachment;filename="+filename);

                byte buf[] = new byte[1024];

                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                os = response.getOutputStream();
                int i = bis.read(buf);
                while(i!=-1){
                    os.write(buf,0,i);
                    i = bis.read(buf);
                }
            }else{
                System.out.println("您下载的资源已经不存在了");
            }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }finally{
                os.close();
                bis.close();
                fis.close();
            }
        }

    // 下载
    @GetMapping(value = "/doPosts")
    public byte[] getIcon(HttpServletRequest request,HttpServletResponse response)throws Exception {
//        WebRequest<ProjectRequest> projectRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<ProjectRequest>>() {
//        });

        String res = request.getParameter("filepath");
        InputStream is =null;
        try {
            is = new FileInputStream(new File(res));
        }catch (Exception e){
            // TODO: handle exception
            e.printStackTrace();
        }
        String filenamedisplay = request.getParameter("filename");
        response.addHeader("Content-Disposition","attachment;filename=" + new Date().getTime() + "." + request.getParameter("filename").substring(request.getParameter("filename").lastIndexOf(".") + 1));
        return IOUtils.toByteArray(is);
    }

    @GetMapping(value = "/doPostss")
    public void getWordFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String fileNameString = request.getParameter("filename"); //声明要下载的文件名
        //String fileName = new String(fileNameString.getBytes("ISO8859-1"), "UTF-8");
        response.setContentType("application/octet-stream");
        // URLEncoder.encode(fileNameString, "UTF-8") 下载文件名为中文的，文件名需要经过url编码
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileNameString, "UTF-8"));
        File file;
        FileInputStream fileIn = null;
        ServletOutputStream out = null;
        try {
            String contextPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
            String filePathString = contextPath + "database" + File.separator + fileNameString;
            file = new File(filePathString);
            fileIn = new FileInputStream(file);
            out = response.getOutputStream();

            byte[] outputByte = new byte[1024];
            int readTmp = 0;
            while ((readTmp = fileIn.read(outputByte)) != -1) {
                out.write(outputByte, 0, readTmp); //并不是每次都能读到1024个字节，所有用readTmp作为每次读取数据的长度，否则会出现文件损坏的错误
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        finally {
            fileIn.close();
            out.flush();
            out.close();
        }
    }

    /**
     * 附件删除.
     *
     * @return String字符串
     */
    @RequestMapping("/filedelete")
    public String filedelete(@RequestBody String requestData) {

        WebRequest<UploadRequest> uploadRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<UploadRequest>>() {
        });
        log.info("附件删除---------->传入的参数为：{}", requestData);
        return projectService.uploadDelete(uploadRequest);
    }

    /**
     * 附件查询.
     *
     * @return String字符串
     */
    @RequestMapping("/filequery")
    public String filequery(@RequestBody String requestData) {

        WebRequest<ProjectRequest> projectRequest = JSON.parseObject(requestData, new TypeReference<WebRequest<ProjectRequest>>() {
        });
        log.info("web项目查询---------->传入的参数为：{}", requestData);
        return projectService.fileQuery(projectRequest);
    }
}
