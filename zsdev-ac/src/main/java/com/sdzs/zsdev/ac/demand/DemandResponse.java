package com.sdzs.zsdev.ac.demand;

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
public class DemandResponse {

    // 请求次数
    private String draw;

    // 总条数（不是本页的条数，是总条数）
    private String totalcount;

    //返回信息集合
    private Object demandlist;

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

    public Object getDemandlist() {
        return demandlist;
    }

    public void setDemandlist(Object demandlist) {
        this.demandlist = demandlist;
    }

    // 树
    public static class DemandTree{

        // 需求id
        private String id;

        // 关联项目id
        private String projectid;

        // 需求名称
        private String demandname;

        // 用户名称
        private String username;

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

        //返回集合
        private Object demandlist;

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

        public Object getDemandlist() {
            return demandlist;
        }

        public void setDemandlist(Object demandlist) {
            this.demandlist = demandlist;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getProjectname() {
            return projectname;
        }

        public void setProjectname(String projectname) {
            this.projectname = projectname;
        }

        @Override
        public String toString() {
            return "DemandListResponse{" +
                    "id='" + id + '\'' +
                    ", projectid='" + projectid + '\'' +
                    ", projectid='" + projectname + '\'' +
                    ", demandname='" + demandname + '\'' +
                    ", starttime='" + starttime + '\'' +
                    ", endtime='" + endtime + '\'' +
                    ", demandcontent='" + demandcontent + '\'' +
                    ", principal='" + principal + '\'' +
                    ", username='" + username + '\'' +
                    ", addtime='" + addtime + '\'' +
                    ", updtime='" + updtime + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DemandResponse{" +
                "draw='" + draw + '\'' +
                ", totalcount='" + totalcount + '\'' +
                ", demandlist=" + demandlist +
                '}';
    }
}
