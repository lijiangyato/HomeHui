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
import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.food.entity.EntityCarouselFigure;
import com.ings.gogo.homehuidata.food.entity.EntityPoints;
import com.ings.gogo.homehuidata.model.IModelFood;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuihttp.manager.HttpManagerFood;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@Route(path = "/data/model/ModelFood",name = "轮播图!商品详情！应用数据接口")
public class ModelFood implements IModelFood {

    /*购物车商品详情*/
    @SuppressWarnings("unchecked")
    @Override
    public void getDetailsTable(String pointid, String categoryid, String figure, final IUnifiedDataListener<EntityFood> miUnifiedDataListener) {
        HttpManagerFood.getmHttpManagerFood().getDetailsTable(pointid, categoryid, figure)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityFood>() {
                    @Override
                    public void accept(@NonNull EntityFood entityFood) throws Exception {
                        miUnifiedDataListener.success(entityFood);
                        /*if (entityFood.isSuccess() == true) {
                            miUnifiedDataListener.success(entityFood);
                        } else {
                            miUnifiedDataListener.fail(002, "购物车商品详情网络请求失败请仔细检查");
                        }*/

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityFood>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityFood entityFood) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("commodity", "商品详情网络请求有错误，请注意！");

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    /*轮播图*/
    @SuppressWarnings("unchecked")
    @Override
    public void getentityCarousel(String adstype, final IUnifiedDataListener<EntityCarouselFigure> miUnifiedDataListener) {
       HttpManagerFood.getmHttpManagerFood().getentityCarousel(adstype)
               .subscribeOn(Schedulers.newThread())
               .observeOn(Schedulers.io())
               .doOnNext(new Consumer<EntityCarouselFigure>() {
                   @Override
                   public void accept(@NonNull EntityCarouselFigure entityCarouselFigure) throws Exception {
                      miUnifiedDataListener.success(entityCarouselFigure);
                   }
               })
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Subscriber<EntityCarouselFigure>() {
                   @Override
                   public void onSubscribe(Subscription s) {

                   }

                   @Override
                   public void onNext(EntityCarouselFigure entityCarouselFigure) {

                   }

                   @Override
                   public void onError(Throwable t) {
                       Log.e("Carousel", "轮播网络请求有错误，请注意！");
                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }

    @Override
    public void getPoints(final IUnifiedDataListener<EntityPoints> miUnifiedDataListener) {
        HttpManagerFood.getmHttpManagerFood().getPoints()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityPoints>() {
                    @Override
                    public void accept(@NonNull EntityPoints entityPoints) throws Exception {
                        miUnifiedDataListener.success(entityPoints);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityPoints>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityPoints entityPoints) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("points", "配送点网络请求有错误，请注意！");
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
