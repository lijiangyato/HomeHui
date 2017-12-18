package com.ings.gogo.homehuihttp;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import com.ings.gogo.homehuihttp.constant.Constant;
import com.ings.gogo.homehuihttp.interceptor.IesInterceptorReceivedCook;
import com.ings.gogo.homehuihttp.interceptor.IngInterceptorLog;
import com.ings.gogo.homehuiui.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpRetrrofi {

    //模拟网络数据测试
    public static Retrofit mRetrofit;
    //公用
    private static Retrofit mRetrofitcommunal;

    private static Application mApplication;
    private static HttpRetrrofi mhttpRetrrofi;
    private volatile static boolean hasInit=false;


    private HttpRetrrofi(Application mapplication){
        this.mApplication=mapplication;
    }

    public static void  init(Application mapplication){
        if (mhttpRetrrofi==null){
            synchronized (HttpRetrrofi.class){
                if (mhttpRetrrofi==null){
                    mhttpRetrrofi=new HttpRetrrofi(mapplication);
                    hasInit=true;
                }
            }
        }
    }
    /*@模拟网络数据测试*/
    public static Retrofit getretrofit() {
        if (mRetrofit == null) {
            synchronized (Retrofit.class) {
                if (mRetrofit == null) {
                    OkHttpClient.Builder mbuilder = new OkHttpClient.Builder();
                    mbuilder.connectTimeout(15, TimeUnit.SECONDS);
                    //网络日志拦截器
                    mbuilder.addInterceptor(new IngInterceptorLog());
                    //接收请求中返回并保存cookie 拦截器
                    mbuilder.addInterceptor(new IesInterceptorReceivedCook(mApplication));

                    OkHttpClient mokHttpClient = mbuilder.build();

                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(Constant.BASEDEBUG_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(mokHttpClient)
                            .build();
                }
            }
        }
        return mRetrofit;
    }


    /*@购物车详情例表参数！轮播图*/
  public static Retrofit getmRetrofitfood(){
      if (mRetrofitcommunal == null) {
          synchronized (Retrofit.class) {
              if (mRetrofitcommunal == null) {
                  OkHttpClient.Builder mbuilder = new OkHttpClient.Builder();
                  mbuilder.connectTimeout(15, TimeUnit.SECONDS);
                  OkHttpClient mokHttpClient = mbuilder.build();

                  mRetrofitcommunal = new Retrofit.Builder()
                          .baseUrl(Constant.BASE_URL)
                          .addConverterFactory(GsonConverterFactory.create())
                          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                          .client(mokHttpClient)
                          .build();
              }
          }
      }
      return mRetrofitcommunal;
  }
    /*@更新请求*/
  public static Retrofit getmRetrofitUpdate(){
      if (mRetrofitcommunal == null) {
          synchronized (Retrofit.class) {
              if (mRetrofitcommunal == null) {
                  OkHttpClient.Builder mbuilder = new OkHttpClient.Builder();
                  mbuilder.connectTimeout(15, TimeUnit.SECONDS);
                  OkHttpClient mokHttpClient = mbuilder.build();

                  mRetrofitcommunal = new Retrofit.Builder()
                          .baseUrl(Constant.APP_UPDATE)
                          .addConverterFactory(GsonConverterFactory.create())
                          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                          .client(mokHttpClient)
                          .build();
              }
          }
      }
      return mRetrofitcommunal;
  }

   /*@@注册！登录！手机验证！忘记密码*/
 public static Retrofit getmRetrofitIndex(){
     if (mRetrofitcommunal == null) {
         synchronized (Retrofit.class) {
             if (mRetrofitcommunal == null) {
                 OkHttpClient.Builder mbuilder = new OkHttpClient.Builder();
                 mbuilder.connectTimeout(15, TimeUnit.SECONDS);
                 OkHttpClient mokHttpClient = mbuilder.build();

                 mRetrofitcommunal = new Retrofit.Builder()
                         .baseUrl(Constant.BASE_URL)
                         .addConverterFactory(GsonConverterFactory.create())
                         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                         .client(mokHttpClient)
                         .build();
             }
         }
     }
     return mRetrofitcommunal;
 }

}
