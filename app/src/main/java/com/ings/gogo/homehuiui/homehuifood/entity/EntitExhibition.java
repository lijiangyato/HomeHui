package com.ings.gogo.homehuiui.homehuifood.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;

import java.io.Serializable;

public class EntitExhibition implements MultiItemEntity,Serializable{
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public int itemType;
    private String proid;
    private Object categoryid;
    private String proname;
    private String shortdesc;
    private int markprice;
    private int price;
    private int discount;
    private int stock;
    private Object proattri;
    private String imgurl;
    private Object proimages;
    private int num;
    public int tim;




    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTim(int tim) {
        this.tim = tim;
    }

    public int getTim() {
        return tim;
    }




    public String getProid() {
        return proid;
    }

    public Object getCategoryid() {
        return categoryid;
    }

    public String getProname() {
        return proname;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public int getMarkprice() {
        return markprice;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public Object getProattri() {
        return proattri;
    }

    public String getImgurl() {
        return imgurl;
    }

    public Object getProimages() {
        return proimages;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public void setCategoryid(Object categoryid) {
        this.categoryid = categoryid;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public void setMarkprice(int markprice) {
        this.markprice = markprice;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setProattri(Object proattri) {
        this.proattri = proattri;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public void setProimages(Object proimages) {
        this.proimages = proimages;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }



}
