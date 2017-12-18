package com.ings.gogo.homehuidata.db.surface;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "add")
public class SurfaceModeldb1 {


    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;

    @SerializedName("pullname_at")
    @Property(nameInDb = "pullname_at")
    public String pullname;

    @SerializedName("pender_at")
    @Property(nameInDb = "pender_at")
    public String pender;


    @SerializedName("number_at")
    @Property(nameInDb = "number_at")
    public String number;

    @SerializedName("detailedaddress_at")
    @Property(nameInDb = "detailedaddress_at")
    public String detailedaddress;

    @SerializedName("remarks_at")
    @Property(nameInDb = "remarks_at")
    public String remarks;

    @Generated(hash = 91485941)
    public SurfaceModeldb1(Long id, String pullname, String pender, String number,
            String detailedaddress, String remarks) {
        this.id = id;
        this.pullname = pullname;
        this.pender = pender;
        this.number = number;
        this.detailedaddress = detailedaddress;
        this.remarks = remarks;
    }

    @Generated(hash = 1942415528)
    public SurfaceModeldb1() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPullname() {
        return this.pullname;
    }

    public void setPullname(String pullname) {
        this.pullname = pullname;
    }

    public String getPender() {
        return this.pender;
    }

    public void setPender(String pender) {
        this.pender = pender;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDetailedaddress() {
        return this.detailedaddress;
    }

    public void setDetailedaddress(String detailedaddress) {
        this.detailedaddress = detailedaddress;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



}
