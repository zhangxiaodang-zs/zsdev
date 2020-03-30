package com.sdzs.zsdev.ac.demand;

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

        // 预计开始时间
        private String starttime;

        // 预计结束时间
        private String endtime;

        // 实际开始时间
        private String actualsttime;

        // 实际结束时间
        private String actualentime;

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

        // 状态
        private String status;

        //附件id
        private String fileid;

        //附件名称
        private String filename;

        // 操作人
        private String operator;

        // 操作人名
        private String operatorname;

        //附件路径
        private String filepath;

        //附件列表
        private List<String> projectUpload;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "DemandListResponse{" +
                    "id='" + id + '\'' +
                    ", projectid='" + projectid + '\'' +
                    ", projectname='" + projectname + '\'' +
                    ", demandname='" + demandname + '\'' +
                    ", starttime='" + starttime + '\'' +
                    ", endtime='" + endtime + '\'' +
                    ", actualsttime='" + actualsttime + '\'' +
                    ", actualentime='" + actualentime + '\'' +
                    ", demandcontent='" + demandcontent + '\'' +
                    ", principal='" + principal + '\'' +
                    ", username='" + username + '\'' +
                    ", addtime='" + addtime + '\'' +
                    ", updtime='" + updtime + '\'' +
                    ", fileid='" + fileid + '\'' +
                    ", filepath='" + filepath + '\'' +
                    ", filename='" + filename + '\'' +
                    ", operator='" + operator + '\'' +
                    ", operatorname='" + operatorname + '\'' +
                    ", status='" + status + '\'' +
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
