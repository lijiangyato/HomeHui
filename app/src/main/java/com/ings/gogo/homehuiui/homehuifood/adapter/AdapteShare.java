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
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitShare;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityFoodData;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderDetailedCase;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderDetailedHints;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderExhibition;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderFood;
import com.ings.gogo.homehuiui.homehuifood.view.IFoodFragmentView;

import java.util.List;

public class AdapteShare extends BaseMultiItemQuickAdapter<EntitShare, BaseViewHolder> {

private ondeviceOption mOndeviceOptiononShare;


    private List<EntitShare> mListentitShare;

    public AdapteShare(Context context, List<EntitShare> data) {
        super(data);
        this.mContext = context;
        this.mListentitShare = data;
    }


    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            //详情图片
            case EntitShare.TYPE_ONE:
                return new HolderDetailedCase(mLayoutInflater.inflate(R.layout.adapte_holder_detaliedcase, parent, false));
            case EntitShare.TYPE_TWO:
                return new HolderDetailedHints(mLayoutInflater.inflate(R.layout.adapte_holder_detailedhints, parent, false));
            case EntitShare.TYPE_THREE:
                return new HolderFood(mLayoutInflater.inflate(R.layout.adapte_holder_food, parent, false));

        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final EntitShare item) {
        switch (helper.getItemViewType()) {
            case EntitShare.TYPE_ONE:
                if (helper instanceof HolderDetailedCase) {
                    ((HolderDetailedCase) helper).nameNumberId.setText(item.getNum() + "");
                    Glide.with(mContext).load(item.getImgurl()).into(((HolderDetailedCase) helper).nameIcongtimgId);
                    ((HolderDetailedCase) helper).nameiTimaiId.setText(item.getProname());
                    ((HolderDetailedCase) helper).namePlusId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOndeviceOptiononShare!=null){
                                mOndeviceOptiononShare.onviceAniManagerClick(v,item,1);
                                ((HolderDetailedCase) helper).nameNumberId.setText(item.getNum() + "");

                            }
                        }
                    });
                    ((HolderDetailedCase) helper).nameReduceId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOndeviceOptiononShare!=null){
                                if (item.getNum()!=0){
                                    mOndeviceOptiononShare.onviceAniManagerClick(v,item,0);
                                    ((HolderDetailedCase) helper).nameNumberId.setText(item.getNum() + "");
                                }

                            }
                        }
                    });


                }
                break;
            case EntitShare.TYPE_TWO:
                break;
            case EntitShare.TYPE_THREE:
                break;
        }


    }

    public void setmOndeviceOption(AdapteShare.ondeviceOption ondeviceOption) {
        this.mOndeviceOptiononShare = ondeviceOption;
    }


    public interface ondeviceOption {
        void onviceOptionClick(int position);

        void onviceAniManagerClick(View view, EntitShare entitShare, int type);
    }
}
