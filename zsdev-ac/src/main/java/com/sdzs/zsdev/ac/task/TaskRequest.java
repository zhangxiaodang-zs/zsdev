package com.sdzs.zsdev.ac.task;

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
public class TaskRequest {

    // uuid，主键
    private String id;

    // 机构id数组
    private List<String> taskidlist;

    // 关联需求id
    private String demandid;

    // 任务名称
    private String taskname;

    // 预计开始时间
    private String expectedsttime;

    // 预计结束时间
    private String expectedentime;

    // 实际开始时间
    private String actualsttime;

    // 实际结束时间
    private String actualentime;

    // 实际结束时间
    private String workhours;

    // 任务介绍
    private String taskcontent;

    // 任务负责人
    private String principal;

    // 任务进度
    private String schedule;

    // 添加时间
    private String addtime;

    // 更新时间
    private String updtime;

    // 操作人
    private String operator;

    // 用户名称
    private String username;

    // 关联需求名称
    private String demandname;

    // 当前页码，如果等于空，表示不分页
    private String currentpage;

    // 开始检索index
    private String startindex;

    // 每页显示条数，如果等于空，表示不分页
    private String pagesize;

    // 请求次数
    private String draw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTaskidlist() {
        return taskidlist;
    }

    public void setTaskidlist(List<String> taskidlist) {
        this.taskidlist = taskidlist;
    }

    public String getDemandid() {
        return demandid;
    }

    public void setDemandid(String demandid) {
        this.demandid = demandid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
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

    public String getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(String taskcontent) {
        this.taskcontent = taskcontent;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
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

    public String getWorkhours() {
        return workhours;
    }

    public void setWorkhours(String workhours) {
        this.workhours = workhours;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDemandname() {
        return demandname;
    }

    public void setDemandname(String demandname) {
        this.demandname = demandname;
    }

    @Override
    public String toString() {
        return "TaskRequest{" +
                "taskid='" + id + '\'' +
                ", taskname='" + taskname + '\'' +
                ", demandname='" + demandname + '\'' +
                ", expectedsttime='" + expectedsttime + '\'' +
                ", expectedentime='" + expectedentime + '\'' +
                ", actualsttime='" + actualsttime + '\'' +
                ", actualentime='" + actualentime + '\'' +
                ", taskcontent='" + taskcontent + '\'' +
                ", principal='" + principal + '\'' +
                ", schedule='" + schedule + '\'' +
                ", workhours='" + workhours + '\'' +
                ", addtime='" + addtime + '\'' +
                ", updtime='" + updtime + '\'' +
                ", currentpage='" + currentpage + '\'' +
                ", startindex='" + startindex + '\'' +
                ", pagesize='" + pagesize + '\'' +
                ", draw='" + draw + '\'' +
                '}';
    }
}
