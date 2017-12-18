package com.ings.gogo.homehuidata.index.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

public class EntityPassword {
    // "success":false,
    // "msg":"验证失败",
    // "data":null,
    // "code":null
    // "success":true,
    // "msg":"3abf00fa61bfae2fff9133375e142416",
    // "data":null
    private Boolean success;
    private String msg;
    private String data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
