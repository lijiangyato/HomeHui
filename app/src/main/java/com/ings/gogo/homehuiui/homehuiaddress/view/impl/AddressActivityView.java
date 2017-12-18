package com.ings.gogo.homehuiui.homehuiaddress.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.db.model.impl.Database;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb1;
import com.ings.gogo.homehuihttp.constant.Constant;
import com.ings.gogo.homehuitools.impl.ToolsRegularly;
import com.ings.gogo.homehuiui.homehuiaddress.entity.EntityReturn;
import com.ings.gogo.homehuiui.homehuiaddress.view.IAddressActivityView;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityGeography;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/index/activity/AddressActivityView", name = "填写地址页")
public class AddressActivityView extends BaseActivity implements IAddressActivityView {

    @BindView(R.id.name_toolbar_id)
    Toolbar nameToolbarId;
    @BindView(R.id.name_surname_id)
    EditText nameSurnameId;
    @BindView(R.id.name_Man_id)
    RadioButton nameManId;
    @BindView(R.id.name_female_id)
    RadioButton nameFemaleId;
    @BindView(R.id.unlogin_label_view)
    RadioGroup unloginLabelView;
    @BindView(R.id.name_number_id)
    EditText nameNumberId;
    @BindView(R.id.name_adddizi)
    TextView nameAdddizi;
    @BindView(R.id.name_Icon_id)
    ImageView nameIconId;
    @BindView(R.id.name_click_id)
    TextView nameClickId;
    @BindView(R.id.name_Returndianj_id)
    ImageView nameReturndianjId;
    @BindView(R.id.name_mapview_id)
    EditText nameMapviewId;
    @BindView(R.id.name_Return_id)
    ImageView nameReturnId;
    @BindView(R.id.name_login_id)
    Button nameLoginId;
    @BindView(R.id.name_Mailist_id)
    ImageView nameMailistId;
    private String Gender;
    private Database database;
    public SurfaceModeldb1 surfaceModeldb1;
    private double mLatitude;
    //经度
    private double mLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_view);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);


    }

    @Override
    public void initView() {

        nameToolbarId.setTitle("填写收货地址");
        setSupportActionBar(nameToolbarId);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void initData() {


    }

    /*购物车数据*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onbition(EntityGeography entityGeography) {
        nameClickId.setText(entityGeography.getAddress() + entityGeography.getContent());
        this.mLatitude=entityGeography.getmLatitude();
        this.mLongitude=entityGeography.getmLongitude();

    }

    /*@保存事件*/
    @OnClick(R.id.name_login_id)
    public void baochun() {
        if (isVerification()) {
            database = new Database(this, Constant.TYPE_TWO);
            surfaceModeldb1=new SurfaceModeldb1();
            surfaceModeldb1.setPullname(nameSurnameId.getText().toString());
            surfaceModeldb1.setPender(Gender);
            surfaceModeldb1.setNumber(nameNumberId.getText().toString());
            surfaceModeldb1.setDetailedaddress(nameClickId.getText().toString());
            surfaceModeldb1.setRemarks(nameMapviewId.getText().toString());
            database.inceradd(surfaceModeldb1);
            finish();
        }

    }

    /*@点击选事件*/
    @OnClick(R.id.name_click_id)
    public void click() {
        ARouter.getInstance().build("/address/activity/MapActivityView").navigation();

    }

    /*@男士事件*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.name_Man_id)
    public void Man() {
        Gender = "男士";
        nameManId.setBackground(getDrawable(R.drawable.address_backeoptc));
        nameFemaleId.setBackground(getDrawable(R.drawable.female_backeip));
    }

    /*@女士事件*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.name_female_id)
    public void female() {
        Gender = "女士";
        nameFemaleId.setBackground(getDrawable(R.drawable.address_backeoptc));
        nameManId.setBackground(getDrawable(R.drawable.female_backeip));
    }
    /*@通讯录事件*/
    @OnClick(R.id.name_Mailist_id)
    public void mailist(){

    }

    /*@验证手机号*/
    private boolean isVerification() {
        boolean pass = true;

        if (TextUtils.isEmpty(nameSurnameId.getText())) {
            nameSurnameId.setError("姓名为空");
            pass = false;
        }
        if (Gender == null) {
            Toast.makeText(this, "性别未选", Toast.LENGTH_LONG).show();
            pass = false;
        } else if (!ToolsRegularly.isPhone(nameNumberId.getText().toString())) {
            nameNumberId.setError("请输手机号码有误或为空");
            pass = false;
        } else if (TextUtils.isEmpty(nameClickId.getText())) {
            pass = false;
            nameClickId.setError("地址为空");
        }

        return pass;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
