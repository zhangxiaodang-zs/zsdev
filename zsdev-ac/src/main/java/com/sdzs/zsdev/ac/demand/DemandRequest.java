package com.sdzs.zsdev.ac.demand;

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
public class DemandRequest {

    // 需求id
    private String id;
    // id数组
    private List<String> demandidlist;

    // 关联项目id
    private String projectid;

    // 需求名称
    private String demandname;

    // 开始时间
    private String starttime;

    // 结束时间
    private String endtime;

    // 需求内容
    private String demandcontent;

    // 负责人
    private String principal;

    // 添加时间
    private String addtime;

    // 更新时间
    private String updtime;

    // 项目名称
    private String projectname;

    // 操作人
    private String operator;

    // 操作人名
    private String operatorname;

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

    public List<String> getDemandidlist() {
        return demandidlist;
    }

    public void setDemandidlist(List<String> demandidlist) {
        this.demandidlist = demandidlist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getDemandname() {
        return demandname;
    }

    public void setDemandname(String demandname) {
        this.demandname = demandname;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDemandcontent() {
        return demandcontent;
    }

    public void setDemandcontent(String demandcontent) {
        this.demandcontent = demandcontent;
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

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname;
    }

    @Override
    public String toString() {
        return "DemandRequest{" +
                "id='" + id + '\'' +
                ", projectid='" + projectid + '\'' +
                ", demandname='" + demandname + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", demandcontent='" + demandcontent + '\'' +
                ", principal='" + principal + '\'' +
                ", projectname='" + projectname + '\'' +
                ", addtime='" + addtime + '\'' +
                ", updtime='" + updtime + '\'' +
                ", operator='" + operator + '\'' +
                ", operatorname='" + operatorname + '\'' +
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
