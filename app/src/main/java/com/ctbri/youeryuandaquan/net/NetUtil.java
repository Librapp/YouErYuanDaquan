package com.ctbri.youeryuandaquan.net;

import android.content.Context;

import com.ctbri.youeryuandaquan.util.DeviceInfoUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Luke on 2016/3/29 0029.
 */
public class NetUtil {
    public static String YXT_HOST = "http://www.youxt.cn";
    public static String YEYDQ_HOST="http://www.yeydq.com";

    public static String getAdvertisingColumn(Context context) {
        StringBuffer request = new StringBuffer(YXT_HOST);
        request.append("/rest/android/course/getAdvertisingColumn");
        request.append("?cityCode=").append(DeviceInfoUtil.getIMEI(context));
        request.append("&deviceID=").append(DeviceInfoUtil.getIMEI(context));
        request.append("&channel=").append(DeviceInfoUtil.getChannelValue(context));
        request.append("&ip=").append(DeviceInfoUtil.getLocalIpAddress());
        return request.toString();
    }

    public static String getByArea() {
        StringBuffer request = new StringBuffer(YEYDQ_HOST);
        request.append("/api/nurseryinfo/getbyarea");
        return request.toString();
    }

    /**
     * 按地区获取幼儿园
     *
     * @param level
     * @param code
     * @param character
     * @param type
     * @param orderBy
     * @param method
     * @param offset
     * @param count
     * @return
     */
    public static String getByArea(int level, String code, String character,
                                   String type, String orderBy, String method, int offset, int count) {
        JSONObject holder = new JSONObject();
        try {
            holder.put("Arealevel", level);
            holder.put("Areaid", code);
            JSONArray c = new JSONArray(character);
            holder.put("Character", c);
            holder.putOpt("Type", type);
            holder.putOpt("OrderBy", orderBy);
            holder.putOpt("Method", method);
            holder.putOpt("Offset", offset);
            holder.putOpt("Count", count);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return holder.toString();
    }
}
