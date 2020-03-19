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
                ", addtime='" + addtime + '\'' +
                ", updtime='" + updtime + '\'' +
                ", currentpage='" + currentpage + '\'' +
                ", startindex='" + startindex + '\'' +
                ", pagesize='" + pagesize + '\'' +
                ", draw='" + draw + '\'' +
                '}';
    }
}
