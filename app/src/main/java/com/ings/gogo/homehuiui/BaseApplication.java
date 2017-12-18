package com.ings.gogo.homehuiui;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.homehuihttp.HttpRetrrofi;
import com.ings.gogo.homehuihttp.constant.Constant;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

public class BaseApplication extends MultiDexApplication {

    private static final String WEIXIN_APPID = "wxe60e448be4f7bda2";

    //public  static  IWXAPI iwxapi;
    @Override
    public void onCreate() {
        super.onCreate();
        //路由
        initARouter();
        //网络
        initNet();
        //activity右滑动
        initBGASwipeBackManager();
    }

    /*初始化activity右滑关闭页面*/
    private void initBGASwipeBackManager() {
        BGASwipeBackManager.getInstance().init(this);
    }

    /*初始化ARouter*/
    private void initARouter() {
        //打印日志
        ARouter.openLog();
        if (Constant.isDebug)
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        ARouter.init(this);

    }

    /*初始化网络*/
    private void initNet() {
        HttpRetrrofi.init((Application) this);
    }

    /*初始Bugly崩溃日志收集*/
    // TODO: 2017/11/10
    private void initBugly() {
        if (!Constant.isDebug) {

        }
    }

    /*初始化微信*/
    private void regTowx() {

    }
}
