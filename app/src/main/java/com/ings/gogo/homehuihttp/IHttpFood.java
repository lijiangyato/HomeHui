package com.ings.gogo.homehuihttp;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.ings.gogo.homehuidata.food.entity.EntityCarouselFigure;
import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.food.entity.EntityPoints;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IHttpFood {

    /**
     * @购物车详情例表参数
     */
    @GET("getproducts?")
    Flowable<EntityFood> getDetailsTable(
     @Query("pointid") String pointid,
     @Query("categoryid") String categoryid,
     @Query("figure") String figuer
    );


    /**
     * @轮播图
     */
    @GET("getads?")
    Flowable<EntityCarouselFigure> getCarouselFigure(
            @Query("adstype")  String adstype
    );



    /**
     * @配送点
     * */
    @GET("getpoints")
    Flowable<EntityPoints> getPoints();

}
