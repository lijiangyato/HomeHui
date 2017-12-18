package com.ings.gogo.homehuiui.homehuifood.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Param;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb1;
import com.ings.gogo.homehuitools.impl.ToolsDecoration;
import com.ings.gogo.homehuiui.homehuiaddress.view.impl.SaveAddressActivityView;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuifood.adapter.AdaptePayment;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitExhibition;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityOrderForm;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = "/Food/Fragment/PaymentActivityView", name = "提交订单")
public class PaymentActivityView extends BaseActivity {
    @BindView(R.id.name_toolbar_id)
    Toolbar nameToolbarId;
    @BindView(R.id.name_Total_id)
    TextView nameTotalId;
    @BindView(R.id.name_Amountofmoney_id)
    TextView nameAmountofmoneyId;
    @BindView(R.id.name_Submit_id)
    LinearLayout nameSubmitId;
    @BindView(R.id.name_menulist_id)
    RecyclerView nameMenulistId;
    public List<EntitExhibition> entitExhibitions;





    private EntityOrderForm entityOrderFormAdderss = new EntityOrderForm();

    private AdaptePayment mAdaptePayment;

    private List<EntityOrderForm> mEntityOrderForms=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_view);

        EventBus.getDefault().register(this);
        Intent intent=this.getIntent();
        entitExhibitions= (List<EntitExhibition>) intent.getSerializableExtra("lijiang");
        iniRecyclerview();
        adddata();
    }
    /*通知地址*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void saveadd(SurfaceModeldb1 surfaceModeldb1s) {
        entityOrderFormAdderss.setProname(surfaceModeldb1s.getPullname());
        mAdaptePayment.notifyDataSetChanged();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
    }

    public void iniRecyclerview() {
        nameMenulistId.setLayoutManager(new LinearLayoutManager(this));
        nameMenulistId.addItemDecoration(new ToolsDecoration(this, ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_F2F2F2));
        mAdaptePayment=new AdaptePayment(PaymentActivityView.this,null);
        nameMenulistId.setAdapter(mAdaptePayment);
        mAdaptePayment.setmOnaddressinterface(new AdaptePayment.onaddressinterface() {
            @Override
            public void onAddressCallback(View view) {
                ARouter.getInstance().build("/address/activity/SaveAddressActivityView").navigation();

            }
        });

    }


    public void adddata(){
        //新增收货地址
        entityOrderFormAdderss.setItemType(EntityOrderForm.TYPE_ONE);
        mEntityOrderForms.add(entityOrderFormAdderss);
        entityOrderFormAdderss.setProname("添加收货地址");

        //陪送提示
        EntityOrderForm entityOrderFormPrompt=new EntityOrderForm();
        entityOrderFormPrompt.setItemType(EntityOrderForm.TYPE_TWO);
        mEntityOrderForms.add(entityOrderFormPrompt);

         //菜单例表
        for (int i=0;i<entitExhibitions.size();i++){
            EntityOrderForm entityOrderFormMenu=new EntityOrderForm();
            entityOrderFormMenu.setItemType(EntityOrderForm.TYPE_THREE);
            entityOrderFormMenu.setProname(entitExhibitions.get(i).getProname());
            entityOrderFormMenu.setImgurl(entitExhibitions.get(i).getImgurl());
            entityOrderFormMenu.setNum(entitExhibitions.get(i).getNum());
            mEntityOrderForms.add(entityOrderFormMenu);
        }

        //积分
        EntityOrderForm entityOrderFormcoupon=new EntityOrderForm();
        entityOrderFormcoupon.setItemType(EntityOrderForm.TYPE_FOUR);
        mEntityOrderForms.add(entityOrderFormcoupon);

        //支付
        EntityOrderForm entityOrderFormRemarks=new EntityOrderForm();
        entityOrderFormRemarks.setItemType(EntityOrderForm.TYPE_FIVE);
        mEntityOrderForms.add(entityOrderFormRemarks);

        mAdaptePayment.setNewData(mEntityOrderForms);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
