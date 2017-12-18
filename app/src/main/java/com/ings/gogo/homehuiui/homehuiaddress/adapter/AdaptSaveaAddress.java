package com.ings.gogo.homehuiui.homehuiaddress.adapter;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuiaddress.entity.EntityAddress;
import com.ings.gogo.homehuiui.homehuiaddress.holder.HolderNewly;
import com.ings.gogo.homehuiui.homehuiaddress.holder.HolderSaveaAddress;

import java.util.List;




public class AdaptSaveaAddress extends BaseMultiItemQuickAdapter<EntityAddress, BaseViewHolder> {



    private List<EntityAddress> mlistentityAddresses;
    private Context mContext;
    private OonAddresscallbackinterface mOonAddresscallbackinterface;

    public AdaptSaveaAddress(Context context, List<EntityAddress> data) {
        super(data);
        this.mlistentityAddresses = data;
        this.mContext = context;
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EntityAddress.TYPE_ONE:
                return new HolderSaveaAddress(mLayoutInflater.inflate(R.layout.adapte_saveaddress, parent, false));
            case EntityAddress.TYPE_TWO:
                return new HolderNewly(mLayoutInflater.inflate(R.layout.adapte_holder_newiy, parent, false));

        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityAddress item) {
        switch (helper.getItemViewType()) {
            case EntityAddress.TYPE_ONE:
                if (helper instanceof HolderSaveaAddress) {
                    ((HolderSaveaAddress) helper).nameFullnameId.setText(item.getFullname());
                    ((HolderSaveaAddress) helper).nameNumberId.setText(item.getNumber());
                    ((HolderSaveaAddress) helper).nameAddressId.setText(item.getQuarters());
                }
                break;

            case EntityAddress.TYPE_TWO:
                if (helper instanceof HolderNewly){
                 if (mOonAddresscallbackinterface!=null){
                     ((HolderNewly)helper).nameAddheaddressId.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             mOonAddresscallbackinterface.callbackAddress(v);
                         }
                     });

                 }

                }
        }
    }
    public void setOonAddresscallbackinterface(AdaptSaveaAddress.OonAddresscallbackinterface oonAddresscallbackinterface){
        this.mOonAddresscallbackinterface=oonAddresscallbackinterface;
    }
    public interface OonAddresscallbackinterface{
        void callbackAddress(View view);
    }
}
