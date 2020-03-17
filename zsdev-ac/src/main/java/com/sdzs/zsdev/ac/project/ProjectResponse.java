package com.sdzs.zsdev.ac.project;

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
public class ProjectResponse {

    // 请求次数
    private String draw;

    // 总条数（不是本页的条数，是总条数）
    private String totalcount;

    //返回角色信息集合
    private Object projectlist;

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

    public Object getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(Object projectlist) {
        this.projectlist = projectlist;
    }

    // 主机构树
    public static class ProjectTree{

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

        //返回集合
        private Object projectlist;

        public Object getProjectlist() {
            return projectlist;
        }

        public void setProjectlist(Object projectlist) {
            this.projectlist = projectlist;
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

        @Override
        public String toString() {
            return "ProjectListResponse{" +
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
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrganResponse{" +
                "draw='" + draw + '\'' +
                ", totalcount='" + totalcount + '\'' +
                ", projectlist=" + projectlist +
                '}';
    }
}
