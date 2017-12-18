package com.ings.gogo.homehuiui.homehuiaddress.view.impl;
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
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.db.model.IDataloadAll;
import com.ings.gogo.homehuidata.db.model.impl.DataloadAll;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb1;
import com.ings.gogo.homehuihttp.constant.Constant;
import com.ings.gogo.homehuitools.impl.ToolsDecoration;
import com.ings.gogo.homehuiui.homehuiaddress.adapter.AdaptSaveaAddress;
import com.ings.gogo.homehuiui.homehuiaddress.entity.EntityAddress;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@Route(path = "/address/activity/SaveAddressActivityView", name = "地址")

public class SaveAddressActivityView extends BaseActivity {
    @BindView(R.id.name_toolbar_id)
    Toolbar nameToolbarId;
    @BindView(R.id.name_Table_id)
    RecyclerView nameTableId;

    private IDataloadAll iDataloadAll;
    private AdaptSaveaAddress mAdaptSaveaAddress;
    private List<EntityAddress> mEntityAddresses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_saveaddress_view);
        iDataloadAll = new DataloadAll(this, Constant.TYPE_TWO);
        initialdata();
        querygor();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    public void initialdata() {
        nameTableId.setLayoutManager(new LinearLayoutManager(this));
        nameTableId.addItemDecoration(new ToolsDecoration(this, ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_F2F2F2));
        mAdaptSaveaAddress = new AdaptSaveaAddress(SaveAddressActivityView.this, null);
        nameTableId.setAdapter(mAdaptSaveaAddress);
        EntityAddress address = new EntityAddress();
        address.setItemType(EntityAddress.TYPE_TWO);
        mEntityAddresses.add(address);
        mAdaptSaveaAddress.setNewData(mEntityAddresses);
        mAdaptSaveaAddress.setOonAddresscallbackinterface(new AdaptSaveaAddress.OonAddresscallbackinterface() {
            @Override
            public void callbackAddress(View view) {
                ARouter.getInstance().build("/index/activity/AddressActivityView").navigation();
            }
        });
    }

    /*@查询*/
    public void querygor() {
        iDataloadAll.getinceradd()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<List<SurfaceModeldb1>>() {
                    @Override
                    public void accept(@NonNull List<SurfaceModeldb1> surfaceModeldb1s) throws Exception {
                        if (surfaceModeldb1s.size() > 0) {
                            EventBus.getDefault().post(surfaceModeldb1s);
                        } else {
                            KLog.a("querygor", "还未添加新地址");
                        }

                    }
                });

    }


    /*数据通知*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void saveadd(List<SurfaceModeldb1> surfaceModeldb) {
        for (int i = 0; i < surfaceModeldb.size(); i++) {
            EntityAddress entityAddress = new EntityAddress();
            entityAddress.setItemType(EntityAddress.TYPE_ONE);
            entityAddress.setFullname(surfaceModeldb.get(i).getPullname());
            entityAddress.setNumber(surfaceModeldb.get(i).getNumber());
            entityAddress.setQuarters(surfaceModeldb.get(i).getDetailedaddress());
            entityAddress.setBuilding(surfaceModeldb.get(i).getRemarks());
            mEntityAddresses.add(entityAddress);
            mAdaptSaveaAddress.setNewData(mEntityAddresses);

        }

    }

}
