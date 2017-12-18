package com.ings.gogo.homehuiui.homehuifood.entity;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import com.flyco.tablayout.listener.CustomTabEntity;

public class EntityTab implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public EntityTab(String title/*int selectedIcon, int unSelectedIcon*/) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
