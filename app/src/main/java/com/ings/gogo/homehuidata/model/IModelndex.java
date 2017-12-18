package com.ings.gogo.homehuidata.model;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import com.alibaba.android.arouter.facade.template.IProvider;
import com.ings.gogo.homehuidata.index.entity.EntityCode;
import com.ings.gogo.homehuidata.index.entity.EntityIndex;
import com.ings.gogo.homehuidata.index.entity.EntityIntegral;
import com.ings.gogo.homehuidata.index.entity.EntityPassword;
import com.ings.gogo.homehuidata.index.entity.EntitycHeck;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;

public interface IModelndex extends IProvider{
    /*@登录*/
    void getIndex(String phone, String loginkey,IUnifiedDataListener<EntityIndex> miUnifiedDataListener);

    /*@注册验证码*/
    void getCode(String phone, String verclassify, IUnifiedDataListener<EntityCode> miUnifiedDataListener);

    /*@校验码*/
    void getcheck(String phone, String code, IUnifiedDataListener<EntitycHeck> miUnifiedDataListener);

    /*@开始注册*/
    void getEnroll(String phone, String smscode, String loginkey, IUnifiedDataListener<EntitycReset> miUnifiedDataListener);

    /*@忘记密码*/
    void getPassword(String phone, String smscode, String loginkey, IUnifiedDataListener<EntityPassword> miUnifiedDataListener);
    /*@获取积分总数*/
    void getIntegral( IUnifiedDataListener<EntityIntegral> miUnifiedDataListener);


}
