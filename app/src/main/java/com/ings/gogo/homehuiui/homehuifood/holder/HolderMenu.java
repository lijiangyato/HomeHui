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

public class HolderMenu extends BaseViewHolder {

    @BindView(R.id.name_imguri_id)
    public ImageView nameImguriId;
    @BindView(R.id.name_thedishes_id)
    public TextView nameThedishesId;
    @BindView(R.id.name_Price_id)
    public TextView namePriceId;
    @BindView(R.id.name_Number_id)
    public TextView nameNumberId;
    public HolderMenu(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
