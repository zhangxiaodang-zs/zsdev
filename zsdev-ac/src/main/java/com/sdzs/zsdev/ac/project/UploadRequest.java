package com.sdzs.zsdev.ac.project;

import java.util.List;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * WEB端机构信息请求报文.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */
public class UploadRequest {

    //附件id
    private String fileid;

    //附件名称
    private String filename;

    //附件路径
    private String filepath;

    //附件列表
    private List<String> projectUpload;

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

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public List<String> getProjectUpload() {
        return projectUpload;
    }

    public void setProjectUpload(List<String> projectUpload) {
        this.projectUpload = projectUpload;
    }

    @Override
    public String toString() {
        return "ProjectRequest{" +
                ", projectUpload='" + projectUpload + '\'' +
                ", fileid='" + fileid + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
