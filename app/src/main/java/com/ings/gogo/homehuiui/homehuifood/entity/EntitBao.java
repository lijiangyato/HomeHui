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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EntitBao {
    @SerializedName("proid_id")
    @Expose
    private String proid;
    @SerializedName("categoryid_di")
    @Expose
    private Object categoryid;
    @SerializedName("proname_id")
    @Expose
    private String proname;
    @SerializedName("shortdesc_di")
    @Expose
    private String shortdesc;
    @SerializedName("markprice_id")
    @Expose
    private int markprice;
    @SerializedName("pricd_id")
    @Expose
    private int price;
    @SerializedName("discount_id")
    @Expose
    private int discount;
    @SerializedName("stock_id")
    @Expose
    private int stock;
    @SerializedName("proattri_id")
    @Expose
    private Object proattri;
    @SerializedName("imgurl_id")
    @Expose
    private String imgurl;
    @SerializedName("proimages_id")
    @Expose
    private Object proimages;
    @SerializedName("num_id")
    @Expose
    private int num;
    @SerializedName("tim_id")
    @Expose
    public int tim;




    public void setTim(int tim) {
        this.tim = tim;
    }

    public int getTim() {
        return tim;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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




}
