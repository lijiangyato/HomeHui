package com.ings.gogo.homehuiui.homehuifood.holder;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.view.View;



import com.chad.library.adapter.base.BaseViewHolder;
import com.flyco.tablayout.CommonTabLayout;

import com.ings.gogo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HoldOption extends BaseViewHolder {
    @BindView(R.id.name_commonTablayout_id)
    public CommonTabLayout nameCommonTablayoutId;

    public HoldOption(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
