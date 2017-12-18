package com.ings.gogo.homehuidata.db.model.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.content.Context;

import com.ings.gogo.homehuidata.db.moldeldata.DaoMaster;
import com.ings.gogo.homehuidata.db.moldeldata.DaoSession;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb0;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb1;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;

//@Route(path = "/db/model/Database",name = "商品数据")
public class Database  /*implements IDatabase*/ {

    private DaoSession mDaoSession;
    private DaoMaster mDaoMaster;
    private DaoMaster.DevOpenHelper devOpenHelper;
    public Context mContext;
    public String mdb;

    public Database(Context context,String db) {
        this.mContext = context;
        this.mdb=db;
        devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "add.db", null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();

    }
    /*@插入数据例表*/
    public void  inceradd(final SurfaceModeldb1 surfaceModeldb1){
        mDaoSession.getSurfaceModeldb1Dao().insert(surfaceModeldb1);
    }
    /*@查询全部数据*/
    public Observable<List<SurfaceModeldb1>> getinceradd(){
        return Observable.fromCallable(new Callable<List<SurfaceModeldb1>>() {
            @Override
            public List<SurfaceModeldb1> call() throws Exception {
                return mDaoSession.getSurfaceModeldb1Dao().loadAll();
            }
        });
    }


}
