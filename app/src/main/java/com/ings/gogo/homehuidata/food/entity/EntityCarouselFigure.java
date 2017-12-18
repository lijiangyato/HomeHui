package com.ings.gogo.homehuidata.food.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:轮播图
*/

import java.util.List;

public class EntityCarouselFigure {


    /**
     * success : false
     * msg : null
     * data : [{"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-11/ceebe925-9b00-427d-9d5d-a7a16b53cb94.jpg","adstitle":null,"adslink":"#"},{"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-11/732d2ec0-aa47-4e28-8cb2-42dda1252ed2.jpg","adstitle":null,"adslink":"#"},{"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-11/24d5dd2f-09b9-4abc-9988-681513c19cce.jpg","adstitle":null,"adslink":"#"}]
     */

    private boolean success;
    private Object msg;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * imgurl : http://file.qiafanlou.com/upfile/gogo/2017-11/ceebe925-9b00-427d-9d5d-a7a16b53cb94.jpg
         * adstitle : null
         * adslink : #
         */

        private String imgurl;
        private Object adstitle;
        private String adslink;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public Object getAdstitle() {
            return adstitle;
        }

        public void setAdstitle(Object adstitle) {
            this.adstitle = adstitle;
        }

        public String getAdslink() {
            return adslink;
        }

        public void setAdslink(String adslink) {
            this.adslink = adslink;
        }
    }
}
