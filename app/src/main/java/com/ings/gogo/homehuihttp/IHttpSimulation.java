package com.ings.gogo.homehuihttp;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:模拟网络请求参数
*/

import com.ings.gogo.homehuidata.update.EntityRenovate;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface IHttpSimulation {

    /**
     * @ 模拟数据
     */
    @GET("teacher?type=4&num=30")
    Flowable<EntityRenovate> getSimulation();

}
