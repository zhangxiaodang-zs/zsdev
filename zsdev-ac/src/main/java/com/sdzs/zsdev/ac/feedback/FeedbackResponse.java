package com.sdzs.zsdev.ac.feedback;

import java.util.List;

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
public class FeedbackResponse {

    // 请求次数
    private String draw;

    // 总条数（不是本页的条数，是总条数）
    private String totalcount;

    //返回角色信息集合
    private Object feedbacklist;

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public Object getFeedbacklist() {
        return feedbacklist;
    }

    public void setFeedbacklist(Object feedbacklist) {
        this.feedbacklist = feedbacklist;
    }

    // 主机构树
    public static class ProjectTree{

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

        //消耗工时
        private String workinghours;

        //当日反馈进度
        private String feedschedule;

        //反馈时间
        private String feedbacktime;

        //添加时间
        private String addtime;

        // 用户名称
        private String username;

        //更新时间
        private String updtime;

        //操作人
        private String operator;

        //返回集合
        private Object feedbacklist;

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

        public Object getFeedbacklist() {
            return feedbacklist;
        }

        public void setFeedbacklist(Object feedbacklist) {
            this.feedbacklist = feedbacklist;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "FeedbackListResponse{" +
                    "id='" + id + '\'' +
                    ", feedbackpersonid='" + feedbackpersonid + '\'' +
                    ", taskid='" + taskid + '\'' +
                    ", feedbackcontent='" + feedbackcontent + '\'' +
                    ", feedbacktime='" + feedbacktime + '\'' +
                    ", username='" + username + '\'' +
                    ", workinghours='" + workinghours + '\'' +
                    ", feedschedule='" + feedschedule + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FeedbackResponse{" +
                "draw='" + draw + '\'' +
                ", totalcount='" + totalcount + '\'' +
                ", feedbacklist=" + feedbacklist +
                '}';
    }
}
