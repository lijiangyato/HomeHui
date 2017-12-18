package com.ings.gogo.homehuiui.homehuibase.animation;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.ings.gogo.R;
import com.nineoldandroids.view.ViewHelper;


/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:动画
 */

public class AnimationMain implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        View view_one0 = page.findViewById(R.id.Layout_laoli0);
        View view_one1 = page.findViewById(R.id.Layout_laoli1);
        View view_one2 = page.findViewById(R.id.Layout_laoli2);
        View view_one3 = page.findViewById(R.id.Layout_laoli3);
        View view = page.findViewById(R.id.email_login_form);



/*

        if (1 <= position && position <1.1f) {
            //[-1 , 0][1 , 0]右侧page处理,抵消page本身的滑动动画
            ViewHelper.setTranslationX(page, pageWidth * (-position));
        }
*/


        if (0 <= position && position < 0.3f) {
            //[-1 , 0][1 , 0]右侧page处理,抵消page本身的滑动动画
            ViewHelper.setTranslationX(page, pageWidth * (-position));
        }
        if (-1 < position && position < 0) {

            //[-1 , 0]左侧page处理,抵消page本身的滑动动画
            ViewHelper.setTranslationX(page, pageWidth * -position);
        }
        if (position <= -1.0f || position >= 1.0f) {

            //(-& ~ -1),(1 ~ +&)不可见部分不作处理
        } else if (position == 0.0f) {

        } else {
            if (view_one0 != null) {
                Log.e("ingo", "0005");
                ViewHelper.setAlpha(view_one0, 1.0f - Math.abs(position));
            }
            if (view_one1 != null) {
                ViewHelper.setAlpha(view_one1, 1.0f - Math.abs(position));
            }
            if (view_one2 != null) {
                ViewHelper.setAlpha(view_one2, 1.0f - Math.abs(position));
            }
            if (view_one3 != null) {
                ViewHelper.setAlpha(view_one3, 1.0f - Math.abs(position));
            }
            if (view != null) {
                ViewHelper.setTranslationX(view, (float) (pageWidth / 8.6 * position));

            }

        }
    }
}
