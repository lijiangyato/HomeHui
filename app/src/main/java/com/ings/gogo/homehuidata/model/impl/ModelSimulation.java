package com.ings.gogo.homehuidata.model.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:模拟数据
*/

import android.util.Log;

import com.ings.gogo.homehuidata.model.IModelSimulation;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuidata.update.EntityRenovate;
import com.ings.gogo.homehuihttp.manager.HttpManagerSimulation;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ModelSimulation implements IModelSimulation {

    @Override
    public void getSimulation(final IUnifiedDataListener<EntityRenovate> miUnifiedDataListener) {
        HttpManagerSimulation.getmHttpManagerSimulation().getSimulation()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityRenovate>() {
                    @Override
                    public void accept(@NonNull EntityRenovate entityRenovate) throws Exception {
                         if (entityRenovate.isSuccess()==true){
                             miUnifiedDataListener.success(entityRenovate);
                         }
                         else {
                             miUnifiedDataListener.fail(001,"请求失败");
                         }


                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityRenovate>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityRenovate entityRenovate) {

                    }

                    @Override
                    public void onError(Throwable t) {
                     Log.e("xiaojaing","有错误请检查");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
