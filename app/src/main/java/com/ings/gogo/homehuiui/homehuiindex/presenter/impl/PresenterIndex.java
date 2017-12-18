package com.ings.gogo.homehuiui.homehuiindex.presenter.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:登录控制层
*/

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.homehuidata.index.entity.EntityIndex;
import com.ings.gogo.homehuidata.model.IModelndex;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterIndex;
import com.ings.gogo.homehuiui.homehuiindex.view.IIndexFragmentView;
import com.socks.library.KLog;


public class PresenterIndex implements IPresenterIndex {
    //数据模型
     @Autowired
     IModelndex mIModelndex;
    //视图模型
    private IIndexFragmentView mIIndexFragmentView;

    public PresenterIndex(IIndexFragmentView iIndexFragmentView) {
        this.mIIndexFragmentView = iIndexFragmentView;
        ARouter.getInstance().inject(this);
    }

    @Override
    public void setIndexPresenter(String phone, String loginkey) {
     mIModelndex.getIndex(phone, loginkey, new IUnifiedDataListener<EntityIndex>() {
         @Override
         public void success(EntityIndex response) {
             KLog.e("00002", "登录数据请求成功");
             KLog.a("test",response.isSuccess()+""+response.getMsg()+""+response.getData());
             mIIndexFragmentView.setIndexView(response);
         }

         @Override
         public void fail(int errCode, String msg) {
             KLog.e("00002", "登录数据请求失败！请检查");
         }
     });
    }

    @Override
    public void setIndexPersonalPresenter() {
        mIIndexFragmentView.setIndexPersonalView();
    }
}
