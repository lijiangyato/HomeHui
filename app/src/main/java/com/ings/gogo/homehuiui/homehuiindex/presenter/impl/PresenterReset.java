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
import com.ings.gogo.homehuidata.index.entity.EntitycReset;
import com.ings.gogo.homehuidata.model.IModelndex;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterReset;
import com.ings.gogo.homehuiui.homehuiindex.view.IResetActivityView;
import com.socks.library.KLog;


public class PresenterReset implements IPresenterReset {
    //数据模型层
    @Autowired
    IModelndex mIModelndex;
    //视图模型层
    public IResetActivityView mIResetActivityView;

    public PresenterReset(IResetActivityView iResetActivityView){
        this.mIResetActivityView=iResetActivityView;
        ARouter.getInstance().inject(this);
    }

    /*@账号密码注册*/
    @Override
    public void setEnrollPresenter(String phone, String smscode, String loginkey) {
        mIModelndex.getEnroll(phone, smscode, loginkey, new IUnifiedDataListener<EntitycReset>() {
            @Override
            public void success(EntitycReset response) {
                mIResetActivityView.setEnrollView(response);
                KLog.e("00005", "注册数据请求成功");
            }

            @Override
            public void fail(int errCode, String msg) {

            }
        });
    }
}
