package com.ings.gogo.homehuiui.homehuifood.holder;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.ings.gogo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderAddress extends BaseViewHolder {


    @BindView(R.id.name_Harvest_id)
   public TextView nameHarvestId;
    @BindView(R.id.name_Newlyadded_id)
    public LinearLayout nameNewlyaddedId;
    @BindView(R.id.name_timeinterval_id)
    public TextView nameTimeintervalId;
    @BindView(R.id.name_time_id)
    public LinearLayout nameTimeId;
    public HolderAddress(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
