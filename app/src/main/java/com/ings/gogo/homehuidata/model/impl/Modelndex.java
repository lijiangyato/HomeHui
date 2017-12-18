package com.ings.gogo.homehuidata.model.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;

import com.ings.gogo.homehuidata.index.entity.EntityCode;
import com.ings.gogo.homehuidata.index.entity.EntityIndex;
import com.ings.gogo.homehuidata.index.entity.EntityIntegral;
import com.ings.gogo.homehuidata.index.entity.EntityPassword;
import com.ings.gogo.homehuidata.index.entity.EntitycHeck;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;
import com.ings.gogo.homehuidata.model.IModelndex;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuihttp.manager.HttpManagerIndex;
import com.socks.library.KLog;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


@Route(path = "/data/model/Modelndex",name = "登录!注册!验证码!忘记密码!应用数据相关接口")
public class Modelndex implements IModelndex {
    /*@登录*/
    @SuppressWarnings("unchecked")
    @Override
    public void getIndex(String phone, String loginkey, final IUnifiedDataListener<EntityIndex> miUnifiedDataListener) {
        HttpManagerIndex.getmHttpManagerIndex().getIndex(phone,loginkey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityIndex>() {
                    @Override
                    public void accept(@NonNull EntityIndex entityIndex) throws Exception {
                        Log.e("index", "登录网络请求成功！");
                     miUnifiedDataListener.success(entityIndex);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityIndex>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityIndex entityIndex) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("index", "登录网络请求有错误，请注意！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    /*@手机号码验证码*/
    @SuppressWarnings("unchecked")
    @Override
    public void getCode(String phone, String verclassify, final IUnifiedDataListener<EntityCode> miUnifiedDataListener) {
     HttpManagerIndex.getmHttpManagerIndex().getCode(phone,verclassify)
             .subscribeOn(Schedulers.newThread())
             .observeOn(Schedulers.io())
             .doOnNext(new Consumer<EntityCode>() {
                 @Override
                 public void accept(@NonNull EntityCode entityCode) throws Exception {
                     Log.e("register", "手机号码验证码网络请求成功！");
                     miUnifiedDataListener.success(entityCode);
                 }
             })
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Subscriber<EntityCode>() {
                 @Override
                 public void onSubscribe(Subscription s) {

                 }

                 @Override
                 public void onNext(EntityCode entityCode) {

                 }

                 @Override
                 public void onError(Throwable t) {
                     Log.e("register", "手机号码验证码网络请求有错误，请注意！");
                 }

                 @Override
                 public void onComplete() {

                 }
             });
    }
    /*@校验码*/
    @SuppressWarnings("unchecked")
    @Override
    public void getcheck(String phone, String code, final IUnifiedDataListener<EntitycHeck> miUnifiedDataListener) {
        HttpManagerIndex.getmHttpManagerIndex().getcheck(phone,code)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntitycHeck>() {
                    @Override
                    public void accept(@NonNull EntitycHeck entitycHeck) throws Exception {
                        Log.e("check", "校验码网络请求成功");
                        miUnifiedDataListener.success(entitycHeck);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntitycHeck>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntitycHeck entitycHeck) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("check", "校验码网络请求有错误，请注意！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /*@开始注册*/
    @SuppressWarnings("unchecked")
    @Override
    public void getEnroll(String phone, String smscode, String loginkey, final IUnifiedDataListener<EntitycReset> miUnifiedDataListener) {
        HttpManagerIndex.getmHttpManagerIndex().getEnroll(phone,smscode,loginkey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntitycReset>() {
                    @Override
                    public void accept(@NonNull EntitycReset entitycReset) throws Exception {
                        KLog.e("00005", "注册网络数据请求成功");
                       miUnifiedDataListener.success(entitycReset);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntitycReset>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntitycReset entitycReset) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        KLog.e("00005", "注册网络请求有错误，请注意！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    /*@忘记密码*/
    @SuppressWarnings("unchecked")
    @Override
    public void getPassword(String phone, String smscode, String loginkey, final IUnifiedDataListener<EntityPassword> miUnifiedDataListener) {
        HttpManagerIndex.getmHttpManagerIndex().getPassword(phone,smscode,loginkey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityPassword>() {
                    @Override
                    public void accept(@NonNull EntityPassword entityPassword) throws Exception {
                        miUnifiedDataListener.success(entityPassword);
                        KLog.e("00006", "忘记密码网络数据请求成功");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityPassword>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityPassword entityPassword) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        KLog.e("00006", "忘记密码网络请求有错误，请注意！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    /*@获取积分总数*/
    @Override
    public void getIntegral(final IUnifiedDataListener<EntityIntegral> miUnifiedDataListener) {
        HttpManagerIndex.getmHttpManagerIndex().getIntegral()
                .subscribeOn(Schedulers.newThread())
                 .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityIntegral>() {
                    @Override
                    public void accept(@NonNull EntityIntegral entityIntegral) throws Exception {
                        miUnifiedDataListener.success(entityIntegral);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityIntegral>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityIntegral entityIntegral) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        KLog.e("00007", "积分网络请求有错误，请注意！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void init(Context context) {

    }
}
