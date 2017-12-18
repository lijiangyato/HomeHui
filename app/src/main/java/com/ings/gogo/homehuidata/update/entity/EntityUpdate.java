package com.ings.gogo.homehuidata.update.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

public class EntityUpdate {

    /**
     * success : true
     * msg :
     * data : {"versiondigit":11,"versionno":"1.0.2","download":"http://file.qiafanlou.com/upfile/gogo/qiafanlou.apk","mark":"1：修复部分手机号段格式校验失败导致不能接收短信验证码的问题*2：修复部分信息提示出现乱码的问题","updateflag":0}
     */

    private boolean success;
    private String msg;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * versiondigit : 11
         * versionno : 1.0.2
         * download : http://file.qiafanlou.com/upfile/gogo/qiafanlou.apk
         * mark : 1：修复部分手机号段格式校验失败导致不能接收短信验证码的问题*2：修复部分信息提示出现乱码的问题
         * updateflag : 0
         */

        private int versiondigit;
        private String versionno;
        private String download;
        private String mark;
        private int updateflag;

        public int getVersiondigit() {
            return versiondigit;
        }

        public void setVersiondigit(int versiondigit) {
            this.versiondigit = versiondigit;
        }

        public String getVersionno() {
            return versionno;
        }

        public void setVersionno(String versionno) {
            this.versionno = versionno;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public int getUpdateflag() {
            return updateflag;
        }

        public void setUpdateflag(int updateflag) {
            this.updateflag = updateflag;
        }
    }
}
