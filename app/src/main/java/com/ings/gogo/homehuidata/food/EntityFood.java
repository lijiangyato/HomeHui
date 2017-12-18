package com.ings.gogo.homehuidata.food;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:首页商品详情
*/


import java.util.List;

public class EntityFood {


    /**
     * success : false
     * msg : null
     * data : [{"proid":"542a65e2-1b76-43d9-be0c-41118d80f55d","categoryid":null,"proname":"回锅肉饭","shortdesc":"含米饭、主菜、副菜","markprice":13,"price":13,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_cdce1d6a-61a5-446b-9967-e8e1e5d8c44a_250x250.jpg","proimages":null},{"proid":"645d4a91-7867-4a41-bd55-ecaf0441020c","categoryid":null,"proname":"土豆焖鸭饭","shortdesc":"含米饭、主菜、副菜","markprice":15,"price":15,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_f0029365-858c-4bc6-997d-8b95b2544883_250x250.jpg","proimages":null},{"proid":"cb9d3c16-ae75-4cbf-95e9-13eee457aa07","categoryid":null,"proname":"宫保肉丁饭","shortdesc":"含米饭、主菜、副菜","markprice":14,"price":14,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_3119d23d-28c5-4f42-a367-fdaf7b4210b8_250x250.jpg","proimages":null},{"proid":"6347e2cc-afec-4e43-8364-ff7264f8f0be","categoryid":null,"proname":"蜜汁叉鹅饭","shortdesc":"含米饭、主菜、副菜","markprice":23,"price":23,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_96d571c5-f0b7-456a-a17f-4d57e2042c17_250x250.jpg","proimages":null},{"proid":"f342556a-ffe4-4645-a1d5-7454de9e9a85","categoryid":null,"proname":"农家酿三宝饭","shortdesc":"含米饭、主菜、副菜","markprice":14,"price":14,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-11/thumb_8ae7502c-7e32-4771-9459-36224bffa5c3_250x250.jpg","proimages":null},{"proid":"6e2453e8-c677-4541-89c0-b674662485c6","categoryid":null,"proname":"香芋扣肉饭","shortdesc":"含米饭、主菜、副菜","markprice":16,"price":16,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_2d126e64-041d-4a14-bab9-9a4b7e37f1d9_250x250.jpg","proimages":null},{"proid":"7e7dd0c8-61c2-42ea-83f5-98a07772fa86","categoryid":null,"proname":"豉汁排骨饭","shortdesc":"含米饭、主菜、副菜","markprice":16,"price":16,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_91f4726a-4885-4f87-800e-6ca5fb6f7fab_250x250.jpg","proimages":null},{"proid":"9bde2423-eb9d-4fa4-8ab6-2fc0bd5d89b2","categoryid":null,"proname":"烧鹅饭","shortdesc":"含米饭、主菜、副菜","markprice":27,"price":27,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_038178fd-859c-4dd3-ab6f-f5192e7391f0_250x250.jpg","proimages":null},{"proid":"05f84f79-46e6-41d1-b8e5-f89e5b06ff40","categoryid":null,"proname":"香菇滑鸡饭","shortdesc":"含米饭、主菜、副菜","markprice":18,"price":18,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_1107ae44-7251-4480-9ec6-c3ba259eb785_250x250.jpg","proimages":null},{"proid":"0e037b49-f031-41b0-ac71-67aff16d8e8b","categoryid":null,"proname":"盐菜肉饭","shortdesc":"含米饭、主菜、副菜","markprice":16,"price":16,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_d2005a16-7b91-47d7-853c-1c8887a4d0db_250x250.jpg","proimages":null},{"proid":"21437e52-a8e8-4727-913f-f0607b077b41","categoryid":null,"proname":"烧鸭饭","shortdesc":"含米饭、主菜、副菜","markprice":19,"price":19,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_c1380edd-412c-4028-9b86-4b6bacf2cf59_250x250.jpg","proimages":null},{"proid":"2ad431a2-5168-4d88-890f-cf75feae22bb","categoryid":null,"proname":"三杯鸡饭","shortdesc":"含米饭、主菜、副菜","markprice":16,"price":16,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_85cb2ee2-7e70-4f8d-a07d-4d36bee8d2e1_250x250.jpg","proimages":null},{"proid":"2e6728e5-655d-4685-ab26-aafb8789ba1e","categoryid":null,"proname":"辣子鸡饭","shortdesc":"含米饭、主菜、副菜","markprice":16,"price":16,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_2e1b8a3c-21d9-4def-892a-83a56ae72838_250x250.jpg","proimages":null},{"proid":"f253c63b-1e27-4a5e-a666-b4151ec68a9c","categoryid":null,"proname":"团体定制套餐（10份起订）","shortdesc":"含米饭、两个主菜、炖汤一份、副菜、蔬菜，菜品每日更新，需提前一日下单（团体套餐不享受9.5折优惠）","markprice":25,"price":25,"discount":0,"stock":0,"proattri":null,"imgurl":"http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_f46ba757-d796-4cec-b140-581a8b7a6e38_250x250.jpg","proimages":null}]
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
         * proid : 542a65e2-1b76-43d9-be0c-41118d80f55d
         * categoryid : null
         * proname : 回锅肉饭
         * shortdesc : 含米饭、主菜、副菜
         * markprice : 13
         * price : 13
         * discount : 0
         * stock : 0
         * proattri : null
         * imgurl : http://file.qiafanlou.com/upfile/gogo/2017-10/thumb_cdce1d6a-61a5-446b-9967-e8e1e5d8c44a_250x250.jpg
         * proimages : null
         */

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

        public String getProid() {
            return proid;
        }

        public void setProid(String proid) {
            this.proid = proid;
        }

        public Object getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(Object categoryid) {
            this.categoryid = categoryid;
        }

        public String getProname() {
            return proname;
        }

        public void setProname(String proname) {
            this.proname = proname;
        }

        public String getShortdesc() {
            return shortdesc;
        }

        public void setShortdesc(String shortdesc) {
            this.shortdesc = shortdesc;
        }

        public int getMarkprice() {
            return markprice;
        }

        public void setMarkprice(int markprice) {
            this.markprice = markprice;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public Object getProattri() {
            return proattri;
        }

        public void setProattri(Object proattri) {
            this.proattri = proattri;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public Object getProimages() {
            return proimages;
        }

        public void setProimages(Object proimages) {
            this.proimages = proimages;
        }
    }
}
