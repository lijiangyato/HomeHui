package com.ings.gogo.homehuiui.homehuiindex.Entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class EntityIndexAdd implements MultiItemEntity {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVEN = 7;
    public static final int TYPE_EIGHT = 8;
    public static final int TYPE_NINE = 9;
    public static  final int TYPE_TEN=10;


     //地址
    private String address;
    //积分
    private String integr;
    //更新
    private String update;
    //推荐
    private String recommend;

    public String getAddress() {
        return address;
    }

    public String getIntegr() {
        return integr;
    }

    public void setIntegr(String integr) {
        this.integr = integr;
    }

    public String getUpdate() {
        return update;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setUpdate(String update) {
        this.update = update;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public int itemType;
    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


}
