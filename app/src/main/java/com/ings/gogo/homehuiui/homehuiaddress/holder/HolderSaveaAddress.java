package com.ings.gogo.homehuiui.homehuiaddress.holder;
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

public class HolderSaveaAddress extends BaseViewHolder {

    @BindView(R.id.name_address_id)
    public TextView nameAddressId;
    @BindView(R.id.name_fullname_id)
    public TextView nameFullnameId;
    @BindView(R.id.name_gender_id)
    public TextView nameGenderId;
    @BindView(R.id.name_number_id)
    public TextView nameNumberId;
    @BindView(R.id.name_layout_id)
    public LinearLayout nameLayoutId;

    public HolderSaveaAddress(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
