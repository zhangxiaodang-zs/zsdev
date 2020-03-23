package com.sdzs.zsdev.ac.project;

import java.util.List;
import java.util.Map;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * WEB端机构信息返回报文.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */
public class UploadResponse {

    //附件id
    private String fileid;

    //文件名
    private String filename;

    //文件路径
    private String filepath;

    //附件列表
    private List<Map<String, Object>> projectUpload;

    //信息
    private String msg;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public List<Map<String, Object>> getProjectUpload() {
        return projectUpload;
    }

    public void setProjectUpload(List<Map<String, Object>> projectUpload) {
        this.projectUpload = projectUpload;
    }
}
