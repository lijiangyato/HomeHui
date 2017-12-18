package com.ings.gogo.homehuiui.homehuiaddress.presenter.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.ings.gogo.homehuiui.homehuiaddress.presenter.IPresenterAddress;
import com.ings.gogo.homehuiui.homehuiaddress.view.IAddressActivityView;

public class PresenterAddress  implements IPresenterAddress{

    //视图模型
    private IAddressActivityView mIAddressActivityView;

    public PresenterAddress(IAddressActivityView iAddressActivityView){
        this.mIAddressActivityView=iAddressActivityView;

    }
    @Override
    public void setAddressPresenter() {



    }
}
