package com.ings.gogo.homehuiui.homehuibase.view.impl;


import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;




import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


import com.idescout.sql.SqlScoutServer;
import com.ings.gogo.R;

import com.ings.gogo.homehuitools.impl.ToolsDuiKuang;
import com.ings.gogo.homehuitools.impl.ToolsUpdate;
import com.ings.gogo.homehuiui.homehuibase.adapter.AdapterMain;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuibase.animation.AnimationMain;
import com.socks.library.KLog;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import devlight.io.library.ntb.NavigationTabBar;

@Route(path = "/main/activity/MainActivityView", name = "首页")

public class MainActivityView extends BaseActivity {
   public List<Fragment> mlistfragment;
    public ToolsUpdate mToolsUpdate;
    //ViewPager滑动页
    @BindView(R.id.name_horizontal_id)
    ViewPager nameHorizontalId;
    //底部滑动导航栏
    @BindView(R.id.name_TabBar_id)
    NavigationTabBar nameTabBarId;
    public ToolsDuiKuang toolsDuiKuang;
    public String namew="我的";
   public AdapterMain madapterMain;
    public  ArrayList<NavigationTabBar.Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        mToolsUpdate = new ToolsUpdate(this);
        toolsDuiKuang=new ToolsDuiKuang(this);
        SqlScoutServer.create(this, getPackageName());
        initPaging();


    }


     /*@通知改变导航栏数据*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String tring) {
        if (tring.equals("jiang")){

            namew="个人中心";
            models.get(3).setTitle(namew);
            //更新导航数据
            nameTabBarId.deselect();
        }

    }

    /*初始话数据*/
    public void initPaging() {


        mlistfragment = new ArrayList<>();
        //外买
        mlistfragment.add((Fragment) ARouter.getInstance().build("/Food/Fragment/FoodFragmentView").navigation());
        /*//订单
        mlistfragment.add((Fragment) ARouter.getInstance().build("/Consul/Fragment/ConsultFragmentView").navigation());*/
        //关于
        mlistfragment.add((Fragment) ARouter.getInstance().build("/about/Fragment/AboutFragmentView").navigation());
            //个人中心
        mlistfragment.add((Fragment) ARouter.getInstance().build("/index/activity/IndexFragmentView").navigation());




        //初始化适配器
         madapterMain = new AdapterMain(this.getSupportFragmentManager(), mlistfragment);
        nameHorizontalId.setOffscreenPageLimit(3);
        nameHorizontalId.setAdapter(madapterMain);
      //  nameHorizontalId.setPageTransformer(true, new AnimationMain());
        nameHorizontalId.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==3){



                }else {

                }

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("lijiang","lllllllll"+position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("lijiang","jjjjjjjjjjj"+state);

            }
        });




        final String[] colors = getResources().getStringArray(R.array.homehui);
        models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_food),
                        Color.parseColor(colors[0]))
                        .title("外买")
                        .build()
        );
       /* models.add(
                new NavigationTabBar.Model.Builder(getResources()
                        .getDrawable(R.drawable.icon_consui), Color.parseColor(colors[1]))
                        .title("订单")
                        .build()
        );*/
        models.add(
                new NavigationTabBar.Model.Builder(getResources()
                        .getDrawable(R.drawable.icon_about),
                        Color.parseColor(colors[2]))
                        .title("关于")
                        .build()
        );



        if (false){
            models.add(
                    new NavigationTabBar.Model.Builder(getResources()
                            .getDrawable(R.drawable.icon_personai),
                            Color.parseColor(colors[3]))
                            .title("个人中心")
                            .build()
            );
        }else {



            models.add(
                    new NavigationTabBar.Model.Builder(getResources()
                            .getDrawable(R.drawable.icon_personai),
                            Color.parseColor(colors[3]))
                            .title(namew)
                            .build()
            );
        }







        nameTabBarId.setModels(models);
        nameTabBarId.setViewPager(nameHorizontalId);
        nameTabBarId.setBehaviorEnabled(true);

        nameTabBarId.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(NavigationTabBar.Model model, int i) {
                model.hideBadge();

                KLog.a("XIAO",model+""+i+"");
            }

            @Override
            public void onEndTabSelected(NavigationTabBar.Model model, int i) {
                KLog.a("XIAO",model+""+i+"");
            }
        });
        nameTabBarId.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                KLog.a("JIANG",position+"");
            }

            @Override
            public void onPageSelected(int position) {
                KLog.a("JIANG",position+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                KLog.a("JIANG",state+"");
            }
        });

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


}
