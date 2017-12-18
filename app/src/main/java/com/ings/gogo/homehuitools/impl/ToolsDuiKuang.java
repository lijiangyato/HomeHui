package com.ings.gogo.homehuitools.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.ings.gogo.R;
import com.ings.gogo.homehuiui.homehuiaddress.view.impl.MapActivityView;
import com.michael.easydialog.EasyDialog;



public class ToolsDuiKuang {

private Context context;
    public ToolsDuiKuang(Context context){
        this.context=context;

    }


    public void iniDuiKuang(){
       View view=LayoutInflater.from(context).inflate(R.layout.ff,null,false);
        new EasyDialog(context)
                .setLayoutResourceId(R.layout.ff)
                .setBackgroundColor(context.getResources().getColor(R.color.color_code))
               // .setLocationByAttachedView(btnBottomRight)
                .setGravity(EasyDialog.GRAVITY_TOP)
                .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 200, 200, 0)
                .setAnimationTranslationShow(EasyDialog.DIRECTION_Y, 200, 200, 0)
                .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 300, 0, 400)
                .setAnimationTranslationDismiss(EasyDialog.DIRECTION_Y, 300, 0, 400)
                .setTouchOutsideDismiss(true)
                .setMatchParent(false)
                .setMarginLeftAndRight(24, 24)
                .setOutsideColor(context.getResources().getColor(R.color.color1))
                .show();
    }
}
