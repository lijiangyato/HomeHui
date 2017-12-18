package com.ings.gogo.homehuidata.db.model.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.content.Context;

import com.ings.gogo.homehuidata.db.model.IDataloadAll;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb0;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb1;

import java.util.List;

import io.reactivex.Observable;

public class DataloadAll  implements IDataloadAll{
    public Context mContext;
    public Database mdatabase;
    public String mdb;

    public DataloadAll(Context context,String db){
        this.mdb=db;
        this.mContext=context;
        mdatabase=new Database(mContext,mdb);
    }





    /*查询所有的地址数据*/
    @Override
    public Observable<List<SurfaceModeldb1>> getinceradd() {
        return mdatabase.getinceradd();
    }


}
