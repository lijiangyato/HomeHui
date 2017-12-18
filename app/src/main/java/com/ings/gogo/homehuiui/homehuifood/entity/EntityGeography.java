package com.ings.gogo.homehuiui.homehuifood.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

public class EntityGeography {

    private  String address;
    private  String content;
    //纬度
    private double mLatitude;
    //经度
    private double mLongitude;


    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public double getmLongitude() {

        return mLongitude;
    }



    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
