package com.ings.gogo.homehuihttp.constant;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:恰饭喽API
*/

public class Constant {
    //正式服务器
    public static String BASE_URL = "http://api.qiafanlou.com/app/";
    public static boolean DOOBA = false;
    public static boolean DOOBC = true;
    //测试服务器
    public static final String BASEDEBUG_URL = "http://www.imooc.com/api/";
    public static final boolean isDebug = false;//是否是测试版本
    // 获取轮播图
    public static final String GET_ADS_PIC = BASE_URL + "getads?";
    // 获取过渡页
    public static final String GET_WECOM_BG = BASE_URL + "getads?adstype=2";
    public static final String GET_PRODUCTS_LIST = BASE_URL + "getproducts?pointid=";
    public static String GET_DETAIL_FOODSURL = BASE_URL + "getproductinfo?proid=";

    public static final String GET_GOODS_GETCATEGORY = BASE_URL + "getcategorys?parentid=b4e19459-95b0-4e44-9066-91e512730240";
    //购物车详情例表参数
    public static final String GET_FAST_PRODUCTS = BASE_URL;
    //public static final String GET_FAST_PRODUCTS = BASE_URL + "getproducts?pointid=";
    // 获取净菜列表
    public static final String GET_CLEAN_LISt = BASE_URL + "getproducts?pointid=";
    // 获取验证码
    public static final String GET_SMS_MSG = BASE_URL;
    // 注册
    public static final String REGIST_URL = BASE_URL + "register";
    // 校验验证码
    public static final String CHECK_SMS_MSG = BASE_URL;
    // 登录
    public static final String LOGIN_URL = BASE_URL;
    // 重置密码
    public static final String RESET_URL = BASE_URL + "resetpwd";
    // 获取地址信息列表
    public static final String GET_ADDRESS_DATA = BASE_URL + "getconsignees";
    // 添加地址信息
    public static final String ADD_ADDRESS_DATA = BASE_URL + "subconsignees";
    // 删除地址信息
    public static final String DELETE_ADDRESS_DATA = BASE_URL + "deleconsignee?consigneeid=";
    // 获取详细地址信息
    public static final String GET_DETAIL_ADDRESS_DATA = BASE_URL + "consigneeinfo?consigneeid=";
    // 获取时间段
    public static final String GET_TIME = BASE_URL + "gettimespans?istoday=";
    // 获取积分总数
    public static final String GET_TOTAL_SCORE = BASE_URL + "getscoreinfo";
    // 提交订单
    public static final String SUBMIT_ORDER = BASE_URL + "suborders";
    // 获取积分明细
    public static final String GET_SCORE_MSG = BASE_URL + "getscores";
    // 检查库存量
    public static final String CHECK_STOCK = BASE_URL + "checkstock";
    // 支付之前的检查
    public static final String CHECK_PAY = BASE_URL + "suborderpay";
    // 获取订单列表
    public static final String GET_ORDER_LIST = BASE_URL + "getorders";

    // 获取订单详情
    public static final String GET_DETAIL_ORDER = BASE_URL + "getorderinfo?orderno=";
    // 取消 删除 订单
    public static final String CANCEL_ORDER = BASE_URL + "cancelorder";
    // 获取订单转台的值
    public static final String GET_ORDER_STATE = BASE_URL + "getstatecount";

    public static final String GET_DIFFERENT_STATE = BASE_URL + "getorders?state=";
    // 检查 版本更新
    public static final String APP_UPDATE = BASE_URL;
    //public static final String APP_UPDATE = BASE_URL + "getversion?plat=android";
    // 退出登录Logout
    public static final String EXIT_APP = BASE_URL + "Logout";

    public static final String TYPE_ONE = "merchant.db";
    public static final String TYPE_TWO = "add.db";

}
