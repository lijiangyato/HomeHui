package com.ings.gogo.homehuiui.homehuipersonal.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:个人中心
*/

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuibase.BaseFragment;

@Route(path = "/Personal/Fragment/PersonalFragmentView",name ="个人中心")
public class PersonalFragmentView extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.personal_fragmentvie;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
