package com.sdzs.zsdev.ac.task;

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
public class TaskResponse {

    // 请求次数
    private String draw;

    // 总条数（不是本页的条数，是总条数）
    private String totalcount;

    //返回角色信息集合
    private Object tasklist;

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

    public Object getTasklist() {
        return tasklist;
    }

    public void setTasklist(Object tasklist) {
        this.tasklist = tasklist;
    }

    // 主机构树
    public static class ProjectTree{

        // 任务id
        private String id;

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

        // 任务介绍
        private String taskcontent;

        // 用户名称
        private String username;

        // 工时
        private String workhours;

        // 任务负责人
        private String principal;

        // 任务进度
        private String schedule;

        // 添加时间
        private String addtime;

        // 更新时间
        private String updtime;

        // 关联需求名称
        private String demandname;

        //返回集合
        private Object tasklist;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public Object getTasklist() {
            return tasklist;
        }

        public void setTasklist(Object tasklist) {
            this.tasklist = tasklist;
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
            return "TaskListResponse{" +
                    "taskid='" + id + '\'' +
                    ", taskname='" + taskname + '\'' +
                    ", demandname='" + demandname + '\'' +
                    ", expectedsttime='" + expectedsttime + '\'' +
                    ", expectedentime='" + expectedentime + '\'' +
                    ", actualsttime='" + actualsttime + '\'' +
                    ", actualentime='" + actualentime + '\'' +
                    ", taskcontent='" + taskcontent + '\'' +
                    ", workhours='" + workhours + '\'' +
                    ", principal='" + principal + '\'' +
                    ", username='" + username + '\'' +
                    ", schedule='" + schedule + '\'' +
                    ", addtime='" + addtime + '\'' +
                    ", updtime='" + updtime + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TaskResponse{" +
                "draw='" + draw + '\'' +
                ", totalcount='" + totalcount + '\'' +
                ", tasklist=" + tasklist +
                '}';
    }
}
