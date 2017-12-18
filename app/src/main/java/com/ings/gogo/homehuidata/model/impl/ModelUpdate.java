package com.ings.gogo.homehuidata.model.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:版本更新
*/

import com.ings.gogo.homehuidata.model.IModelUpdate;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuidata.update.entity.EntityUpdate;
import com.ings.gogo.homehuihttp.manager.HttpManagerUpdate;
import com.socks.library.KLog;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ModelUpdate implements IModelUpdate{
    @Override
    public void getUpdate(String plat, final IUnifiedDataListener<EntityUpdate> miUnifiedDataListener) {
        HttpManagerUpdate.getmHttpManagerUpdate().getUpdate(plat)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<EntityUpdate>() {
                    @Override
                    public void accept(@NonNull EntityUpdate entityUpdate) throws Exception {
                           if (entityUpdate.isSuccess()==true){
                               miUnifiedDataListener.success(entityUpdate);
                           }
                           else {
                               miUnifiedDataListener.fail(002,"更新部分请求网络失败");
                           }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<EntityUpdate>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(EntityUpdate entityUpdate) {

                    }

                    @Override
                    public void onError(Throwable t) {
                        KLog.e("00x1","有错误:请检查更新");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
