package com.ings.gogo.homehuiui.homehuifood.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuitools.impl.ToolsDecoration;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuifood.adapter.AdaptePayment;
import com.ings.gogo.homehuiui.homehuifood.adapter.AdapteShare;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitShare;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
@Route(path = "/Food/Fragment/ShareActivityView", name = "详情")
public class ShareActivityView extends BaseActivity {

    @BindView(R.id.name_detailedcasetable_id)
    RecyclerView nameDetailedcasetableId;

    @BindView(R.id.Layout_laoli0)
    LinearLayout LayoutLaoli0;
    private AdapteShare mSetAdapter;

    @Autowired
    String proname;
    @Autowired
    String Imgurl;

    private List<EntitShare> mEntitShares=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_view);
        iniRecyclerview();
        adddata();
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    public void iniRecyclerview() {
        nameDetailedcasetableId.setLayoutManager(new LinearLayoutManager(this));
        nameDetailedcasetableId.addItemDecoration(new ToolsDecoration(this, ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_F2F2F2));
        mSetAdapter=new AdapteShare(ShareActivityView.this,null);
        nameDetailedcasetableId.setAdapter(mSetAdapter);
    }

    public void adddata(){
        //详情标题
        EntitShare entitSharedetailedcase=new EntitShare();
        entitSharedetailedcase.setItemType(EntitShare.TYPE_ONE);
        entitSharedetailedcase.setProname(proname);
        entitSharedetailedcase.setImgurl(Imgurl);
        mEntitShares.add(entitSharedetailedcase);
        mSetAdapter.setNewData(mEntitShares);

        EntitShare entitSharedetailedhints=new EntitShare();
        entitSharedetailedhints.setItemType(EntitShare.TYPE_TWO);
        mEntitShares.add(entitSharedetailedhints);
        mSetAdapter.setNewData(mEntitShares);

        EntitShare entitSharefood=new EntitShare();
        entitSharefood.setItemType(EntitShare.TYPE_THREE);
        mEntitShares.add(entitSharefood);
        mSetAdapter.setNewData(mEntitShares);
    }
}
