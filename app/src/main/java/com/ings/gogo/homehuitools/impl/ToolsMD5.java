package com.ings.gogo.homehuitools.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/11/7.
@作用:
*/

import java.math.BigInteger;
import java.security.MessageDigest;

public class ToolsMD5 {

    public static String MD5(String string) {
        return encodeMD5String(string);
    }

    public static String encodeMD5String(String str) {
        return encode(str, "MD5");
    }

    private static String encode(String str, String method) {
        MessageDigest md = null;
        String dstr = null;
        try {
            md = MessageDigest.getInstance(method);
            md.update(str.getBytes());
            dstr = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dstr;
    }
}
