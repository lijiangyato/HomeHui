package com.ings.gogo.homehuidata.db.model;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb1;
import java.util.List;
import io.reactivex.Observable;
public interface IDataloadAll {
    Observable<List<SurfaceModeldb1>> getinceradd();
}
