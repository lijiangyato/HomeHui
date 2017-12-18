package com.ings.gogo.homehuihttp.interceptor;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Response;

/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:接收请求中返回并保存cookie 拦截器
*/

public class IesInterceptorReceivedCook implements Interceptor {

    private Context context;

    public IesInterceptorReceivedCook(Context context) {
        super();
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();

            Flowable.fromIterable(originalResponse.headers("Set-Cookie"))
                    .map(new Function<String, String>() {
                        @Override
                        public String apply(@NonNull String s) throws Exception {
                            String[] cookieArray = s.split(";");
                            return cookieArray[0];
                        }
                    })
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(@NonNull String cookie) throws Exception {
                            cookieBuffer.append(cookie).append(";");
                        }
                    });

            SharedPreferences sharedPreferences = context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("cookie", cookieBuffer.toString());
            editor.commit();
        }
        return originalResponse;
    }
}
