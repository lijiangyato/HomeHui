package com.ings.gogo.homehuiui.homehuiconsult.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:咨询
*/

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuibase.BaseFragment;

@Route(path = "/Consul/Fragment/ConsultFragmentView",name ="咨询")
public class ConsultFragmentView extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_consult_view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
