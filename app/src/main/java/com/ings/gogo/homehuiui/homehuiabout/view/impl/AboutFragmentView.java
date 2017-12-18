package com.ings.gogo.homehuiui.homehuiabout.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuiabout.view.IAboutFragmentView;
import com.ings.gogo.homehuiui.homehuibase.BaseFragment;

@Route(path = "/about/Fragment/AboutFragmentView",name ="关于")
public class AboutFragmentView extends BaseFragment implements IAboutFragmentView{
    @Override
    protected int getLayoutId() {
        return R.layout.about_fragment_view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
