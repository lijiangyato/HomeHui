package com.ings.gogo.homehuiui.homehuiindex.view;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:登录视图层
*/

import com.ings.gogo.homehuidata.index.entity.EntityCode;
import com.ings.gogo.homehuidata.index.entity.EntitycHeck;

public interface IRegisterActivityView {
    /**
     * 验证码发送成功
     */
    void senCodeView(EntityCode entityCode);
    /**
     * 校验成功
     */
    void setcheckView(EntitycHeck entitycHeck);
}
