package com.ings.gogo.homehuihttp.manager;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:更新
*/

import com.ings.gogo.homehuidata.update.entity.EntityUpdate;
import com.ings.gogo.homehuihttp.HttpRetrrofi;
import com.ings.gogo.homehuihttp.IHttpUpdate;

import io.reactivex.Flowable;

public class HttpManagerUpdate {

    public static HttpManagerUpdate mHttpManagerUpdate;
    public static IHttpUpdate mIHttpUpdate;

    public HttpManagerUpdate(){

    }

    public static HttpManagerUpdate getmHttpManagerUpdate(){
        if (mHttpManagerUpdate==null){
            synchronized (IHttpUpdate.class){
                if (mHttpManagerUpdate==null){
                    mHttpManagerUpdate=new HttpManagerUpdate();
                    mIHttpUpdate= HttpRetrrofi.getmRetrofitUpdate().create(IHttpUpdate.class);
                }
            }
        }
        return mHttpManagerUpdate;
    }

    public Flowable<EntityUpdate> getUpdate(String plat){
        return mIHttpUpdate.getUpdate(plat);

    }
}
