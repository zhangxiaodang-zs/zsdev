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
public class ProjectRequest {

    // uuid，主键
    private String id;

    // 机构id数组
    private List<String> projectidlist;

    // 项目id
    private String projectid;

    // 项目名称
    private String projectname;

    // 预计开始时间
    private String expectedsttime;

    // 预计结束时间
    private String expectedentime;

    // 实际开始时间
    private String actualsttime;

    // 实际结束时间
    private String actualentime;

    // 项目介绍
    private String introduction;

    // 项目负责人
    private String principal;

    // 添加时间
    private String addtime;

    // 更新时间
    private String updtime;

    // 操作人
    private String operator;

    //附件id
    private String fileid;

    //附件名称
    private String filename;

    //附件路径
    private String filepath;

    //附件列表
    private List<String> projectUpload;

    // 当前页码，如果等于空，表示不分页
    private String currentpage;

    // 开始检索index
    private String startindex;

    // 每页显示条数，如果等于空，表示不分页
    private String pagesize;

    // 请求次数
    private String draw;

    public List<String> getProjectidlist() {
        return projectidlist;
    }

    public void setProjectidlist(List<String> projectidlist) {
        this.projectidlist = projectidlist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getUpdtime() {
        return updtime;
    }

    public void setUpdtime(String updtime) {
        this.updtime = updtime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(String currentpage) {
        this.currentpage = currentpage;
    }

    public String getStartindex() {
        return startindex;
    }

    public void setStartindex(String startindex) {
        this.startindex = startindex;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getExpectedsttime() {
        return expectedsttime;
    }

    public void setExpectedsttime(String expectedsttime) {
        this.expectedsttime = expectedsttime;
    }

    public String getExpectedentime() {
        return expectedentime;
    }

    public void setExpectedentime(String expectedentime) {
        this.expectedentime = expectedentime;
    }

    public String getActualsttime() {
        return actualsttime;
    }

    public void setActualsttime(String actualsttime) {
        this.actualsttime = actualsttime;
    }

    public String getActualentime() {
        return actualentime;
    }

    public void setActualentime(String actualentime) {
        this.actualentime = actualentime;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

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

    public List<String> getProjectUpload() {
        return projectUpload;
    }

    public void setProjectUpload(List<String> projectUpload) {
        this.projectUpload = projectUpload;
    }

    @Override
    public String toString() {
        return "ProjectRequest{" +
                "projectid='" + projectid + '\'' +
                ", projectname='" + projectname + '\'' +
                ", expectedsttime='" + expectedsttime + '\'' +
                ", expectedentime='" + expectedentime + '\'' +
                ", actualsttime='" + actualsttime + '\'' +
                ", actualentime='" + actualentime + '\'' +
                ", introduction='" + introduction + '\'' +
                ", principal='" + principal + '\'' +
                ", addtime='" + addtime + '\'' +
                ", updtime='" + updtime + '\'' +
                ", projectUpload='" + projectUpload + '\'' +
                ", fileid='" + fileid + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filename='" + filename + '\'' +
                ", currentpage='" + currentpage + '\'' +
                ", startindex='" + startindex + '\'' +
                ", pagesize='" + pagesize + '\'' +
                ", draw='" + draw + '\'' +
                '}';
    }
}
