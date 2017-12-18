package com.ings.gogo.homehuidata.model;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import com.alibaba.android.arouter.facade.template.IProvider;
import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.food.entity.EntityCarouselFigure;
import com.ings.gogo.homehuidata.food.entity.EntityPoints;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;

public interface IModelFood  extends IProvider {
     //商品详情
    void getDetailsTable(String pointid,String categoryid,String figure,IUnifiedDataListener<EntityFood> miUnifiedDataListener);
    //轮播图片
    void getentityCarousel(String adstype,IUnifiedDataListener<EntityCarouselFigure> miUnifiedDataListener);
    //配送点
    void getPoints(IUnifiedDataListener<EntityPoints> miUnifiedDataListener);
}
