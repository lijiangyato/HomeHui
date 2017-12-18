package com.ings.gogo.homehuihttp;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.ings.gogo.homehuidata.update.entity.EntityUpdate;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IHttpUpdate {

    /**
     * @ 数据更新请求参数
     */

    @GET("getversion?")
    Flowable<EntityUpdate> getUpdate(
            @Query("plat") String plat
    );
}
