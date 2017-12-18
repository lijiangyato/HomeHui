package com.ings.gogo.homehuihttp.manager;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:商品详情
*/

import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.food.entity.EntityCarouselFigure;
import com.ings.gogo.homehuidata.food.entity.EntityPoints;
import com.ings.gogo.homehuihttp.HttpRetrrofi;
import com.ings.gogo.homehuihttp.IHttpFood;

import io.reactivex.Flowable;

public class HttpManagerFood {
    public static HttpManagerFood mHttpManagerFood;
   //外买
    public static IHttpFood mIHttpFood;
    public HttpManagerFood(){

    }
    /*商品详情*/
    public static HttpManagerFood getmHttpManagerFood(){
        if (mHttpManagerFood==null){
            synchronized (IHttpFood.class){
                if (mHttpManagerFood==null){
                    mHttpManagerFood=new HttpManagerFood();
                      mIHttpFood= HttpRetrrofi.getmRetrofitfood().create(IHttpFood.class);
                }
            }
        }
        return mHttpManagerFood;
    }

    /**
     * @轮播图
     */
    public Flowable<EntityCarouselFigure> getentityCarousel(String adstype){
        return mIHttpFood.getCarouselFigure(adstype);
    }

    /**
     * @购物车详情例表方法
     */
    public Flowable<EntityFood> getDetailsTable(String pointid,String categoryid,String figure){
        return mIHttpFood.getDetailsTable(pointid,categoryid,figure);
    }

    /**
     * @配送点
     * */
    public Flowable<EntityPoints> getPoints(){
        return mIHttpFood.getPoints();
    }
}
