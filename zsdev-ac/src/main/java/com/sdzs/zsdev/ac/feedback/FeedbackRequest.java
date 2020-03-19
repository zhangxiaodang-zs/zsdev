package com.sdzs.zsdev.ac.feedback;

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
public class FeedbackRequest {


    //任务反馈相关
    //反馈id
    private String id;

    // 反馈id数组
    private List<String> feedbackidlist;

    //反馈人id
    private String feedbackpersonid;

    //关联任务id
    private String taskid;

    //反馈内容
    private String feedbackcontent;

    //反馈时间
    private String feedbacktime;

    //消耗工时
    private String workinghours;

    //当日反馈进度
    private String feedschedule;

    // 实际开始时间
    private String actualsttime;

    // 实际结束时间
    private String actualentime;

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

    public String getFeedbackpersonid() {
        return feedbackpersonid;
    }

    public void setFeedbackpersonid(String feedbackpersonid) {
        this.feedbackpersonid = feedbackpersonid;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getFeedbackcontent() {
        return feedbackcontent;
    }

    public void setFeedbackcontent(String feedbackcontent) {
        this.feedbackcontent = feedbackcontent;
    }

    public String getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(String workinghours) {
        this.workinghours = workinghours;
    }

    public String getFeedschedule() {
        return feedschedule;
    }

    public void setFeedschedule(String feedschedule) {
        this.feedschedule = feedschedule;
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

    public String getFeedbacktime() {
        return feedbacktime;
    }

    public void setFeedbacktime(String feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    public List<String> getFeedbackidlist() {
        return feedbackidlist;
    }

    public void setFeedbackidlist(List<String> feedbackidlist) {
        this.feedbackidlist = feedbackidlist;
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

    @Override
    public String toString() {
        return "FeedbackRequest{" +
                "id='" + id + '\'' +
                ", feedbackpersonid='" + feedbackpersonid + '\'' +
                ", taskid='" + taskid + '\'' +
                ", feedbackcontent='" + feedbackcontent + '\'' +
                ", feedbacktime='" + feedbacktime + '\'' +
                ", workinghours='" + workinghours + '\'' +
                ", feedschedule='" + feedschedule + '\'' +
                ", currentpage='" + currentpage + '\'' +
                ", startindex='" + startindex + '\'' +
                ", pagesize='" + pagesize + '\'' +
                ", draw='" + draw + '\'' +
                '}';
    }
}
