package com.ings.gogo.homehuiui.homehuifood.holder;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.ings.gogo.R;
import com.ings.gogo.homehuitools.IToolsView;
import com.ings.gogo.homehuitools.impl.ToolsView;

public class HolderImage implements Holder<String>{

    private ImageView mImageView;
    @Override
    public View createView(Context context) {


        mImageView=new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {


        mImageView.setImageResource(R.drawable.ic_launcher);
        Glide.with(context).load(data).into(mImageView);
    }


}
