package com.qm.maplib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.AMapGestureListener;


public class MapActivity extends AppCompatActivity implements AMapLocationListener {

    private static final String TAG = "MapActivity——maplib";
    private MapView mapView;
    private AMap map;
    private AMapLocationClient locationClient;
    private AMapLocationClientOption option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mapView = (MapView) findViewById(R.id.mv_maplib);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        map = mapView.getMap();
        initLocation();

    }


    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();

    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
////        Toast.makeText(this, aMapLocation.toStr(), Toast.LENGTH_SHORT).show();
//        String address = aMapLocation.getAddress();
//        String city = aMapLocation.getCity();
        Log.e(TAG, "onLocationChanged: " + aMapLocation.toStr());
    }

    private void initLocation() {

        if (locationClient == null) {
            locationClient = new AMapLocationClient(this);
        }
        if (option == null) {
            option = new AMapLocationClientOption();
            option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        }

        locationClient.setLocationListener(this);
        locationClient.setLocationOption(option);
        locationClient.startLocation();

    }
}
