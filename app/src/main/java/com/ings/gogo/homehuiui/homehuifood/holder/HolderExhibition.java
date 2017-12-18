package com.ings.gogo.homehuiui.homehuifood.holder;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.ings.gogo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderExhibition extends BaseViewHolder {

    @BindView(R.id.name_unitPrice_id)
    public TextView nameUnitPriceId;
    @BindView(R.id.name_money_id)
    public TextView nameMoneyId;
    @BindView(R.id.name_reduce_id)
    public ImageView nameReduceId;
    @BindView(R.id.name_number_id)
    public TextView nameNumberId;
    @BindView(R.id.name_plus_id)
    public ImageView namePlusId;

    public HolderExhibition(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
