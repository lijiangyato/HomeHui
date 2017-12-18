package com.ings.gogo.homehuidata.food.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import java.util.List;

public class EntityPoints {


    /**
     * success : false
     * msg : null
     * data : [{"tips":"免费配送","gpsy":"26.604326","paylater":"0","maplocation":"0","phone":"15186507846","gpsx":"106.581269","ranges":1000,"pointid":"068cceb8-0240-423a-befb-c3fa5d4ae85f","pointaddress":"贵阳市观山湖区宾阳大道杭州路1号","groupman":"李洪占","pointname":"西南国际商贸城"},{"tips":"免费配送","gpsy":"26.640588","paylater":"0","maplocation":"0","phone":"15186507846","gpsx":"106.649835","ranges":1000,"pointid":"17fb70c8-beea-46b8-b53b-e2e0c1644425","pointaddress":"观山湖区-美的林城时代-财智中心","groupman":"李洪占","pointname":"会展城商圈"},{"tips":"免费配送","gpsy":"26.606058","paylater":"0","maplocation":"0","phone":"15285066468","gpsx":"106.632159","ranges":1600,"pointid":"411de4d8-52a8-4353-99d1-a782069ff865","pointaddress":"观山湖区-世纪城","groupman":"刘天左","pointname":"世纪城商圈"},{"tips":"免费配送","gpsy":"26.543009","paylater":"0","maplocation":"0","phone":"18184112415","gpsx":"106.776328","ranges":1000,"pointid":"89adaa41-3409-42ae-82ff-8fd070a7e627","pointaddress":"南明区 机场路 太升国际","groupman":"黄立清","pointname":"太升国际商圈"}]
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
         * tips : 免费配送
         * gpsy : 26.604326
         * paylater : 0
         * maplocation : 0
         * phone : 15186507846
         * gpsx : 106.581269
         * ranges : 1000
         * pointid : 068cceb8-0240-423a-befb-c3fa5d4ae85f
         * pointaddress : 贵阳市观山湖区宾阳大道杭州路1号
         * groupman : 李洪占
         * pointname : 西南国际商贸城
         */

        private String tips;
        private String gpsy;
        private String paylater;
        private String maplocation;
        private String phone;
        private String gpsx;
        private int ranges;
        private String pointid;
        private String pointaddress;
        private String groupman;
        private String pointname;

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public String getGpsy() {
            return gpsy;
        }

        public void setGpsy(String gpsy) {
            this.gpsy = gpsy;
        }

        public String getPaylater() {
            return paylater;
        }

        public void setPaylater(String paylater) {
            this.paylater = paylater;
        }

        public String getMaplocation() {
            return maplocation;
        }

        public void setMaplocation(String maplocation) {
            this.maplocation = maplocation;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getGpsx() {
            return gpsx;
        }

        public void setGpsx(String gpsx) {
            this.gpsx = gpsx;
        }

        public int getRanges() {
            return ranges;
        }

        public void setRanges(int ranges) {
            this.ranges = ranges;
        }

        public String getPointid() {
            return pointid;
        }

        public void setPointid(String pointid) {
            this.pointid = pointid;
        }

        public String getPointaddress() {
            return pointaddress;
        }

        public void setPointaddress(String pointaddress) {
            this.pointaddress = pointaddress;
        }

        public String getGroupman() {
            return groupman;
        }

        public void setGroupman(String groupman) {
            this.groupman = groupman;
        }

        public String getPointname() {
            return pointname;
        }

        public void setPointname(String pointname) {
            this.pointname = pointname;
        }
    }
}
