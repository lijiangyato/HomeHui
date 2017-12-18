package com.ings.gogo.homehuihttp.manager;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.ings.gogo.homehuidata.update.EntityRenovate;
import com.ings.gogo.homehuihttp.HttpRetrrofi;
import com.ings.gogo.homehuihttp.IHttpSimulation;

import io.reactivex.Flowable;

public class HttpManagerSimulation {
    public  static  HttpManagerSimulation mHttpManagerSimulation;
    //请求参数
    public static IHttpSimulation mIHttpSimulation;

    public HttpManagerSimulation(){

    }
    public static  HttpManagerSimulation getmHttpManagerSimulation(){
        if (mHttpManagerSimulation==null){
            synchronized (IHttpSimulation.class){
                if (mHttpManagerSimulation==null){
                    mHttpManagerSimulation=new HttpManagerSimulation();
                    mIHttpSimulation= HttpRetrrofi.getretrofit().create(IHttpSimulation.class);
                }
            }
        }
        return mHttpManagerSimulation;
    }

    /**
     * @ 模拟数据
     */
    public Flowable<EntityRenovate>  getSimulation(){
        return mIHttpSimulation.getSimulation();
    }


}
