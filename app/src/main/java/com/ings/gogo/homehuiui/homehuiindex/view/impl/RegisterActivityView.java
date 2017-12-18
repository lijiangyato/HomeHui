package com.ings.gogo.homehuiui.homehuiindex.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:手机号码验证码
*/


import android.os.Bundle;
import android.os.CountDownTimer;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.index.entity.EntityCode;
import com.ings.gogo.homehuidata.index.entity.EntitycHeck;
import com.ings.gogo.homehuitools.IToolsView;
import com.ings.gogo.homehuitools.impl.ToolsLooperManage;
import com.ings.gogo.homehuitools.impl.ToolsRegularly;
import com.ings.gogo.homehuitools.impl.ToolsView;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterRegister;
import com.ings.gogo.homehuiui.homehuiindex.presenter.impl.PresenterRegister;
import com.ings.gogo.homehuiui.homehuiindex.view.IRegisterActivityView;


import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

@Route(path = "/index/activity/RegisterActivityView", name = "手机号码验证码")
public class RegisterActivityView extends BaseActivity implements IRegisterActivityView {

    @BindView(R.id.imageView_head_portrait)
    CircleImageView imageViewHeadPortrait;
    @BindView(R.id.name_cellphone_id)
    AutoCompleteTextView nameCellphoneId;
    @BindView(R.id.name_code_id)
    EditText nameCodeId;
    @BindView(R.id.name_Obtain_id)
    TextView nameObtainId;
    @BindView(R.id.name_nextstep_id)
    Button nameNextstepId;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    //标识
    @Autowired
    String identification;
    private String cation="register";

    private String fication="forget";

    private String tifiaction="Signin";

    //模型控制层
    private IPresenterRegister mIPresenterRegister;
    //计时器
    public TimeCount mTimeCount;
    //数据分析工具
    private IToolsView iToolsView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        iToolsView = new ToolsView(this);
    }

    /*@获取验证码*/
    @OnClick(R.id.name_Obtain_id)
    public void CodeClick() {
        submit();
    }

    /*@下一步*/
    @OnClick(R.id.name_nextstep_id)
    public void NextstepClick() {
        toverify();
    }

    /*@验证手机号是否正确*/
    private boolean isVerification() {
        boolean pass = true;
        if (!ToolsRegularly.isPhone(nameCellphoneId.getText().toString())) {
            nameCellphoneId.setError("手机格式不正确");
            pass = false;
        }
        return pass;
    }

    /*@提交验证码数据*/
    public void submit() {
        if (isVerification()) {
            mIPresenterRegister.senCodePresenter(nameCellphoneId.getText().toString(), "3");
            iToolsView.setToolsdataView("手机号" + nameCellphoneId.getText().toString() + "标识符" + "3", "验证页面", "提交", null, null, null);
        }
    }

    /*@验证数据*/
    public void toverify() {
        if (!ToolsRegularly.isVerCode(nameCodeId.getText().toString())) {
            nameCodeId.setError("验证码格式错误");
        } else {
            if (isVerification()) {
                mIPresenterRegister.setCheckPresenter(nameCellphoneId.getText().toString(), nameCodeId.getText().toString());
                iToolsView.setToolsdataView("手机号" + nameCellphoneId.getText().toString() + "验证码" + nameCodeId.getText().toString(), "验证页面", "返回", null, null, null);

            }
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        mIPresenterRegister = new PresenterRegister(this);
        mTimeCount = new TimeCount(60000, 1000);


    }

    @Override
    public void senCodeView(EntityCode entityCode) {
        mTimeCount.start();

    }


    @Override
    public void setcheckView(EntitycHeck entitycHeck) {
        iToolsView.setToolsdataView("数据" + entitycHeck.getMsg() + entitycHeck.getData() + entitycHeck.isSuccess(), "验证页面", "返回", null, null, null);


        ToolsLooperManage.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setResult(9000);

                if (identification!=null){
                    //注册页
                    if (identification.equals(cation)){
                        ARouter.getInstance().build("/index/activity/ResetActivityView")
                                .withString("Cell", nameCellphoneId.getText().toString())
                                .withString("Code", nameCodeId.getText().toString())
                                .navigation(RegisterActivityView.this, 900);
                    }
                    //重置页
                    else if (identification.equals(fication)){
                        ARouter.getInstance().build("/index/activity/PasswordActiviView")
                                .withString("Cell", nameCellphoneId.getText().toString())
                                .withString("Code", nameCodeId.getText().toString())
                                .navigation(RegisterActivityView.this, 900);
                    }
                    //短信登录
                    else if (identification.equals(tifiaction)){

                    }

                }


            }
        });

    }

    /*@定义一个倒计时的内部类*/
    private class TimeCount extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            // 参数依次为总时长,和计时的时间间隔
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(final long millisUntilFinished) {// 计时过程显示
            showCodeCodeCountdownNo(millisUntilFinished);
        }

        @Override
        public void onFinish() {// 计时完毕时触发
            showCodeCountdownYes();
        }
    }

    private void showCodeCountdownYes() {
        ToolsLooperManage.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                nameObtainId.setClickable(true);
                nameObtainId.setText("再次发送");
            }
        });
    }

    private void showCodeCodeCountdownNo(final long millisUntilFinished) {

        ToolsLooperManage.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                nameObtainId.setTextColor(getResources().getColor(R.color.color_code));
                nameObtainId.setClickable(false);
                nameObtainId.setText("再次发送(" + millisUntilFinished / 1000 + "s)");

            }
        });
    }


}
