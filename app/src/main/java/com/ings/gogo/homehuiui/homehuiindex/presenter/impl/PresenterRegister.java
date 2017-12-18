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
import com.ings.gogo.homehuidata.index.entity.EntityCode;
import com.ings.gogo.homehuidata.index.entity.EntitycHeck;
import com.ings.gogo.homehuidata.model.IModelndex;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterRegister;
import com.ings.gogo.homehuiui.homehuiindex.view.IRegisterActivityView;
import com.socks.library.KLog;

public class PresenterRegister implements IPresenterRegister {
    //数据模型
    @Autowired
    IModelndex mIModelndex;
    //视图模型
    private IRegisterActivityView mIRegisterActivityView;

    public PresenterRegister(IRegisterActivityView iRegisterActivityView) {
        this.mIRegisterActivityView = iRegisterActivityView;
        ARouter.getInstance().inject(this);
    }

    /*@注册手机验证码*/
    @Override
    public void senCodePresenter(String phone, String verclassify) {
        mIModelndex.getCode(phone, verclassify, new IUnifiedDataListener<EntityCode>() {
            @Override
            public void success(EntityCode response) {
                KLog.e("00003", "手机号码验证码数据请求成功");
                mIRegisterActivityView.senCodeView(response);
            }

            @Override
            public void fail(int errCode, String msg) {
                KLog.e("00003", "手机号码验证码数据请求成功");
            }
        });
    }

    /*@手机校验码*/
    @Override
    public void setCheckPresenter(String phone, String code) {

        mIModelndex.getcheck(phone, code, new IUnifiedDataListener<EntitycHeck>() {
            @Override
            public void success(EntitycHeck response) {
                KLog.e("00004", "校验码数据请求成功");
                mIRegisterActivityView.setcheckView(response);

            }

            @Override
            public void fail(int errCode, String msg) {

            }
        });

    }
}
