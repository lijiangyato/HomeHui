package com.ings.gogo.homehuihttp.manager;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:登录！注册！忘记密码！验证码
*/

import com.ings.gogo.homehuidata.index.entity.EntityCode;
import com.ings.gogo.homehuidata.index.entity.EntityIndex;
import com.ings.gogo.homehuidata.index.entity.EntityIntegral;
import com.ings.gogo.homehuidata.index.entity.EntityPassword;
import com.ings.gogo.homehuidata.index.entity.EntitycHeck;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;
import com.ings.gogo.homehuihttp.HttpRetrrofi;
import com.ings.gogo.homehuihttp.IHttpIndex;

import io.reactivex.Flowable;

public class HttpManagerIndex {
    public static HttpManagerIndex mHttpManagerIndex;

    public static IHttpIndex miHttpIndex;
    public HttpManagerIndex(){

    }
    public static HttpManagerIndex getmHttpManagerIndex(){
        if (mHttpManagerIndex==null){
            synchronized (IHttpIndex.class){
                if (mHttpManagerIndex==null){
                    mHttpManagerIndex=new HttpManagerIndex();
                    miHttpIndex= HttpRetrrofi.getmRetrofitIndex().create(IHttpIndex.class);
                }
            }
        }
        return mHttpManagerIndex;
    }

    /**
     * @登录
     */
    public Flowable<EntityIndex> getIndex(String phone, String loginkey){
        return miHttpIndex.getIndex(phone,loginkey);
    }
    /**
     * @注册验证码
     */
    public Flowable<EntityCode> getCode(String phone,String verclassify){
        return miHttpIndex.getCode(phone,verclassify);
    }
    /**
     * @校验验证码
     */
    public Flowable<EntitycHeck> getcheck(String phone,String code){
        return miHttpIndex.getcheck(phone,code);
    }
    /**
     * @开始注册
     */
    public Flowable<EntitycReset> getEnroll(String phone,String smscode,String loginkey){
        return miHttpIndex.getEnroll(phone,smscode,loginkey);
    }
    /**
     * @忘记密码
     */
    public Flowable<EntityPassword> getPassword(String phome, String smscode,String loginkey){
         return miHttpIndex.getPassword(phome,smscode,loginkey);
    }
    /**
     * @积分
     */
    public Flowable<EntityIntegral>getIntegral(){
        return miHttpIndex.getIntegral();
    }
}
