package com.ings.gogo.homehuiui;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import android.content.Context;
import android.support.multidex.MultiDex;

public class Application extends BaseApplication {
    public static   Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;

    }
    /*@坚决依赖太多:超出65536*/
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
