package com.ings.gogo.homehuiui.homehuibase.adapter;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.ings.gogo.homehuiui.homehuifood.view.impl.FoodFragmentView;

import java.util.List;

public class AdapterMain  extends FragmentStatePagerAdapter{
    private List<Fragment>mFragments;
    public AdapterMain(FragmentManager fm, List<Fragment> mfragments) {
        super(fm);
        this.mFragments=mfragments;
    }

    @Override
    public Fragment getItem(int position) {


        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        /*super.destroyItem(container, position, object);*/

    }


}
