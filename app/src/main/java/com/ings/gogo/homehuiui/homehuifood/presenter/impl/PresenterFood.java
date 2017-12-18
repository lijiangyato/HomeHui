package com.ings.gogo.homehuiui.homehuifood.presenter.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:控制成
*/


import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.food.entity.EntityCarouselFigure;
import com.ings.gogo.homehuidata.food.entity.EntityPoints;
import com.ings.gogo.homehuidata.model.IModelFood;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuiui.homehuifood.presenter.IPresenterFood;
import com.ings.gogo.homehuiui.homehuifood.view.IFoodFragmentView;
import com.socks.library.KLog;


public class PresenterFood implements IPresenterFood {
    //数据模型
    @Autowired
    IModelFood miModelFood;
    //视图模型
    private IFoodFragmentView mIFoodFragmentView;

    public PresenterFood(IFoodFragmentView iFoodFragmentView) {
        this.mIFoodFragmentView=iFoodFragmentView;
        ARouter.getInstance().inject(this);
    }


    @Override
    public void setDetailsTablePresenter(String pointid, String categoryid, String figure) {
        miModelFood.getDetailsTable(pointid, categoryid, figure, new IUnifiedDataListener<EntityFood>() {
            @Override
            public void success(EntityFood response) {
                KLog.e("00001", "商品详情数据请求成功");
                mIFoodFragmentView.setDetailsTableView(response);

            }

            @Override
            public void fail(int errCode, String msg) {
                KLog.d("00001", "商品详情网络数据请求失败！请检查");
            }
        });
    }

    @Override
    public void setentityCarouselPresenter(String adstype) {
        miModelFood.getentityCarousel(adstype, new IUnifiedDataListener<EntityCarouselFigure>() {
            @Override
            public void success(EntityCarouselFigure response) {
                KLog.e("00002", "轮播图数据请求成功");
                mIFoodFragmentView.setCarouselFigureView(response);
            }

            @Override
            public void fail(int errCode, String msg) {
                KLog.d("00002", "轮播图网络数据请求失败！请检查");
            }
        });
    }

    @Override
    public void setgetPoints() {
        miModelFood.getPoints(new IUnifiedDataListener<EntityPoints>() {
            @Override
            public void success(EntityPoints response) {
                KLog.e("00003", "配送点数据请求成功");
                mIFoodFragmentView.setgetPointsView(response);
            }

            @Override
            public void fail(int errCode, String msg) {

            }
        });
    }


}
