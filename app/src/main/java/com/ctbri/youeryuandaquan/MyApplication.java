package com.ctbri.youeryuandaquan;

import android.app.Application;

import com.ctbri.youeryuandaquan.data.LocationData;

/**
 * Created by Luke on 2016/3/29 0029.
 */
public class MyApplication extends Application {
    /** 地区信息 */
    public static LocationData locationData = new LocationData();
}
