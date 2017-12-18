package com.ings.gogo.homehuiui.homehuiindex.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:账号注册
*/

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;
import com.ings.gogo.homehuitools.IToolsView;
import com.ings.gogo.homehuitools.impl.ToolsMD5;
import com.ings.gogo.homehuitools.impl.ToolsView;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterReset;
import com.ings.gogo.homehuiui.homehuiindex.presenter.impl.PresenterReset;
import com.ings.gogo.homehuiui.homehuiindex.view.IResetActivityView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/index/activity/ResetActivityView", name = "账号注册")
public class ResetActivityView extends BaseActivity implements IResetActivityView {

    @Autowired
    String Cell;
    @Autowired
    String Code;

    public IPresenterReset mIPresenterReset;

    @BindView(R.id.name_newpassword_id)
    EditText nameNewpasswordId;
    @BindView(R.id.name_Confirmationpassword_id)
    EditText nameConfirmationpasswordId;
    @BindView(R.id.name_register_id)
    Button nameRegisterId;
    //数据分析工具
    private IToolsView iToolsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_view);
        ButterKnife.bind(this);
        mIPresenterReset = new PresenterReset(this);
        iToolsView=new ToolsView(this);
    }


    @Override
    public void initView() {

    }

    @Override
    public void initData() {


    }

    @OnClick(R.id.name_register_id)
    public void EnrollClick() {
        mIPresenterReset.setEnrollPresenter(Cell, Code, ToolsMD5.MD5(nameNewpasswordId.getText().toString()));
        iToolsView.setToolsdataView("手机号"+Cell+"验证码"+Code+ToolsMD5.MD5(nameNewpasswordId.getText().toString()),"注册页面","提交",null,null,null);

    }

    @Override
    public void setEnrollView(EntitycReset enrollView) {
        iToolsView.setToolsdataView("数据"+enrollView.getData()+enrollView.getMsg()+enrollView.getSuccess(),"注册页面","返回",null,null,null);
    }
}
