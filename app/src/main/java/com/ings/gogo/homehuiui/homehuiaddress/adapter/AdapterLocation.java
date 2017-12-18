package com.ings.gogo.homehuiui.homehuiaddress.adapter;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/
import com.amap.api.maps2d.LocationSource;
import com.amap.api.services.core.PoiItem;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ings.gogo.R;
import java.util.List;


public class AdapterLocation extends RecyclerView.Adapter<AdapterLocation.HolderLocation> {
    private Context mContext;
    public List<PoiItem> arrayList;
    private View mView;
    private HolderLocation mholderLocation;
    private AdapterLocation.onLocationtem onLocationtem;

    public AdapterLocation(Context applicationContext, List<PoiItem> arrayList) {
        this.mContext = applicationContext;
        this.arrayList = arrayList;
    }

    @Override
    public HolderLocation onCreateViewHolder(ViewGroup parent, int viewType) {
        mView= LayoutInflater.from(mContext).inflate(R.layout.adapte_location,parent,false);
        mholderLocation=new HolderLocation(mView);

        return mholderLocation;
    }

    @Override
    public void onBindViewHolder(HolderLocation holder, final int position) {
        holder.mCompanyText.setText(arrayList.get(position).toString());
        holder.mPlaceText.setText(arrayList.get(position).getSnippet());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLocationtem.onLocationMapClick(v,position);
            }
        });
    }

    public void setOnLocationItem(AdapterLocation.onLocationtem onswitchInfoItem) {
        this.onLocationtem = onswitchInfoItem;

    }
    public interface onLocationtem {
        void onLocationMapClick(View view, int position);
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class HolderLocation extends RecyclerView.ViewHolder {
        public TextView mCompanyText;
        public TextView mPlaceText;
        public View view;
        public HolderLocation(View itemView) {
            super(itemView);
            this.view=itemView;
            mCompanyText= (TextView) itemView.findViewById(R.id.name_companylocation_id);
            mPlaceText= (TextView) itemView.findViewById(R.id.name_placelocation_id);
        }
    }
}
