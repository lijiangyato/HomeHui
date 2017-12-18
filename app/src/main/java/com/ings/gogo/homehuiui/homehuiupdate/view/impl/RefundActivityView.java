package com.ings.gogo.homehuiui.homehuiupdate.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
@Route(path = "/pdate/activi/RefundActivityView", name = "退款销售")

public class RefundActivityView extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_vew);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
