package com.ings.gogo.homehuiui.homehuiindex.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:重置密码
*/

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.index.entity.EntityPassword;
import com.ings.gogo.homehuitools.impl.ToolsMD5;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterPassword;
import com.ings.gogo.homehuiui.homehuiindex.presenter.impl.PresenterPassword;
import com.ings.gogo.homehuiui.homehuiindex.view.IPasswordActiviView;
import butterknife.BindView;
import butterknife.OnClick;
@Route(path = "/index/activity/PasswordActiviView", name = "重置密码")

public class PasswordActiviView extends BaseActivity implements IPasswordActiviView {

    @Autowired
    String Cell;
    @Autowired
    String Code;

    @BindView(R.id.name_confirmPassword_id)
    EditText nameConfirmPasswordId;
    @BindView(R.id.name_confirmnewPassword_id)
    EditText nameConfirmnewPasswordId;
    @BindView(R.id.name_confirm_id)
    Button nameConfirmId;
    //控制层
    private IPresenterPassword mIPresenterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_view);
        mIPresenterPassword=new PresenterPassword(this);
    }

    /*@确定*/
    @OnClick(R.id.name_confirm_id)
     public void ConfirmClick(){
           itilogic();
    }


    /*@数据逻辑处理*/
    public void itilogic(){
        if (isVerification()){
            mIPresenterPassword.setPasswordPresenter(Cell,Code,ToolsMD5.MD5(nameConfirmnewPasswordId.getText().toString()));
        }
    }

    /*@验证手机密码是否正确*/
    private boolean isVerification() {
        boolean pass = true;
        if (nameConfirmPasswordId.getText().toString().length() < 6) {
            nameConfirmPasswordId.setError("密码格式错误");
            pass = false;
        } else if (nameConfirmnewPasswordId.getText().toString().length() < 6) {
            nameConfirmnewPasswordId.setError("密码格式错误");
            pass = false;
        }
        else if (!nameConfirmPasswordId.getText().toString().equals(nameConfirmnewPasswordId.getText().toString())){
            nameConfirmnewPasswordId.setError("输入的密码与第一次不相同");
            pass=false;
        }


        return pass;
    }
    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setPasswordView(EntityPassword entityPassword) {

    }
}
