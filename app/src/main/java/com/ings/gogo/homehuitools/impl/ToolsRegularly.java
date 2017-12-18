package com.ings.gogo.homehuitools.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/11/7.
@作用:正则表达式
*/

public class ToolsRegularly {

    /**
     * 禁止实例化
     */
    private ToolsRegularly() {
        throw new UnsupportedOperationException("禁止实例化");
    }

    /**
     * 是否为手机号码
     */
    public static boolean isPhone(String mobiles) {
        Pattern p = Pattern.compile("^(0|86|17951)?(13\\d|15\\d|17[1678]|18\\d|14[57])\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断姓名（只判断汉字2-4位）
     */
    public static boolean isActuaName(String name) {
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]{2,4}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    /**
     * 判断是否为企业（只判断汉字2-16位）
     */
    public static boolean isEntName(String name) {
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]{2,16}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    /**
     * 密码强度判断（由6-21字母和数字组成，不能是纯数字或纯英文）
     */
    public static boolean isPassword(String pass) {
        Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
        Matcher m = p.matcher(pass);
        return m.matches();
    }

    /**
     * 验证码（验证6位数字）
     */
    public static boolean isVerCode(String code) {
        Pattern p = Pattern.compile("^\\d{4}$");
        Matcher m = p.matcher(code);
        return m.matches();
    }

}
