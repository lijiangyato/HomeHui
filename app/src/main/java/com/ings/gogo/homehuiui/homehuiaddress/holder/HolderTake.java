package com.ings.gogo.homehuiui.homehuiaddress.holder;
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

public class HolderTake extends BaseViewHolder {

    @BindView(R.id.name_click_id)
   public TextView nameClickId;
    @BindView(R.id.name_Icon_id)
    public ImageView nameIconId;
    @BindView(R.id.name_mapview_id)
    public TextView name_mapview_id;
    @BindView(R.id.name_Return_id)
    public ImageView nameReturnId;

    public HolderTake(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
