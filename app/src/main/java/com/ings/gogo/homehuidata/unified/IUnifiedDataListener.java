package com.ings.gogo.homehuidata.unified;

/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/
public interface IUnifiedDataListener<T> {

    void success(T response); // 获取数据成功

    void fail(int errCode, String msg); // 获取数据失败
}
