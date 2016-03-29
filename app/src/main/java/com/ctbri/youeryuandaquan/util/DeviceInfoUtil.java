package com.ctbri.youeryuandaquan.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

/**
 * Created by Luke on 2016/3/29 0029.
 */
public class DeviceInfoUtil {
    /**
     * 获取渠道号码
     *
     * @param context
     * @return
     */
    public static String getChannelValue(Context context) {
        String result = "";
        ApplicationInfo appInfo;
        try {
            appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            result = appInfo.metaData.getString("UMENG_CHANNEL");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取应用版本号（供应用市场使用的，用户不可见。通过数字大小来判断是否需要更新）
     *
     * @param context
     * @return 应用版本号
     */
    public static int getVersionCode(Context context) {
        int code = 0;
        try {
            code = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 获取应用版本名称（用户可见）
     *
     * @param context
     * @return 应用版本名称
     */
    public static String getVersionName(Context context) {
        String code = "";
        try {
            code = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 获取设备号
     *
     * @param context
     * @return 设备号
     */
    public static String getDeviceNum(Context context) {
        return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);

    }

    /**
     * 获取IMEI号
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取IP地址
     *
     * @return
     */
    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("SocketException", ex.toString());
        }
        return null;
    }
}
