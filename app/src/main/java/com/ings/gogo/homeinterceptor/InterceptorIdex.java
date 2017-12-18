package com.ings.gogo.homeinterceptor;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.socks.library.KLog;

/*@Interceptor(priority = 1,name = "登录拦截器")*/
public class InterceptorIdex /*implements IInterceptor*/ {
   /* @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getPath().equals("/index/activity/IndexActivityView")){
            KLog.e("interceptorldex",":::通过登陆拦截器");
            //处理完成 交还控制权
           callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }*/
}
