package com.ings.gogo.homehuitools.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/14.
@作用:加载
*/

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;

import com.ings.gogo.R;
import com.tuyenmonkey.mkloader.MKLoader;


public class ToolsLoadingDialog  extends Dialog{
    private MKLoader mMkloader;
    private Context mContext;
    public ToolsLoadingDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialog);
        this.mContext=context;
    }

    public ToolsLoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext=context;
    }

    protected ToolsLoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View mview = LayoutInflater.from(mContext).inflate(R.layout.tools_loading_dialog,null);
        setContentView(mview);
        //设置点击屏幕Dialog不消失
        setCancelable(false);
        mMkloader= (MKLoader) mview.findViewById(R.id.name_mkloader_id);

    }

    @Override
    public void show() {
        super.show();
        mMkloader.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mMkloader.setVisibility(View.GONE);
    }

    @Override
    public void setCanceledOnTouchOutside(boolean cancel) {
        //点击屏幕不消失
        super.setCanceledOnTouchOutside(false);
    }
}
