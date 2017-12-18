package com.ings.gogo.homehuidata.db.surface;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/



import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitExhibition;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity(nameInDb = "commodity")
public class SurfaceModeldb0{
     @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;
    @SerializedName("proid_at")
    @Property(nameInDb = "proid_at")
    private String proid;

    /*@Property(nameInDb = "categoryid_at")
    private Object categoryid;*/
    @SerializedName("proname_at")
    @Property(nameInDb ="proname_at")
    private String proname;

    @SerializedName("shortdese_at")
    @Property(nameInDb ="shortdese_at")
    private String shortdesc;

    @SerializedName("markprice_at")
    @Property(nameInDb = "markprice_at")
    private int markprice;

    @SerializedName("price_at")
    @Property(nameInDb ="price_at")
    private int price;

    @SerializedName("discount_at")
    @Property(nameInDb = "discount_at")
    private int discount;
    @SerializedName("stock_at")
    @Property(nameInDb = "stock_at")
    private int stock;

   /* @Property(nameInDb = "proattri_at")
    private Object proattri;*/
   @SerializedName("imgurl")
    @Property(nameInDb = "imgurl")
    private String imgurl;

    @Generated(hash = 1750390550)
    public SurfaceModeldb0(Long id, String proid, String proname, String shortdesc,
            int markprice, int price, int discount, int stock, String imgurl) {
        this.id = id;
        this.proid = proid;
        this.proname = proname;
        this.shortdesc = shortdesc;
        this.markprice = markprice;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.imgurl = imgurl;
    }

    @Generated(hash = 340570245)
    public SurfaceModeldb0() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProid() {
        return this.proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public String getProname() {
        return this.proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getShortdesc() {
        return this.shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public int getMarkprice() {
        return this.markprice;
    }

    public void setMarkprice(int markprice) {
        this.markprice = markprice;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgurl() {
        return this.imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }


}
