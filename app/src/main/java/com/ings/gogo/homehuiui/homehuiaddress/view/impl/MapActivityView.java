package com.ings.gogo.homehuiui.homehuiaddress.view.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:定位地图
*/

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.ings.gogo.R;
import com.ings.gogo.homehuidata.index.entity.EntitycReset;
import com.ings.gogo.homehuitools.impl.ToolsDecoration;
import com.ings.gogo.homehuiui.homehuiaddress.adapter.AdapterLocation;
import com.ings.gogo.homehuiui.homehuiaddress.adapter.AdapterMap;
import com.ings.gogo.homehuiui.homehuiaddress.entity.EntityReturn;
import com.ings.gogo.homehuiui.homehuiaddress.view.IMapActivityView;
import com.ings.gogo.homehuiui.homehuibase.BaseActivity;
import com.ings.gogo.homehuiui.homehuifood.entity.EntityGeography;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = "/address/activity/MapActivityView", name = "地图")

public class MapActivityView extends BaseActivity implements
        IMapActivityView, LocationSource, AMapLocationListener,
        AMap.OnMarkerClickListener, AMap.InfoWindowAdapter,
        TextWatcher, PoiSearch.OnPoiSearchListener, Inputtips.InputtipsListener,
        GeocodeSearch.OnGeocodeSearchListener {
    //显示地图
    @BindView(R.id.name_mapview_id)
    MapView nameMapviewId;
    //关键字搜索
    @BindView(R.id.name_search_id)
    AutoCompleteTextView nameSearchId;
    // //地图例表数据
    @BindView(R.id.name_mapactivview_id_id)
    RecyclerView nameMapactivviewIdId;
    @BindView(R.id.name_toolbar_id)
    Toolbar nameToolbarId;
    @BindView(R.id.name_location_id)
    ImageView nameLocationId;
    //AMap地图对象
    private AMap mAMap;
    //地位定位发起端
    private AMapLocationClient mLocationClient = null;
    //定位定位参数
    private AMapLocationClientOption mApLocationClientOption = null;
    // 声明mListener对象，定位监听器
    private OnLocationChangedListener mListener = null;
    //pio关键字
    private String mkeyWord = null;
    //返回结果
    private PoiResult mResult = null;
    //poi查询条件
    private PoiSearch.Query mQuery = null;
    //poi搜索
    private PoiSearch mPoiSearch = null;
    //纬度
    private double mLatitude;
    //经度
    private double mLongitude;


    //纬度
    private double mLatitudejing;
    //经度
    private double mLongitudewei;

    //移动的纬度
    private double mLatitudeMove;
    //移动的经度
    private double mLongitudeMove;
    //定义一个UiSettings对象
    private UiSettings mUiSettings;
    //数据适配器
    private AdapterMap mAdapterMap;
    // 标识，用于判断是否只显示一次定位信息和用户重新定位
    private boolean isFirstLoc = true;
    //地理编码返回的结果
    private GeocodeAddress address;

    private Marker mlocationMarker;

    private LatLng mLocationLatLng;

    private GeocodeSearch geocoderSearch;

    private StringBuffer buffer;

    private String desc;
    private String keyWord = "";// 要输入的poi搜索关键字

    private String addressName;

    private int height;
    private MyLocationStyle myLocationStyle;

    public AMapLocation aMapLocation;

    public EntityReturn entitycReset;

    private EntityGeography entityGeography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        ButterKnife.bind(this);
        entitycReset = new EntityReturn();
        entityGeography = new EntityGeography();
        initialdata();
        nameMapviewId.onCreate(savedInstanceState);
        myLocationStyle = new MyLocationStyle();
        //创建地图
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.icon_location));
        myLocationStyle.strokeColor(this.getResources().getColor(R.color.colorPrimaryDark));
        myLocationStyle.strokeWidth(2f);// 设置圆形的边框粗细

        myLocationStyle.radiusFillColor(this.getResources().getColor(R.color.colorPrimaryDark));// 设置圆形的填充颜色

        //实例化地图控制器对象
        if (mAMap == null) {
            mAMap = nameMapviewId.getMap();
            mUiSettings = mAMap.getUiSettings();
            mUiSettings.setScaleControlsEnabled(true);// 设置地图默认的比例尺是否显示
            mAMap.setMyLocationStyle(myLocationStyle);
            mAMap.setMyLocationRotateAngle(1000);

            mAMap.setOnCameraChangeListener(monCameraChangeListener);

            mAMap.setMyLocationType(AMap.MAP_TYPE_SATELLITE);
            //设置定位监听
            mAMap.setLocationSource(this);
            // 是否显示定位按钮
            mUiSettings.setMyLocationButtonEnabled(true);
            // 显示定位层并且可以触发定位,默认是flase
            mAMap.setMyLocationEnabled(true);

        }
        nameSearchId.addTextChangedListener(this);
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        //开始定位

    }

    public void initialdata() {

        nameMapactivviewIdId.setLayoutManager(new LinearLayoutManager(this));

        nameMapactivviewIdId.addItemDecoration(new ToolsDecoration(this, ToolsDecoration.VERTICAL_LIST, ToolsDecoration.DividerType.TYPE_F2F2F2));

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
        //定位
        location();
    }

    /*@定位*/
    private void location() {
        //实例化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //实例化设置定位监听
        mLocationClient.setLocationListener(this);
        //实例化定位参数
        mApLocationClientOption = new AMapLocationClientOption();
        //设置定位模式:Hight_accuracy!高精度模式
        //Battery_Saving诋功耗模式
        //Bevice_Sensors是仅设备模式
        mApLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息(默认返回地址信息)
        mApLocationClientOption.setNeedAddress(true);
        //设置是否定位一次，默认false
        mApLocationClientOption.setOnceLocation(false);
        //设置是否强制刷新wifi,默认为强制刷新
        mApLocationClientOption.setWifiActiveScan(true);
        mApLocationClientOption.setWifiScan(true);
        //设置是否允许模拟位置,默认为False,不允许模拟位置
        mApLocationClientOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mApLocationClientOption.setInterval(1000);
        //给定位客服端设置定位参数
        mLocationClient.setLocationOption(mApLocationClientOption);
        //启动定位
        mLocationClient.startLocation();
    }

    /*@搜索*/
    private void doSearchQuery(LatLonPoint latLonPoint) {
        mQuery = new PoiSearch.Query(keyWord, "", "贵阳");
        mQuery.setPageSize(100);
        mQuery.setPageNum(1);
        //构造 PoiSearch 对象
        PoiSearch mpoiSearch = new PoiSearch(this, mQuery);
        if (mLatitudeMove != 0.0 && mLongitudeMove != 0.0) {
            // 设置周边搜索的中心点以及区域
            mpoiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(mLatitudeMove, mLongitudeMove), 2000));
            //并设置监听
            mpoiSearch.setOnPoiSearchListener(this);
            //开始搜索
            mpoiSearch.searchPOIAsyn();
        }


    }

    /*@搜索*/
    private void doSearchQuery() {
        mQuery = new PoiSearch.Query(keyWord, "", "贵阳");
        mQuery.setPageSize(100);
        mQuery.setPageNum(1);
        mPoiSearch = new PoiSearch(this, mQuery);
        mPoiSearch.setOnPoiSearchListener(this);
        if (mLatitude != 0.0 && mLongitude != 0.0) {
            mPoiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(mLatitude, mLongitude), 3000));
            mPoiSearch.setOnPoiSearchListener(this);
            mPoiSearch.searchPOIAsyn();
        }

    }


    /*@*/
    private void search(LatLonPoint latLonPoint) {
        if (aMapLocation == null) {
            onLocationChanged(aMapLocation);
            mAMap.moveCamera(CameraUpdateFactory.zoomTo(18));
            // 将地图移动到定位点

            mAMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(
                    latLonPoint.getLatitude(), latLonPoint.getLongitude())));
            // 点击定位按钮 能够将地图的中心移动到定位点
            mListener.onLocationChanged(aMapLocation);

        } else {
            // 设置缩放级别

            mAMap.moveCamera(CameraUpdateFactory.zoomTo(18));
            // 将地图移动到定位点
            mAMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(
                    latLonPoint.getLatitude(), latLonPoint.getLongitude())));
            // 点击定位按钮 能够将地图的中心移动到定位点
            mListener.onLocationChanged(aMapLocation);
        }
        mQuery = new PoiSearch.Query(keyWord, "", "贵阳");
        mQuery.setPageSize(100);// 设置每页最多返回多少条poiitem
        mQuery.setPageNum(1);// 设置查第一页
        PoiSearch poiSearch = new PoiSearch(this, mQuery);
        // 如果不为
        if (mLatitude != 0.0 && mLongitude != 0.0) {
            //设置周边搜索的中心点以及区域
            poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(mLatitude, mLongitude), 3000));
        }
        poiSearch.setOnPoiSearchListener(this);// 设置数据返回的监听器
        poiSearch.searchPOIAsyn();// 开始搜索

    }


    /*@移动定位*/
    AMap.OnCameraChangeListener monCameraChangeListener = new AMap.OnCameraChangeListener() {
        @Override
        public void onCameraChange(final CameraPosition cameraPosition) {
            if (mlocationMarker != null) {
                LatLng latLng = cameraPosition.target;
                mlocationMarker.setPosition(latLng);


            }
        }

        private Handler handler = new Handler() {
            public void handleMessage(Message msg) {

            }
        };

        @Override
        public void onCameraChangeFinish(final CameraPosition cameraPosition) {
            if (mlocationMarker != null) {
                final LatLng latLng = cameraPosition.target;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LatLonPoint point = new LatLonPoint(latLng.latitude, latLng.longitude);

                        mLatitudeMove = latLng.latitude;
                        mLongitudeMove = latLng.longitude;

                        Log.e("mLatitudeMove", mLatitudeMove + "");
                        Log.e("mLongitudeMove", mLongitudeMove + "");
                        mLocationLatLng = new LatLng(mLatitudeMove, mLongitudeMove);
                        //调用搜索
                        doSearchQuery(point);
                        RegeocodeQuery regeocodeQuery = new RegeocodeQuery(point, 1000, GeocodeSearch.AMAP);


                        RegeocodeAddress address = null;
                        try {
                            address = geocoderSearch.getFromLocation(regeocodeQuery);

                        } catch (AMapException e) {
                            e.printStackTrace();
                        }

                        if (null == address) {
                            return;
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        String subLoc = address.getDistrict();
                        //道路
                        String thf = null;
                        //道路例表
                        List<RegeocodeRoad> regeocodeRoads = address.getRoads();
                        if (regeocodeRoads != null && regeocodeRoads.size() > 0) {
                            RegeocodeRoad mregeocodeRoad = regeocodeRoads.get(0);
                            if (mregeocodeRoad != null) {
                                thf = mregeocodeRoad.getName();
                            }
                        }
                        String subthf = null;//门牌号
                        StreetNumber streetNumber = address.getStreetNumber();
                        if (streetNumber != null) {
                            subthf = streetNumber.getNumber();
                        }
                        String fn = address.getBuilding();//标志性建筑
                        if (subLoc != null) {
                            stringBuffer.append(subLoc);
                        }
                        if (thf != null) {
                            stringBuffer.append(thf);
                        }
                        if (subthf != null) {
                            stringBuffer.append(subthf);
                        }
                        if ((thf == null && subthf == null) && fn != null && !subLoc.equals(fn)) {
                            stringBuffer.append(fn + "附近");
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                mlocationMarker.showInfoWindow();
                            }
                        });

                    }
                }).start();
            }


        }
    };

    //dip和px转换
    private static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    /*@显示*/
    private void display(LatLng latLng, String desc) {
        doSearchQuery();
        MarkerOptions markerOptions = new MarkerOptions();
        mlocationMarker = mAMap.addMarker(new MarkerOptions()
                .anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_location)));

    }


    @Override
    protected void onPause() {
        super.onPause();
        //暂停地图绘制
        nameMapviewId.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //重新绘制加载地图
        nameMapviewId.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁地图
        nameMapviewId.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存地图
        nameMapviewId.onSaveInstanceState(outState);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    /*@输入内容自动提示*/
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String newText = s.toString();
        InputtipsQuery inputquery = new InputtipsQuery(newText, "贵阳");
        inputquery.setCityLimit(true);//限制在当前城市
        Inputtips inputTips = new Inputtips(MapActivityView.this, inputquery);
        inputTips.setInputtipsListener(this);
        inputTips.requestInputtipsAsyn();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            //定位成功回掉信息
            if (aMapLocation.getErrorCode() == 0) {
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                mLatitude = aMapLocation.getLatitude();//获取纬度
                mLongitude = aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry();//国家信息
                aMapLocation.getProvince();//省信息
                aMapLocation.getCity();//城市信息
                aMapLocation.getDistrict();//城区信息
                aMapLocation.getStreet();//街道信息
                aMapLocation.getStreetNum();//街道门牌号信息
                aMapLocation.getCityCode();//城市编码
                aMapLocation.getAdCode();//地区编码
                aMapLocation.getAoiName();//获取当前定位点的AOI信息
                aMapLocation.getBuildingId();//获取当前室内定位的建筑物Id
                aMapLocation.getFloor();//获取当前室内定位的楼层


                // 如果不设置标志位，此时再拖动地图时，它会不断将地图移动到当前的位置
                if (isFirstLoc) {
                    //设置缩放级别

                    mAMap.moveCamera(CameraUpdateFactory.zoomTo(18));
                    //将地图移动到定位点
                    mAMap.moveCamera(
                            CameraUpdateFactory.changeLatLng(
                                    new LatLng(aMapLocation.getLatitude(),
                                            aMapLocation.getLongitude())));
                    // 点击定位按钮 能够将地图的中心移动到定位点
                    mListener.onLocationChanged(aMapLocation);

                    // 获取定位信息
                    buffer = new StringBuffer();
                    buffer.append(aMapLocation.getCity() + " "
                            + aMapLocation.getDistrict() + " "
                            + aMapLocation.getStreet() + " "
                            + aMapLocation.getStreetNum());

                    Bundle locBundle = aMapLocation.getExtras();
                    if (locBundle != null) {
                        String tem = locBundle.getString("desc");
                        desc = tem.replace("贵州省 贵阳市", "");
                    }

                    display(mLocationLatLng, desc);

                    mlocationMarker.showInfoWindow();
                    isFirstLoc = false;
                }

            } else {
                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                KLog.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    /*@接活定位*/
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {

    }

    /*@将经纬度转化为地址值，需传递经纬度*/
    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

    }

    /*@根据地址转化为经纬度信息*/
    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        Log.e("mLatitude", i + "");

        if (i == 1000) {
            if (geocodeResult != null && geocodeResult.getGeocodeAddressList() != null
                    && geocodeResult.getGeocodeAddressList().size() > 0) {
                address = geocodeResult.getGeocodeAddressList().get(0);
                addressName = "经纬度值:" + address.getLatLonPoint() + "\n位置描述:" + address.getFormatAddress();

                mLatitudejing = address.getLatLonPoint().getLatitude();
                mLongitudewei = address.getLatLonPoint().getLongitude();

                entitycReset.setmLatitude(mLatitudejing);
                entitycReset.setmLongitude(mLongitudewei);

                EventBus.getDefault().post(entitycReset);
                search(address.getLatLonPoint());

            } else {

            }
        } else if (i == 27) {
            KLog.a("lijiang", "失败");
        } else if (i == 32) {
            KLog.a("lijiang", "失败");
        } else {
            KLog.a("lijiang", "失败");
        }


    }

    /*@搜索数据条目*/
    @Override
    public void onGetInputtips(final List<Tip> list, int i) {
        nameMapviewId.setVisibility(View.GONE);
        if (list != null) {
            mAdapterMap = new AdapterMap(list, this);
            nameMapactivviewIdId.setAdapter(mAdapterMap);
            mAdapterMap.setOnswitchInfoItem(new AdapterMap.onswichInfoItem() {
                @Override
                public void onHighendMapClick(View view, int position) {
                    entityGeography.setAddress(list.get(position).getName());
                    entityGeography.setContent(list.get(position).getDistrict());
                    GeocodeQuery query = new GeocodeQuery(list.get(position).getName() + list.get(position).getDistrict(), "贵阳");
                    geocoderSearch.getFromLocationNameAsyn(query);
                    EventBus.getDefault().post(entityGeography);
                    finish();
                }
            });

        } else {

        }

    }

    /*@起始数据条目*/
    @Override
    public void onPoiSearched(final PoiResult poiResult, final int i) {
        if (poiResult.getPois() != null) {
            AdapterLocation adapterLocation = new AdapterLocation(getApplicationContext(), poiResult.getPois());
            nameMapactivviewIdId.setAdapter(adapterLocation);
            adapterLocation.setOnLocationItem(new AdapterLocation.onLocationtem() {
                @Override
                public void onLocationMapClick(View view, int position) {
                    Log.e("tostring", poiResult.getPois().get(position).toString());
                    Log.e("getSnippet", poiResult.getPois().get(position).getSnippet());
                    GeocodeQuery query = new GeocodeQuery(poiResult.getPois().get(position).toString() + poiResult.getPois().get(position).getSnippet(), "贵阳");
                    geocoderSearch.getFromLocationNameAsyn(query);


                    entityGeography.setAddress(poiResult.getPois().get(position).toString());
                    entityGeography.setContent(poiResult.getPois().get(position).getSnippet());
                    EventBus.getDefault().post(entityGeography);
                    finish();
                }
            });

        } else {

        }


    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }


}
