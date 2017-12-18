package com.ings.gogo.homehuidata.model;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuidata.update.EntityRenovate;

public interface IModelSimulation {

    void getSimulation(IUnifiedDataListener<EntityRenovate> miUnifiedDataListener);


}
