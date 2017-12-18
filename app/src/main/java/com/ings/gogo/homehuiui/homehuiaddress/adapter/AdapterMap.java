package com.ings.gogo.homehuiui.homehuiaddress.adapter;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.services.help.Tip;
import com.ings.gogo.R;

import java.util.List;



public class AdapterMap extends RecyclerView.Adapter<AdapterMap.HolderView> {


    private List<Tip> mList;
    private Context mContext;
    private onswichInfoItem mOnswichInfoItem;
    private View mView;
    private HolderView mHolderView;

    public AdapterMap(List<Tip> listtip, Context context) {
        this.mList = listtip;
        this.mContext = context;
    }

    //创建
    @Override
    public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.adapter_map, parent, false);
        mHolderView = new HolderView(mView);
        return mHolderView;
    }

    @Override
    public void onBindViewHolder(HolderView holder, final int position) {
          holder.mCompanyText.setText(mList.get(position).getName());
          holder.mPlaceText.setText(mList.get(position).getDistrict());
          holder.view.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  mOnswichInfoItem.onHighendMapClick(v,position);
              }
          });
    }

    //数量
    @Override
    public int getItemCount() {

            return mList.size();


    }

    public void setOnswitchInfoItem(onswichInfoItem onswitchInfoItem) {
        this.mOnswichInfoItem = onswitchInfoItem;

    }

    public interface onswichInfoItem {
        void onHighendMapClick(View view, int position);
    }

    static class HolderView extends RecyclerView.ViewHolder {
        private TextView mCompanyText;
        private TextView mPlaceText;
        private View view;

        public HolderView(View itemView) {
            super(itemView);
            this.view=itemView;
            mCompanyText= (TextView) itemView.findViewById(R.id.name_company_id);
            mPlaceText= (TextView) itemView.findViewById(R.id.name_place_id);
        }
    }

}
