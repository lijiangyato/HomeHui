package com.ings.gogo.homehuiui.homehuifood.view;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.food.entity.EntityCarouselFigure;
import com.ings.gogo.homehuidata.food.entity.EntityPoints;

public interface IFoodFragmentView {
    //商品详情数据
    void setDetailsTableView(EntityFood mentityFood);
    void setCarouselFigureView(EntityCarouselFigure entityCarouselFigure);
    void setgetPointsView(EntityPoints entityPoints);


}
