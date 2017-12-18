package com.ings.gogo.homehuiui.homehuifood.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:外面
*/

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.LatLng;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.db.model.IDataloadAll;
import com.ings.gogo.homehuidata.db.model.impl.Database;
import com.ings.gogo.homehuidata.db.model.impl.DataloadAll;
import com.ings.gogo.homehuidata.db.surface.SurfaceModeldb0;
import com.ings.gogo.homehuidata.food.EntityFood;
import com.ings.gogo.homehuidata.food.entity.EntityCarouselFigure;
import com.ings.gogo.homehuidata.food.entity.EntityPoints;
import com.ings.gogo.homehuihttp.constant.Constant;
import com.ings.gogo.homehuitools.IToolsView;
import com.ings.gogo.homehuitools.impl.ToolsDecoration;
import com.ings.gogo.homehuitools.impl.ToolsLoadingDialog;
import com.ings.gogo.homehuitools.impl.ToolsLooperManage;
import com.ings.gogo.homehuitools.impl.ToolsView;
import com.ings.gogo.homehuiui.homehuiaddress.entity.EntityReturn;
import com.ings.gogo.homehuiui.homehuibase.BaseFragment;
import com.ings.gogo.homehuiui.homehuifood.adapter.AdapteShare;
import com.ings.gogo.homehuiui.homehuifood.adapter.AdapterExhibition;
import com.ings.gogo.homehuiui.homehuifood.adapter.AdapterFood;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitExhibition;
import com.ings.gogo.homehuiui.homehuifood.entity.EntitShare;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityEscort;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityFoodData;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityGeography;
import com.ings.gogo.homehuiui.homehuifood.holder.HolderImage;
import com.ings.gogo.homehuiui.homehuifood.presenter.IPresenterFood;
import com.ings.gogo.homehuiui.homehuifood.presenter.impl.PresenterFood;
import com.ings.gogo.homehuiui.homehuifood.view.IFoodFragmentView;
import com.paradoxie.shopanimlibrary.AniManager;
import com.yalantis.pulltomakesoup.PullToRefreshView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import q.rorbin.badgeview.QBadgeView;

import static android.os.Looper.getMainLooper;

@Route(path = "/Food/Fragment/FoodFragmentView", name = "外买")
public class FoodFragmentView extends BaseFragment implements IFoodFragmentView, View.OnClickListener {
    @BindView(R.id.name_shuxiang_id)
    PullToRefreshView nameShuxiangId;
    @BindView(R.id.name_food_id)
    ImageView nameFoodId;
    @BindView(R.id.name_FoodRecycler_id)
    RecyclerView nameFoodRecyclerId;
    @BindView(R.id.name_Sum_id)
    TextView nameSumId;
    @BindView(R.id.name_Checkout_id)
    TextView nameCheckoutId;
    @BindView(R.id.Layout_laoli0)
    LinearLayout LayoutLaoli0;


    public RecyclerView nameCasetableId;
    public RecyclerView nameDetailedcasetableId;

    @BindView(R.id.name_placename_id)
    TextView namePlacenameId;
    @BindView(R.id.name_Location_id)
    LinearLayout nameLocationId;
    @Autowired
    double longitude;
    @Autowired
    double latitude;

    @Autowired
    String IDmap;
    @BindView(R.id.name_payment_id)
    LinearLayout namePaymentId;
    @BindView(R.id.name_shoppingCart_id)
    LinearLayout nameShoppingCartId;

    // 获取数据需要的距离参数
    public static int rangers;
    @BindView(R.id.name_bottomsheetlayot_id)
    BottomSheetLayout nameBottomsheetlayotId;
    @BindView(R.id.name_shopping_cart_layout)
    FrameLayout nameShoppingCartLayout;



    private ConvenientBanner nameConvenientId;

    private BottomSheetLayout sheetLayout;

    //数据适配器
    private AdapterFood mAdapterFood;
    //数据购物车适配器
    private AdapterExhibition mIdapterExhibition;
    //控制层接口
    private IPresenterFood miPresenterFood;
    //徽章
    private QBadgeView mQBadgeView;

    //数据分析工具
    private IToolsView iToolsView;

    private AniManager mAniManager;
    private ImageView imageView;
    private IDataloadAll iDataloadAll;
    private View bottomSheet;
    private Database database;

    //地图纬度
    private double mLatitude;
    //地图经度
    private double mLongitude;

    //网络纬度
    private double networkmLatitude;
    //网络经度
    private double networkmLongitude;

    // 定位或者位置描述获取到的经纬度信息
    private LatLng locationLatLng;

    private float distance;
    private Double dgpsy;
    // 经度
    private Double dgpsx;

    private String mPointID;
    private BottomSheetDialog mbottomSheetDialog;

    // 集合里面的初始值
    private Float min;

    private View mView;
    private View mmView;

    private AdapteShare mSetAdapter;
    private LinearLayout mlinearLayout;
    private Toolbar toolbar;


    //购物车数据
    public List<EntitExhibition> entitExhibitions = new ArrayList<>();
    public List<EntityFoodData> mlistentityfoodg = new ArrayList<>();
    private List<EntitShare> mEntitShares = new ArrayList<>();

    private List<EntityEscort> listescot = new ArrayList<>();
    private List<Float> mydistance = new ArrayList<>();
    private EntitShare entitSharedetailedcase = new EntitShare();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_food_view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        this.mContext = getContext();
        EventBus.getDefault().register(this);

        mmView = LayoutInflater.from(getContext()).inflate(R.layout.activity_share_view, (ViewGroup) getActivity().getWindow().getDecorView(), false);
        nameDetailedcasetableId = (RecyclerView) mmView.findViewById(R.id.name_detailedcasetable_id);
        mbottomSheetDialog = new BottomSheetDialog(getContext());
        mbottomSheetDialog.setContentView(mmView);
        mView = LayoutInflater.from(getContext()).inflate(R.layout.activity_popshoppong, (ViewGroup) getActivity().getWindow().getDecorView(), false);
        mlinearLayout = (LinearLayout) mView.findViewById(R.id.name_delete_id);
        mlinearLayout.setOnClickListener(this);
        nameCasetableId = (RecyclerView) mView.findViewById(R.id.name_casetable_id);

        mToolsLoadingDialog = new ToolsLoadingDialog(mContext);
        miPresenterFood = new PresenterFood(this);
        iToolsView = new ToolsView(getContext());
        mAniManager = new AniManager();//动画实例
        iDataloadAll = new DataloadAll(getContext(), Constant.TYPE_ONE);
        database = new Database(getContext(), Constant.TYPE_ONE);
        mQBadgeView = new QBadgeView(getContext());
        //陪送点的数据
        miPresenterFood.setgetPoints();
        initialdata();


    }

    //加载动画
    private ToolsLoadingDialog mToolsLoadingDialog;
    private Context mContext;
    //下拉标识
    private boolean aBoolean = true;

    @Override
    protected void initData() {

        toolbar = (Toolbar) mmView.findViewById(R.id.toolbar_share_view);
        toolbar.setTitle("详情");
        //toolbar.setSubtitle("这个视图就载ShareViewActivity里面");
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
        setHasOptionsMenu(true);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        promptbox();
    }

    public void promptbox() {
        new MaterialStyledDialog.Builder(getContext())
                .setTitle("你好请去地图上选择一个地址!")
                .setIcon(R.drawable.ic_launcher)
                .setDescription("给你看好看的哦")
                .setPositiveText("去地图选地址吧")
                .setStyle(Style.HEADER_WITH_ICON)
                .setCancelable(false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@android.support.annotation.NonNull MaterialDialog dialog, @android.support.annotation.NonNull DialogAction which) {
                        ARouter.getInstance().build("/address/activity/MapActivityView").navigation();
                    }
                })
                .show();


        gPulldown();
        inicart();
        gload();
        gdisplay();
        iniRecyclerview();
        adddata();


    }

    public void iniRecyclerview() {
        nameDetailedcasetableId.setLayoutManager(new LinearLayoutManager(getContext()));
        nameDetailedcasetableId.addItemDecoration(new ToolsDecoration(getContext(), ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_F2F2F2));
        mSetAdapter = new AdapteShare(getContext(), null);
        nameDetailedcasetableId.setAdapter(mSetAdapter);
        mSetAdapter.setmOndeviceOption(new AdapteShare.ondeviceOption() {
            @Override
            public void onviceOptionClick(int position) {

            }

            @Override
            public void onviceAniManagerClick(View view, EntitShare entitShare, int type) {

                mbottomSheetDialog.dismiss();

                startAnim(view);
                int j = entitShare.getNum();
                boolean isContains = false;
                if (type == 1) {
                    if (!entitExhibitions.isEmpty()) {
                        for (EntitExhibition exhibition : entitExhibitions) {
                            if (entitShare.getProname().equals(exhibition.getProname())) {
                                entitShare.setNum(++j);
                                exhibition.setNum(entitShare.getNum());
                                mIdapterExhibition.notifyDataSetChanged();

                                for (EntityFoodData entityFoodData : mlistentityfoodg) {
                                    if (entitShare.getProname().equals(entityFoodData.getProname())) {
                                        entityFoodData.setNum(entitShare.getNum());
                                        mAdapterFood.notifyDataSetChanged();
                                    }
                                }

                                isContains = true;
                                break;
                            } else {
                                isContains = false;
                            }
                        }
                    }

                    if (!isContains) {
                        startAnim(view);
                        entitShare.setNum(1);
                        EntitExhibition entitExhibition = new EntitExhibition();
                        entitExhibition.setProname(entitShare.getProname());
                        entitExhibition.setItemType(EntitExhibition.TYPE_ONE);
                        entitExhibition.setNum(entitShare.getNum());
                        entitExhibition.setMarkprice(entitShare.getMarkprice());
                        entitExhibitions.add(entitExhibition);
                        mIdapterExhibition.setNewData(entitExhibitions);
                        mAdapterFood.notifyDataSetChanged();
                        mIdapterExhibition.Exhibition(entitExhibitions);

                        for (EntityFoodData entityFoodData : mlistentityfoodg) {
                            if (entitShare.getProname().equals(entityFoodData.getProname())) {
                                entityFoodData.setNum(1);
                                mAdapterFood.notifyDataSetChanged();
                            }
                        }
                    }

                }
                if (type == 0) {
                    if (!entitExhibitions.isEmpty()) {
                        for (EntitExhibition exhibition : entitExhibitions) {
                            if (entitShare.getProname().equals(exhibition.getProname())) {
                                entitShare.setNum(--j);
                                exhibition.setNum(entitShare.getNum());
                                mAdapterFood.notifyDataSetChanged();
                                mIdapterExhibition.notifyDataSetChanged();

                                for (EntityFoodData entityFoodData : mlistentityfoodg) {
                                    if (entitShare.getProname().equals(entityFoodData.getProname())) {
                                        entityFoodData.setNum(entitShare.getNum());
                                        mAdapterFood.notifyDataSetChanged();
                                    }
                                }

                                break;
                            }
                        }
                    }


                }


            }
        });
    }


    public void adddata() {
        //详情标题
        //EntitShare entitSharedetailedcase=new EntitShare();
        entitSharedetailedcase.setItemType(EntitShare.TYPE_ONE);
        entitSharedetailedcase.setProname("hHH");
        //entitSharedetailedcase.setImgurl(Imgurl);
        mEntitShares.add(entitSharedetailedcase);
        // mSetAdapter.setNewData(mEntitShares);

        EntitShare entitSharedetailedhints = new EntitShare();
        entitSharedetailedhints.setItemType(EntitShare.TYPE_TWO);
        mEntitShares.add(entitSharedetailedhints);
        //mSetAdapter.setNewData(mEntitShares);

        EntitShare entitSharefood = new EntitShare();
        entitSharefood.setItemType(EntitShare.TYPE_THREE);
        mEntitShares.add(entitSharefood);
        mEntitShares.add(entitSharefood);
        mEntitShares.add(entitSharefood);
        mEntitShares.add(entitSharefood);
        mEntitShares.add(entitSharefood);
        mSetAdapter.setNewData(mEntitShares);
    }


    /* 商品详情请数据*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EntityFood messageEvent) {
        mlistentityfoodg = new ArrayList<>();
        EntityFoodData entityFood = new EntityFoodData();
        entityFood.setItemType(EntityFoodData.TYPE_ONE);
        mlistentityfoodg.add(entityFood);
        for (int i = 0; i < messageEvent.getData().size(); i++) {
            EntityFoodData mentityFoodg = new EntityFoodData();
            mentityFoodg.setItemType(EntityFoodData.TYPE_TWO);
            mentityFoodg.setTim(2);
            mentityFoodg.setProname(messageEvent.getData().get(i).getProname());
            mentityFoodg.setImgurl(messageEvent.getData().get(i).getImgurl());
            mentityFoodg.setMarkprice(messageEvent.getData().get(i).getMarkprice());
            mentityFoodg.setShortdesc(messageEvent.getData().get(i).getShortdesc());
            mlistentityfoodg.add(mentityFoodg);
        }
        //mAdapterFood.setNewData(mlistentityfoodg);
        mAdapterFood.datacong(mlistentityfoodg);
        mAdapterFood.setNewData(mlistentityfoodg);

    }

    /*@轮播图数据*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventCag(EntityCarouselFigure entityCarouselFigure) {
        Log.e("jiance", entityCarouselFigure.getData().get(1).getImgurl());

        ArrayList<String> mlocalImages = new ArrayList<>();
        for (int i = 0; i < entityCarouselFigure.getData().size(); i++) {
            mlocalImages.add(entityCarouselFigure.getData().get(i).getImgurl());
        }
        addHeadView(mlocalImages);
    }


    /*定位地图经纬度*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onbition(EntityReturn entityReturn) {
        if (entityReturn != null) {
            this.mLatitude = entityReturn.getmLatitude();
            this.mLongitude = entityReturn.getmLongitude();
        }
        getMinRanges();
        miPresenterFood.setDetailsTablePresenter(mPointID, "8792CBB4-B0CA-4276-AC5A-1F1B08562563", String.valueOf(rangers));
    }

    /*@定位地图数据*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onbitmap(EntityGeography entityGeography) {
        namePlacenameId.setText(entityGeography.getAddress());
    }

    /*配送信息*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setgetPoin(EntityPoints entityPoints) {
        if (entityPoints != null) {
            for (int i = 0; i < entityPoints.getData().size(); i++) {
                EntityEscort mEntityEscort = new EntityEscort();
                mEntityEscort.setGpsx(entityPoints.getData().get(i).getGpsx());
                mEntityEscort.setGpsy(entityPoints.getData().get(i).getGpsy());
                mEntityEscort.setPointid(entityPoints.getData().get(i).getPointid());
                mEntityEscort.setRanges(entityPoints.getData().get(i).getRanges());
                listescot.add(mEntityEscort);
            }

        }

    }


    /*@初始话勋章*/
    private void initialmedal() {
        int mNumber = 0;//数量
        int mPrice = 0;//金额
        for (int i = 0; i < entitExhibitions.size(); i++) {
            mNumber += entitExhibitions.get(i).getNum();
            mPrice += (entitExhibitions.get(i).getNum() * entitExhibitions.get(i).getMarkprice());
        }
        nameSumId.setText(String.valueOf(mPrice) + "$");
        mQBadgeView.bindTarget(nameShoppingCartLayout).setBadgeNumber(mNumber);
        mQBadgeView.setGravityOffset(1, 1, true);
        mQBadgeView.setBadgePadding(5, true);


        Log.e("GGGGGGGGGGGGGGGG", entitExhibitions.size() + "");

    }

    /*@初始话数据*/
    public void initialdata() {
        nameFoodRecyclerId.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapterFood = new AdapterFood(getContext(), null, aBoolean);
        nameFoodRecyclerId.setAdapter(mAdapterFood);
        nameFoodRecyclerId.addItemDecoration(new ToolsDecoration(getContext(), ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_F2F2F2));
        mAdapterFood.setmOndeviceInfoItem(new AdapterFood.onswitchInfoItem() {
            @Override
            public void onschemaClick(View view, EntityFoodData entityFoodData) {
               /*nameBottomsheetlayotId.showWithSheetView(mmView);
                nameBottomsheetlayotId.dismissSheet();*/


                mbottomSheetDialog.show();


                entitSharedetailedcase.setProname(entityFoodData.getProname());
                entitSharedetailedcase.setImgurl(entityFoodData.getImgurl());
                entitSharedetailedcase.setNum(entityFoodData.getNum());
                mSetAdapter.notifyDataSetChanged();



               /* KLog.e("Food", "事件成功触发");
                Bundle mbundle = new Bundle();
                mbundle.putString("proname", entityFoodData.getProname());
                mbundle.putString("Imgurl", entityFoodData.getImgurl());
                ARouter.getInstance().build("/Food/Fragment/ShareActivityView")
                        .withString("Imgurl", entityFoodData.getImgurl())
                        .withString("proname", entityFoodData.getProname()).navigation();*/
            }
        });

        mAdapterFood.setmOndeviceOption(new AdapterFood.ondeviceOption() {
            @Override
            public void onviceOptionClick(int index) {
                if (index == 0) {
                    miPresenterFood.setDetailsTablePresenter(mPointID, "8792CBB4-B0CA-4276-AC5A-1F1B08562563", "942");
                    Log.e("jjjjj", "请求成功");
                } else if (index == 1) {
                    miPresenterFood.setDetailsTablePresenter("89adaa41-3409-42ae-82ff-8fd070a7e627", "8792CBB4-B0CA-4276-AC5A-1F1B08562563", "942");
                    Log.e("kkkkkk", "请求成功");
                    ARouter.getInstance().build("/index/activity/FF").navigation();
                }


            }


            @Override
            public void onviceAniManagerClick(View view, EntityFoodData entityFoodData, int type) {
                startAnim(view);
                int j = entityFoodData.getNum();
                boolean isContains = false;
                if (type == 1) {
                    if (!entitExhibitions.isEmpty()) {
                        for (EntitExhibition exhibition : entitExhibitions) {
                            if (entityFoodData.getProname().equals(exhibition.getProname())) {
                                entityFoodData.setNum(++j);
                                exhibition.setNum(entityFoodData.getNum());
                                mIdapterExhibition.notifyDataSetChanged();


                                for (EntitShare entitShare : mEntitShares) {
                                    if (entityFoodData.getProname().equals(entitShare.getProname())) {
                                        entitShare.setNum(entityFoodData.getNum());
                                        mSetAdapter.notifyDataSetChanged();
                                    }
                                }
                                isContains = true;
                                break;
                            } else {
                                isContains = false;
                            }
                        }
                    }

                    if (!isContains) {
                        startAnim(view);
                        entityFoodData.setNum(1);
                        EntitExhibition entitExhibition = new EntitExhibition();
                        entitExhibition.setProname(entityFoodData.getProname());
                        entitExhibition.setItemType(EntitExhibition.TYPE_ONE);
                        entitExhibition.setNum(entityFoodData.getNum());
                        entitExhibition.setMarkprice(entityFoodData.getMarkprice());
                        entitExhibition.setImgurl(entityFoodData.getImgurl());
                        entitExhibitions.add(entitExhibition);
                        mIdapterExhibition.setNewData(entitExhibitions);
                        mIdapterExhibition.Exhibition(entitExhibitions);


                    }

                }

                if (type == 0) {
                    if (!entitExhibitions.isEmpty()) {
                        for (EntitExhibition exhibition : entitExhibitions) {
                            if (entityFoodData.getProname().equals(exhibition.getProname())) {
                                entityFoodData.setNum(--j);
                                exhibition.setNum(entityFoodData.getNum());
                                mAdapterFood.notifyDataSetChanged();
                                mIdapterExhibition.notifyDataSetChanged();
                                break;
                            }
                        }
                    }


                }


            }


        });
    }


    /*@初始话购物车控件*/
    public void inicart() {
        nameCasetableId.setLayoutManager(new LinearLayoutManager(getContext()));
        mIdapterExhibition = new AdapterExhibition(null);
        mIdapterExhibition.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        nameCasetableId.addItemDecoration(new ToolsDecoration(getContext(), ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_F2F2F2));
        nameCasetableId.setAdapter(mIdapterExhibition);
        mIdapterExhibition.setOnCholderExhibition(new AdapterExhibition.ondeviceOption() {
            @Override
            public void onviceAniManagerClick(View view, EntitExhibition entitExhibition, int type, int i) {
                int j = entitExhibition.getNum();
                if (type == 1) {
                    entitExhibition.setNum(++j);
                    for (EntityFoodData entitydata : mlistentityfoodg) {
                        if (entitExhibition.getProname().equals(entitydata.getProname())) {
                            entitydata.setNum(entitExhibition.getNum());
                            mAdapterFood.notifyDataSetChanged();
                            mIdapterExhibition.notifyDataSetChanged();
                        }
                    }

                } else if (type == 0) {
                    entitExhibition.setNum(--j);
                    for (EntityFoodData entitydata : mlistentityfoodg) {
                        if (entitExhibition.getProname().equals(entitydata.getProname())) {
                            entitydata.setNum(entitExhibition.getNum());
                            mAdapterFood.notifyDataSetChanged();
                            mIdapterExhibition.notifyDataSetChanged();
                        }
                    }
                }
                initialmedal();
            }
        });


    }

    /*@添加轮播图*/
    private void addHeadView(List<String> list) {
        if (aBoolean == true) {
            View headView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_food_carousel, (ViewGroup) nameFoodRecyclerId.getParent(), false);
            nameConvenientId = (ConvenientBanner) headView.findViewById(R.id.name_convenient_id);
            nameConvenientId.startTurning(5000);
            nameConvenientId.setPages(new CBViewHolderCreator<HolderImage>() {
                @Override
                public HolderImage createHolder() {
                    return new HolderImage();
                }
            }, list)
                    .setPageIndicator(new int[]{R.drawable.icon_unchecked, R.drawable.icon_selected})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

            mAdapterFood.addHeaderView(headView);
        } else if (aBoolean == false) {
            return;
        }

    }

    /*@网络数据*/
    @Override
    public void setDetailsTableView(final EntityFood mentityFood) {
        EventBus.getDefault().post(mentityFood);
    }

    /*@轮播图*/
    @Override
    public void setCarouselFigureView(EntityCarouselFigure entityCarouselFigure) {
        EventBus.getDefault().post(entityCarouselFigure);
    }

    /*@配送信息*/
    @Override
    public void setgetPointsView(EntityPoints entityPoints) {
        EventBus.getDefault().post(entityPoints);
    }

    /*@加载显示动画*/
    public void gload() {
        ToolsLooperManage.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mToolsLoadingDialog = new ToolsLoadingDialog(mContext);
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
                miPresenterFood.setDetailsTablePresenter(mPointID, "8792CBB4-B0CA-4276-AC5A-1F1B08562563", String.valueOf(rangers));
                miPresenterFood.setentityCarouselPresenter("1");
            }
        }, 2000);
    }

    /*@计算最近配送点*/
    public void getMinRanges() {
        int x = 0;
        locationLatLng = new LatLng(mLatitude, mLongitude);
        for (int i = 0; i < listescot.size(); i++) {
            dgpsx = Double.parseDouble(listescot.get(i).getGpsx());
            dgpsy = Double.parseDouble(listescot.get(i).getGpsy());
            LatLng mlatLng = new LatLng(dgpsy, dgpsx);

            distance = AMapUtils.calculateLineDistance(mlatLng, locationLatLng);

            mydistance.add(distance);

        }
        min = mydistance.get(0);
        for (int i = 0; i < mydistance.size(); i++) {
            if (mydistance.get(i) < min) {
                min = mydistance.get(i);
                x = i;
            }
        }

        mPointID = listescot.get(x).getPointid();
        rangers = (int) (listescot.get(x).getRanges() - min);

        mydistance.clear();
    }

    /*@下拉刷新数据*/
    public void gPulldown() {
        nameShuxiangId.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                nameShuxiangId.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        aBoolean = false;
                        miPresenterFood.setDetailsTablePresenter(mPointID, "8792CBB4-B0CA-4276-AC5A-1F1B08562563", String.valueOf(rangers));
                        //关闭下拉刷新
                        nameShuxiangId.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    /*@购物车事件*/
    @OnClick(R.id.name_shoppingCart_id)
    public void setshoppingClik() {
        //query();
        //nameCardvieId.setVisibility(View.VISIBLE);

        nameBottomsheetlayotId.showWithSheetView(mView);
        nameBottomsheetlayotId.dismissSheet();
    }

    /*@定位事件*/
    @OnClick(R.id.name_Location_id)
    public void MapPositioning() {
        ARouter.getInstance().build("/address/activity/MapActivityView").navigation();
    }



  /* // @删除事件
    @OnClick(R.id.name_delete_id)
    public void setDelete() {
        iDataloadAll.getdeleteall();
        query();
        mIdapterExhibition.notifyDataSetChanged();
        mIdapterExhibition.notifyItemRangeChanged(1, entitExhibitions.size());
        if (entitExhibitions.size()>0){

            for (int i=0;i<entitExhibitions.size();i++){
                mIdapterExhibition.notifyDataSetChanged();
                mIdapterExhibition.remove(i);
                mAdapterFood.notifyDataSetChanged();
            }
        }

    }*/


    /*@支付事件*/
    @OnClick(R.id.name_payment_id)
    public void payment() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("lijiang", (Serializable) entitExhibitions);

        //ARouter.getInstance().build("/Food/Fragment/PaymentActivityView").withBundle(bundle).navigation();
        // KLog.a("JJJJJJJJ","JIGJJUI");

        Intent intent = new Intent(getContext(), PaymentActivityView.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    /*@启动动画*/
    public void startAnim(View view) {
        int[] end_location = new int[2];
        int[] start_location = new int[2];
        view.getLocationInWindow(start_location);
        nameFoodId.getLocationInWindow(end_location);
        imageView = new ImageView(mContext);// buyImg是动画的图片
        imageView.setImageResource(R.drawable.sign);// 设置buyImg的图片
        //mAniManager.setTime(5500);//自定义时间
        mAniManager.setAnim(getActivity(), imageView, start_location, end_location);
        mAniManager.setOnAnimListener(new AniManager.AnimListener() {
            @Override
            public void setAnimBegin(AniManager aniManager) {
                initialmedal();
            }

            @Override
            public void setAnimEnd(AniManager aniManager) {

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mbottomSheetDialog.dismiss();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
        // nameConvenientId.stopTurning();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        nameConvenientId.stopTurning();
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.name_delete_id:
                entitExhibitions.clear();
                break;
        }
    }


}
