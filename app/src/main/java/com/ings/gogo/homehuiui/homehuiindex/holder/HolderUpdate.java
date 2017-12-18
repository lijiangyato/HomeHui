package com.ings.gogo.homehuiui.homehuiindex.holder;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.ings.gogo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderUpdate extends BaseViewHolder {

    @BindView(R.id.name_icon_id)
    public ImageView nameIconId;
    @BindView(R.id.name_title_id)
    public TextView nameTitleId;
    @BindView(R.id.name_return_id)
    public ImageView nameReturnId;
    @BindView(R.id.name_event_id)
    public LinearLayout nameEventId;
    public HolderUpdate(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
