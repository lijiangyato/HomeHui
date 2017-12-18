package com.ings.gogo.homehuiui.homehuiindex.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:注册登录
*/

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.index.entity.EntityIndex;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;
import com.ings.gogo.homehuihttp.constant.Constant;
import com.ings.gogo.homehuitools.IToolsView;
import com.ings.gogo.homehuitools.impl.ToolsDecoration;
import com.ings.gogo.homehuitools.impl.ToolsLoadingDialog;
import com.ings.gogo.homehuitools.impl.ToolsLooperManage;
import com.ings.gogo.homehuitools.impl.ToolsMD5;
import com.ings.gogo.homehuitools.impl.ToolsRegularly;
import com.ings.gogo.homehuitools.impl.ToolsView;
import com.ings.gogo.homehuiui.homehuibase.BaseFragment;
import com.ings.gogo.homehuiui.homehuiindex.Entity.EntityIndexAdd;
import com.ings.gogo.homehuiui.homehuiindex.adapter.AdapterIndex;
import com.ings.gogo.homehuiui.homehuiindex.presenter.IPresenterIndex;
import com.ings.gogo.homehuiui.homehuiindex.presenter.impl.PresenterIndex;
import com.ings.gogo.homehuiui.homehuiindex.view.IIndexFragmentView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.os.Looper.getMainLooper;

@Route(path = "/index/activity/IndexFragmentView", name = "登录注册:个人中心")
public class IndexFragmentView extends BaseFragment implements IIndexFragmentView {
    @BindView(R.id.imageView_head_portrait)
    CircleImageView imageViewHeadPortrait;
    @BindView(R.id.name_account_id)
    AutoCompleteTextView nameAccountId;
    @BindView(R.id.name_password_id)
    EditText namePasswordId;
    @BindView(R.id.name_login_id)
    Button nameLoginId;
    @BindView(R.id.name_message_id)
    Button nameMessageId;
    @BindView(R.id.name_forget_id)
    Button nameForgetId;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.name_register_id)
    TextView nameRegisterId;
    @BindView(R.id.name_recyclergrzx_id)
    RecyclerView nameRecyclergrzxId;
    @BindView(R.id.name_head_id)
    LinearLayout nameHeadId;
    @BindView(R.id.name_zhucei_id)
    LinearLayout nameZhuceiId;
    @BindView(R.id.Layout_laoli3)
    LinearLayout LayoutLaoli3;


    //加载动画
    private ToolsLoadingDialog mToolsLoadingDialog;
    //数据控制层
    private IPresenterIndex mIPresenterIndex;
    //数据分析工具
    private IToolsView iToolsView;

    public AdapterIndex mAdapterIndex;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_index_view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        mIPresenterIndex = new PresenterIndex(this);
        iToolsView = new ToolsView(getContext());
    }

    @Override
    public void initData() {

        if (false){
            display();
        }
        else {
           displayg();
        }
        iniview();
        mIPresenterIndex.setIndexPersonalPresenter();



    }
    /*@显示*/
    public void display() {
        //个人中心例表
        nameRecyclergrzxId.setVisibility(View.VISIBLE);
    }
    /*@显示*/
    public void displayg() {
        //
        nameHeadId.setVisibility(View.VISIBLE);
        //
        emailLoginForm.setVisibility(View.VISIBLE);
        //注册
        nameZhuceiId.setVisibility(View.VISIBLE);

    }
    /*@隐藏*/
    public void hide(){
        nameHeadId.setVisibility(View.GONE);
        //
        emailLoginForm.setVisibility(View.GONE);
        //注册
        nameZhuceiId.setVisibility(View.GONE);
    }
    /*@初始化*/
    public void iniview() {
        nameRecyclergrzxId.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapterIndex = new AdapterIndex(getContext(), null);
        nameRecyclergrzxId.setAdapter(mAdapterIndex);
        nameRecyclergrzxId.addItemDecoration(new ToolsDecoration(getContext(), ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_E4E4E4));
        mAdapterIndex.setPersonalCenter(new AdapterIndex.PersonalCenter() {
            @Override
            public void Callbackcenter(View view, int sing) {
                 switch (sing){
                     case 1:
                         break;
                     case 2:
                         break;
                     case 3:
                         break;
                     case 4:
                         break;
                     case 5:
                         break;
                     case 6:
                         break;
                     case 7:
                         ARouter.getInstance().build("/address/activity/SaveAddressActivityView").navigation();
                         break;
                     case 8:
                         break;
                     case 9:
                         break;
                     case 10:
                         ARouter.getInstance().build("/pdate/activi/RecommendActivityVview").navigation();
                         break;

                 }
            }
        });



    }

    /*@数据提交*/
    @OnClick(R.id.name_login_id)
    public void onLogViewClicked() {
        if (isVerification()) {
            gload();
            mIPresenterIndex.setIndexPresenter(nameAccountId.getText().toString(), ToolsMD5.MD5(namePasswordId.getText().toString()));
            /*@数据测试*/
            if (Constant.DOOBA) {
                iToolsView.setToolsdataView("手机号登录" + nameAccountId.getText().toString() + "密码" + ToolsMD5.MD5(namePasswordId.getText().toString()), "登陆注册页面", "提交", null, null, null);
            }
        }
    }

    /*@注册*/
    @OnClick(R.id.name_register_id)
    public void registerClicked() {
        ARouter.getInstance().build("/index/activity/RegisterActivityView").withString("identification", "register").navigation();

    }

    /*@忘记密码*/
    @OnClick(R.id.name_forget_id)
    public void forgetPassword() {
        ARouter.getInstance().build("/index/activity/RegisterActivityView").withString("identification", "forget").navigation();

    }

    /*@短信登录*/
    @OnClick(R.id.name_message_id)
    public void smslogin() {
        ARouter.getInstance().build("/index/activity/RegisterActivityView").withString("identification", "Signin").navigation();

    }

    /*@验证信息*/
    private boolean isVerification() {
        boolean pass = true;
        if (!ToolsRegularly.isPhone(nameAccountId.getText().toString())) {
            nameAccountId.setError("请输入正确的手机号码");
            pass = false;
        } else if (namePasswordId.getText().toString().length() < 6) {
            namePasswordId.setError("密码格式错误");
            pass = false;
        }
        return pass;
    }

    @Override
    public void setIndexView(EntityIndex entityIndex) {
        if (Constant.DOOBA) {
            iToolsView.setToolsdataView("登录数据" + entityIndex.getData() +
                    "!" + entityIndex.getMsg() + "!" + entityIndex.isSuccess(), "登录注册页", "返回", null, null, null);
        }
        //ARouter.getInstance().build("/main/activity/MainActivityView").navigation();

        gdisplay();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String tring) {
        if (tring.equals("jiang")){
            hide();
            display();
        }

    }

    /*@加载显示动画*/
    public void gload() {
        ToolsLooperManage.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mToolsLoadingDialog = new ToolsLoadingDialog(getContext());
                mToolsLoadingDialog.show();
            }
        });
    }
    /*@加载关闭动画*/
    public void gdisplay() {
        new Handler(getMainLooper()).postDelayed(new TimerTask() {
            @Override
            public void run() {
                mToolsLoadingDialog.dismiss();
                EventBus.getDefault().post("jiang");
            }
        }, 3000);
    }

    @Override
    public void setIndexPersonalView() {

        List<EntityIndexAdd> mentityIndices=new ArrayList<>();
        //图标电话
        EntityIndexAdd mentitycAddress=new EntityIndexAdd();
         mentitycAddress.setItemType(EntityIndexAdd.TYPE_SIX);
        mentityIndices.add(mentitycAddress);
        //订单
        EntityIndexAdd entitycorder=new EntityIndexAdd();
        entitycorder.setItemType(EntityIndexAdd.TYPE_THREE);
        mentityIndices.add(entitycorder);

        //导航器
        EntityIndexAdd entityIndenavigater=new EntityIndexAdd();
        entityIndenavigater.setItemType(EntityIndexAdd.TYPE_ONE);
        mentityIndices.add(entityIndenavigater);

        //消息提示
        EntityIndexAdd entitymessage=new EntityIndexAdd();
        entitymessage.setItemType(EntityIndexAdd.TYPE_FOUR);
        mentityIndices.add(entitymessage);

         //定位地址管理
        EntityIndexAdd mentitycIntegral=new EntityIndexAdd();
        mentitycIntegral.setItemType(EntityIndexAdd.TYPE_SEVEN);
        mentitycIntegral.setAddress("地址管理");
        mentityIndices.add(mentitycIntegral);
        //我的积分
        EntityIndexAdd mentityin =new EntityIndexAdd();
        mentityin.setItemType(EntityIndexAdd.TYPE_EIGHT);
        mentityin.setIntegr("我的积分");
        mentityIndices.add(mentityin);

        //优惠券
        EntityIndexAdd entityCoupon=new EntityIndexAdd();
        entityCoupon.setItemType(EntityIndexAdd.TYPE_TWO);
        mentityIndices.add(entityCoupon);


        //版本更新
        EntityIndexAdd entityupdate=new EntityIndexAdd();
        entityupdate.setItemType(EntityIndexAdd.TYPE_NINE);
        entityupdate.setUpdate("更新版本");
        mentityIndices.add(entityupdate);
        //推荐好友
        EntityIndexAdd entityRecommend=new EntityIndexAdd();
        entityRecommend.setItemType(EntityIndexAdd.TYPE_TEN);
        entityRecommend.setRecommend("推荐好友");
        mentityIndices.add(entityRecommend);

        mAdapterIndex.setNewData(mentityIndices);

    }



}