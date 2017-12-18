package com.ings.gogo.homehuiui.homehuiaddress.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class EntityAddress implements MultiItemEntity {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVEN = 7;
    public int itemType;
    //姓名
    public String fullname;
    //电话号码
    public String number;
    //小区
    public String quarters;
    //楼房
    public String building;
    public String Returndiz;

    public String getReturndiz() {
        return Returndiz;
    }

    public void setReturndiz(String returndiz) {
        Returndiz = returndiz;
    }



    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setQuarters(String quarters) {
        this.quarters = quarters;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFullname() {
        return fullname;
    }

    public String getNumber() {
        return number;
    }

    public String getQuarters() {
        return quarters;
    }

    public String getBuilding() {
        return building;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}