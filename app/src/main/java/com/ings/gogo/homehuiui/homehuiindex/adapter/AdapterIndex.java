package com.ings.gogo.homehuiui.homehuiindex.adapter;
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

import com.flyco.tablayout.listener.CustomTabEntity;
import com.ings.gogo.R;

import com.ings.gogo.homehuiui.homehuiindex.Entity.EntityIndexAdd;
import com.ings.gogo.homehuiui.homehuiindex.Entity.EntityNavigator;
import com.ings.gogo.homehuiui.homehuiindex.holder.HoldeIntegr;
import com.ings.gogo.homehuiui.homehuiindex.holder.HoldeRpersonal;
import com.ings.gogo.homehuiui.homehuiindex.holder.HolderCoupon;
import com.ings.gogo.homehuiui.homehuiindex.holder.HolderIcon;
import com.ings.gogo.homehuiui.homehuiindex.holder.HolderMessage;
import com.ings.gogo.homehuiui.homehuiindex.holder.HolderNavigator;
import com.ings.gogo.homehuiui.homehuiindex.holder.HolderOrder;
import com.ings.gogo.homehuiui.homehuiindex.holder.HolderRecommend;
import com.ings.gogo.homehuiui.homehuiindex.holder.HolderUpdate;

import java.util.ArrayList;
import java.util.List;


public class AdapterIndex extends BaseMultiItemQuickAdapter<EntityIndexAdd, BaseViewHolder> {
    private PersonalCenter mPersonalCenter;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private Context mContext;
    private List<EntityIndexAdd> mEntityIndices;
    private String[] mTitles = {"待付款", "待配送", "代码评价", "退款/销售"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round};


    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    public AdapterIndex(Context context, List<EntityIndexAdd> data) {
        super(data);

        this.mContext = context;
        this.mEntityIndices = data;
        itilayot();
    }


    /*@初始化一次*/
    private final void itilayot() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new EntityNavigator(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {


            //电话图标
            case EntityIndexAdd.TYPE_SIX:
                return new HolderIcon(mLayoutInflater.inflate(R.layout.adapter_lcon, parent, false));

            //定位地址管理
            case EntityIndexAdd.TYPE_SEVEN:
                return new HoldeRpersonal(mLayoutInflater.inflate(R.layout.adapter_rpersonal, parent, false));
            //我的积分
            case EntityIndexAdd.TYPE_EIGHT:
                return new HoldeIntegr(mLayoutInflater.inflate(R.layout.adapter_rpersonal, parent, false));
            //版本更新
            case EntityIndexAdd.TYPE_NINE:
                return new HolderUpdate(mLayoutInflater.inflate(R.layout.adapter_rpersonal, parent, false));
            //推荐好友
            case EntityIndexAdd.TYPE_TEN:
                return new HolderRecommend(mLayoutInflater.inflate(R.layout.adapter_rpersonal, parent, false));
            //导航器
            case EntityIndexAdd.TYPE_ONE:
                return new HolderNavigator(mLayoutInflater.inflate(R.layout.adapte_navigator, parent, false));

            //消息订单
            case EntityIndexAdd.TYPE_FOUR:
                return new HolderMessage(mLayoutInflater.inflate(R.layout.adapter_message, parent, false));
            //优化卷
            case EntityIndexAdd.TYPE_TWO:
                return new HolderCoupon(mLayoutInflater.inflate(R.layout.adapter_rpersonal, parent, false));

            //订单
            case EntityIndexAdd.TYPE_THREE:
                return new HolderOrder(mLayoutInflater.inflate(R.layout.adapter_order, parent, false));


        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityIndexAdd item) {
        switch (helper.getItemViewType()) {


            //导航器
            case EntityIndexAdd.TYPE_ONE:
                if (helper instanceof HolderNavigator) {
                    ((HolderNavigator) helper).nameNavigatorId.setTabData(mTabEntities);
                }
                //电话图标
                break;
            case EntityIndexAdd.TYPE_SIX:
                if (helper instanceof HolderIcon) {
                    if (helper instanceof HolderIcon) {

                    }
                }
                break;
            //定位管理
            case EntityIndexAdd.TYPE_SEVEN:
                if (helper instanceof HoldeRpersonal) {
                    ((HoldeRpersonal) helper).nameTitleId.setText(item.getAddress());
                    ((HoldeRpersonal) helper).itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPersonalCenter.Callbackcenter(v,7);
                        }
                    });
                }
                break;
            //我的积分
            case EntityIndexAdd.TYPE_EIGHT:
                if (helper instanceof HoldeIntegr) {
                    ((HoldeIntegr) helper).nameTitleId.setText(item.getIntegr());
                }
                break;
            //版本更新
            case EntityIndexAdd.TYPE_NINE:
                if (helper instanceof HolderUpdate) {
                    ((HolderUpdate) helper).nameTitleId.setText(item.getUpdate());
                }
                break;
            //好友推荐
            case EntityIndexAdd.TYPE_TEN:
                if (helper instanceof HolderRecommend) {
                    ((HolderRecommend) helper).nameTitleId.setText(item.getRecommend());
                    ((HolderRecommend) helper).itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPersonalCenter.Callbackcenter(v,10);
                        }
                    });
                }
                break;
                //优化卷
            case EntityIndexAdd.TYPE_TWO:
                break;
            //订单
            case EntityIndexAdd.TYPE_THREE:
                break;
            //订单消息
            case EntityIndexAdd.TYPE_FOUR:
                break;
        }


    }

    public void setPersonalCenter(AdapterIndex.PersonalCenter mPersonalCenter){
        this.mPersonalCenter=mPersonalCenter;
    }

    public interface PersonalCenter {
        void Callbackcenter(View view,int sing);
    }
}
