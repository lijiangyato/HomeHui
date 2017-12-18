package com.ings.gogo.homehuiui.homehuiindex.presenter.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.homehuidata.index.entity.EntityPassword;
import com.ings.gogo.homehuidata.model.IModelndex;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterPassword;
import com.ings.gogo.homehuiui.homehuiindex.view.IPasswordActiviView;
import com.socks.library.KLog;

public class PresenterPassword implements IPresenterPassword {
    //数据模型层
    @Autowired
    IModelndex mIModelndex;
    //视图模型层
    private IPasswordActiviView mIPasswordActiviView;

    public PresenterPassword(IPasswordActiviView iPasswordActiviView) {
        this.mIPasswordActiviView = iPasswordActiviView;
        ARouter.getInstance().inject(this);
    }

    /*@忘记密码*/
    @Override
    public void setPasswordPresenter(String phome, String smscode, String loginkey) {

               mIModelndex.getPassword(phome, smscode, loginkey, new IUnifiedDataListener<EntityPassword>() {
                   @Override
                   public void success(EntityPassword response) {
                       mIPasswordActiviView.setPasswordView(response);
                       KLog.e("00006", "忘记数据请求成功");
                   }

                   @Override
                   public void fail(int errCode, String msg) {

                   }
               });
    }
}
