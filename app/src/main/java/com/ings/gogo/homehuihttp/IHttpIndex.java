package com.ings.gogo.homehuihttp;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:登陆注册
*/

import com.ings.gogo.homehuidata.index.entity.EntityCode;
import com.ings.gogo.homehuidata.index.entity.EntityIndex;
import com.ings.gogo.homehuidata.index.entity.EntityIntegral;
import com.ings.gogo.homehuidata.index.entity.EntityPassword;
import com.ings.gogo.homehuidata.index.entity.EntitycHeck;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IHttpIndex {
    /**
     * @ @手机号码验证码
     */
    @GET("sendsms?")
    Flowable<EntityCode> getCode(
            @Query("phone") String phone,
            @Query("verclassify") String verclassify
    );
    /**
     * @ 登陆
     */
     @POST("login")
     Flowable<EntityIndex>getIndex(
             @Query("phone") String phone,
             @Query("loginkey") String loginkey
     );

    /**
     * @ 校验验证码
     */

    @GET("checksmscode?")
    Flowable<EntitycHeck> getcheck(
            @Query("phone") String phone,
            @Query("code") String code
    );
    /**
     * @开始注册
     */
    @POST("register/")
    Flowable<EntitycReset> getEnroll(
            @Query("phone") String phone,
            @Query("smscode") String smscode,
            @Query("loginkey") String loginkey
    );

    /**
     * @忘记密码
     */
   @POST("resetpwd")
    Flowable<EntityPassword> getPassword(
            @Query("phone") String phome,
            @Query("smscode") String smscode,
            @Query("loginkey") String loginkey
   );
    /**
     * @获取积分总数
     */
    @GET("getscoreinfo")
    Flowable<EntityIntegral> getIntegral();

}
