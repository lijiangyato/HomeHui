package com.ings.gogo.homehuiui.homehuifood.adapter;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:购物车适配器
*/

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitExhibition;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityFoodData;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderData;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderExhibition;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;


public class AdapterExhibition extends BaseMultiItemQuickAdapter<EntitExhibition, BaseViewHolder> {

    private ondeviceOption mOndeviceOption;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */

    public List<EntitExhibition> mentitExhibitions;

    public AdapterExhibition(List<EntitExhibition> data) {

        super(data);
    }

    public void Exhibition(List<EntitExhibition> entitExhibitions) {
        this.mentitExhibitions = entitExhibitions;
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int positions) {
        super.onBindViewHolder(holder, positions);
        int p = positions;

        switch (holder.getItemViewType()) {
            case EntitExhibition.TYPE_ONE:
               /* ((HolderExhibition) holder).namePlusId.setImageResource(R.drawable.iocn_jiake);
                ((HolderExhibition) holder).nameReduceId.setImageResource(R.drawable.icon_jiankg);*/
                ((HolderExhibition) holder).nameUnitPriceId.setText(mentitExhibitions.get(positions).getProname());
                ((HolderExhibition) holder).nameMoneyId.setText(mentitExhibitions.get(positions).getMarkprice()+"");

                KLog.e("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",mentitExhibitions.get(positions).getMarkprice()+"");


                ((HolderExhibition) holder).nameNumberId.setText(mentitExhibitions.get(positions).getNum() + "");
                if (mentitExhibitions.get(positions).getNum() == 1) {
                    ((HolderExhibition) holder).namePlusId.setImageResource(R.drawable.iocn_jiake);
                    ((HolderExhibition) holder).nameReduceId.setImageResource(R.drawable.icon_jiankg);
                }

                if (mentitExhibitions.get(positions).getNum() == 0) {
                    ((HolderExhibition) holder).namePlusId.setImageResource(R.drawable.icon_jia);
                    ((HolderExhibition) holder).nameReduceId.setImageResource(R.drawable.iocn_jianw);
                    return;
                }
                if (holder instanceof HolderExhibition) {
                    ((HolderExhibition) holder).namePlusId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOndeviceOption != null) {
                                mOndeviceOption.onviceAniManagerClick(v, mentitExhibitions.get(positions), 1, positions);
                                ((HolderExhibition) holder).nameNumberId.setText(mentitExhibitions.get(positions).getNum() + "");
                            }
                            if (mentitExhibitions.get(positions).getNum() == 1) {
                                ((HolderExhibition) holder).namePlusId.setImageResource(R.drawable.iocn_jiake);
                                ((HolderExhibition) holder).nameReduceId.setImageResource(R.drawable.icon_jiankg);
                            }

                        }
                    });


                    ((HolderExhibition) holder).nameReduceId.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mOndeviceOption != null) {
                                if (mentitExhibitions.get(positions).getNum() !=0){
                                    mOndeviceOption.onviceAniManagerClick(v, mentitExhibitions.get(positions), 0, positions);
                                }
                                ((HolderExhibition) holder).nameNumberId.setText(mentitExhibitions.get(positions).getNum() + "");
                                if (mentitExhibitions.get(positions).getNum() == 0) {
                                    remove(positions);
                                }

                            }
                        }
                    });


                }

                break;
        }
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case EntitExhibition.TYPE_ONE:
                return new HolderExhibition(mLayoutInflater.inflate(R.layout.adapter_exhibition, parent, false));

        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final EntitExhibition item) {


    }

    public void setOnCholderExhibition(AdapterExhibition.ondeviceOption onCholderExhibition) {
        this.mOndeviceOption = onCholderExhibition;

    }


    public interface ondeviceOption {
        void onviceAniManagerClick(View view, EntitExhibition entitExhibition, int type, int i);
    }


}
