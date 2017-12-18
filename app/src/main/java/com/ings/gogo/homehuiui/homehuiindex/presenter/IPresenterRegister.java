package com.ings.gogo.homehuiui.homehuiindex.presenter;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


public interface IPresenterRegister {
    /*@注册手机验证码*/
    void senCodePresenter(String phone, String verclassify);

    /*@手机校验码*/
    void setCheckPresenter(String phone, String code);

}
