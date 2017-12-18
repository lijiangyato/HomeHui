package com.ings.gogo.homehuiui.homehuiupdate.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:版本更新
*/

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuiupdate.view.IUpdateActivityView;
@Route(path = "/pdate/activi/UpdateActivityView", name = "版本更新")
public class UpdateActivityView extends AppCompatActivity implements IUpdateActivityView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdate_view);
    }



}
