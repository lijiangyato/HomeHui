package com.ings.gogo.homehuiui.homehuibase.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuibase.view.ISchemeFilterActivityView;

public class SchemeFilterActivityView extends BaseActivity implements ISchemeFilterActivityView{
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        ARouter.getInstance().build(uri).navigation(this, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                finish();
            }

            @Override
            public void onLost(Postcard postcard) {
                finish();
            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                finish();
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

}
