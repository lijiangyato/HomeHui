package com.ings.gogo.homehuihttp.interceptor;

import com.socks.library.KLog;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Response;

/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:网络请求日志拦截器
*/

public class IngInterceptorLog implements Interceptor {
    private static final String TAG = "okhttp_log";
    private LogModel mLogModel;

    public IngInterceptorLog() {
        this.mLogModel = LogModel.all;
    }

    public IngInterceptorLog(LogModel logModel) {
        this.mLogModel = logModel;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //Request request = chain.request();
        // Log.v(TAG, "request:" + request.toString());

        long t1 = System.nanoTime();
        Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();

        switch (mLogModel) {
            case all:
                KLog.v(TAG, String.format(Locale.getDefault(),
                        "Received response for %s in %.1fms%n%s",
                        response.request().url(), (t2 - t1) / 1e6d, response.headers()));
                KLog.i(TAG, content);
                break;
            case concise:
                KLog.v(TAG, String.format(Locale.getDefault(),
                        "%s in %.1fms",
                        response.request().url(), (t2 - t1) / 1e6d));
                KLog.i(TAG, content);
                break;
            default:
                break;
        }
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
        //     return response;
    }

    public enum LogModel {
        all, concise
    }
}
