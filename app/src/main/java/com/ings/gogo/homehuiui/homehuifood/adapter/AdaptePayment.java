package com.ings.gogo.homehuiui.homehuifood.adapter;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityOrderForm;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderAddress;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderCoupon;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderData;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderMenu;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderPrompt;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderRemarks;

import java.util.List;

import butterknife.BindView;

public class AdaptePayment extends BaseMultiItemQuickAdapter<EntityOrderForm, BaseViewHolder> {



    private Context mContext;
    private List<EntityOrderForm> mListEntityOrderForm;
    private onaddressinterface mOnaddressinterface;

    public AdaptePayment(Context context, List<EntityOrderForm> data) {
        super(data);
        this.mContext = context;
        this.mListEntityOrderForm = data;
    }


    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            //新增地址

            case EntityOrderForm.TYPE_ONE:
                return new HolderAddress(mLayoutInflater.inflate(R.layout.adapte_address, parent, false));
            //配送服务
            case EntityOrderForm.TYPE_TWO:
                return new HolderPrompt(mLayoutInflater.inflate(R.layout.adapte_prompt, parent, false));
            //菜单
            case EntityOrderForm.TYPE_THREE:
                return new HolderMenu(mLayoutInflater.inflate(R.layout.adapte_menu, parent, false));
            //积分
            case EntityOrderForm.TYPE_FOUR:
                return new HolderCoupon(mLayoutInflater.inflate(R.layout.adapte_coupon, parent, false));
            //支付
            case EntityOrderForm.TYPE_FIVE:
                return new HolderRemarks(mLayoutInflater.inflate(R.layout.adapte_remarks, parent, false));
        }
        return super.onCreateDefViewHolder(parent, viewType);


    }

    @Override
    protected void convert(BaseViewHolder helper, final EntityOrderForm item) {
        switch (helper.getItemViewType()) {
            //新增地址
            case EntityOrderForm.TYPE_ONE:
                if (helper instanceof HolderAddress){
                    ((HolderAddress) helper).nameHarvestId.setText(item.getProname());
                    ((HolderAddress) helper).nameNewlyaddedId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (mOnaddressinterface!=null){
                                mOnaddressinterface.onAddressCallback(v);
                            }
                        }
                    });
                }

                break;
            //配送服务
            case EntityOrderForm.TYPE_TWO:
                break;
            //菜单
            case EntityOrderForm.TYPE_THREE:
                if (helper instanceof HolderMenu) {
                    Glide.with(mContext).load(item.getImgurl()).into( ((HolderMenu) helper).nameImguriId);
                    ((HolderMenu) helper).nameThedishesId.setText(item.getProname());
                    ((HolderMenu) helper). nameNumberId.setText(String.valueOf(item.getNum()));

                }
                break;
            //积分
            case EntityOrderForm.TYPE_FOUR:
                break;
            //支付
            case EntityOrderForm.TYPE_FIVE:
                break;

        }

    }
    public void setmOnaddressinterface(AdaptePayment.onaddressinterface onaddressinterface){
        this.mOnaddressinterface=onaddressinterface;
    }

    public interface onaddressinterface{
        void onAddressCallback(View view);
    }
}
