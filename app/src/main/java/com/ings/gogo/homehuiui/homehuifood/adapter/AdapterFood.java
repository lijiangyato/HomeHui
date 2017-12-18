package com.ings.gogo.homehuiui.homehuifood.adapter;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:菜单适配器
*/

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.db.model.impl.Database;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitBao;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityFoodData;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityTab;
import com.ings.gogo.homehuiui.homehuifood.holder.HoldOption;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderData;
import com.socks.library.KLog;


import java.util.ArrayList;
import java.util.List;


public class AdapterFood extends BaseMultiItemQuickAdapter<EntityFoodData, BaseViewHolder> {


    private String[] mTitles = {"快餐", "净菜"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round};


    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    private Database database;

    private int Number = 0;
    private Context mcontext;
    private onswitchInfoItem mOnswitchInfoItem;
    private ondeviceOption mOndeviceOption;


    private boolean mtim;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    public List<EntityFoodData> entityFoodDatas;

    public AdapterFood(Context context, List<EntityFoodData> data, boolean tai) {
        super(data);
        this.mcontext = context;
        this.mtim = tai;
        itilayot();

    }

    public void datacong(List<EntityFoodData> datas) {
        this.entityFoodDatas = datas;
    }

    /*@初始化一次*/
    private final void itilayot() {

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new EntityTab(mTitles[i]));
        }
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder,  int positions) {
        super.onBindViewHolder(holder, positions);





    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            //指示栏
            case EntityFoodData.TYPE_ONE:
                return new HoldOption(mLayoutInflater.inflate(R.layout.adapter_holder_option, parent, false));
            //数据例表
            case EntityFoodData.TYPE_TWO:
                return new HolderData(mLayoutInflater.inflate(R.layout.adapter_holder_data, parent, false));
        }
        return super.onCreateDefViewHolder(parent, viewType);

    }


    @Override
    protected void convert(final BaseViewHolder helper, final EntityFoodData item) {


        switch (helper.getItemViewType()) {
            //指示器
            case EntityFoodData.TYPE_ONE:
                if (helper instanceof HoldOption) {
                    ((HoldOption) helper).nameCommonTablayoutId.setTabData(mTabEntities);
                    ((HoldOption) helper).nameCommonTablayoutId.setOnTabSelectListener(new OnTabSelectListener() {
                        @Override
                        public void onTabSelect(int position) {
                            switch (position) {
                                case 0:
                                    if (mOndeviceOption != null) {
                                        mOndeviceOption.onviceOptionClick(position);
                                    }
                                    break;
                                case 1:
                                    if (mOndeviceOption != null) {
                                        mOndeviceOption.onviceOptionClick(position);
                                    }
                                    break;
                            }
                        }

                        @Override
                        public void onTabReselect(int position) {
                            switch (position) {
                                case 0:
                                    if (mOndeviceOption != null) {
                                        mOndeviceOption.onviceOptionClick(position);
                                    }
                                    break;
                                case 1:
                                    if (mOndeviceOption != null) {
                                        mOndeviceOption.onviceOptionClick(position);
                                    }
                                    break;
                            }
                        }
                    });

                }
                break;

            //数据例表
            case EntityFoodData.TYPE_TWO:
                if (helper instanceof HolderData) {


                    //菜名
                    ((HolderData) helper).nameiTimaiId.setText(item.getProname());
                  /*((HolderData) helper).nameThedishesId.setText(item.getShortdesc());*/
                    ((HolderData) helper).nameUnitPriceId.setText("$" + item.getMarkprice());

                    ((HolderData) helper).nameNumberId.setText(item.getNum() + "");




                    if (item.getNum()==1){
                        ((HolderData) helper).namePlusId.setImageResource(R.drawable.iocn_jiake);
                        ((HolderData) helper).nameReduceId.setImageResource(R.drawable.icon_jiankg);
                    }
                    if (item.getNum()==0) {
                        ((HolderData) helper).namePlusId.setImageResource(R.drawable.icon_jia);
                        ((HolderData) helper).nameReduceId.setImageResource(R.drawable.iocn_jianw);
                        item.setNum(0);

                    }


                    //加号
                    ((HolderData) helper).namePlusId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (mOndeviceOption != null) {

                                mOndeviceOption.onviceAniManagerClick(v, item, 1);
                                KLog.e("Foffffffod", item.getNum());
                                ((HolderData) helper).nameNumberId.setText(item.getNum() + "");
                                if (item.getNum()==1) {
                                    ((HolderData) helper).namePlusId.setImageResource(R.drawable.iocn_jiake);
                                    ((HolderData) helper).nameReduceId.setImageResource(R.drawable.icon_jiankg);
                                }

                            }

                        }
                    });
                    //减号
                    ((HolderData) helper).nameReduceId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (mOndeviceOption != null)
                                if (item.getNum()!=0){
                                    mOndeviceOption.onviceAniManagerClick(v, item, 0);
                                }

                            ((HolderData) helper).nameNumberId.setText(item.getNum() + "");
                            if (item.getNum() == 0) {
                                ((HolderData) helper).namePlusId.setImageResource(R.drawable.icon_jia);
                                ((HolderData) helper).nameReduceId.setImageResource(R.drawable.iocn_jianw);
                                return;

                            }
                        }

                    });
                    //图片
                    Glide.with(mcontext).load(item.getImgurl()).into(((HolderData) helper).nameImguriId);
                    helper.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOnswitchInfoItem != null) {
                                mOnswitchInfoItem.onschemaClick(v,item);
                            }
                        }
                    });


                }
                break;


        }
    }

    //商品详情回调监听
    public void setmOndeviceInfoItem(onswitchInfoItem ondeviceInfoItem) {
        this.mOnswitchInfoItem = ondeviceInfoItem;
    }

    public interface onswitchInfoItem {
        void onschemaClick(View view,EntityFoodData entityFoodData);
    }

    // 指示器
    public void setmOndeviceOption(ondeviceOption ondeviceOption) {
        this.mOndeviceOption = ondeviceOption;
    }

    public interface ondeviceOption {
        void onviceOptionClick(int position);

        void onviceAniManagerClick(View view, EntityFoodData entityFoodData, int type);
    }


}
