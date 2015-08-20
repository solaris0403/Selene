package com.tony.selene.util;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * 获取手机信息工具类<br>
 * 内部已经封装了打印功能,只需要把DEBUG参数改为true即可<br>
 * 如果需要更换tag可以直接更改,默认为KEZHUANG
 * 
 * @author KEZHUANG
 *
 */
public class DeviceUtils {
	/**
	 * 获取应用程序的IMEI号
	 */
	public static String getIMEI(Context context) {
		TelephonyManager telecomManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String imei = telecomManager.getDeviceId();
		return imei;
	}

	/**
	 * 获取设备的系统版本号
	 */
	public static int getDeviceSDK() {
		int sdk = android.os.Build.VERSION.SDK_INT;
		return sdk;
	}

	/**
	 * 获取设备的型号
	 */
	public static String getDeviceName() {
		String model = android.os.Build.MODEL;
		return model;
	}

	/**
	 * 获取设备信息
	 * 
	 * @param context
	 * @return
	 */
	public static Map<String, String> getDeviceInfo(Context context) {
		Map<String, String> map = new HashMap<String, String>();
		android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

		String device_id = tm.getDeviceId();
		String msisdn = tm.getLine1Number(); // 手机号码
		String iccid = tm.getSimSerialNumber(); // sim卡号ICCID
		String imsi = tm.getSubscriberId(); // imsi

		android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);

		int i = wifi.getConnectionInfo().getIpAddress();
		String ip = ((i & 0xff) + "." + (i >> 8 & 0xff) + "." + (i >> 16 & 0xff) + "." + (i >> 24 & 0xff));
		String mac = wifi.getConnectionInfo().getMacAddress();

		if (TextUtils.isEmpty(device_id)) {
			device_id = mac;
		}

		if (TextUtils.isEmpty(device_id)) {
			device_id = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
		}

		map.put("ip", doNullStr(ip));
		map.put("mac", doNullStr(mac));
		map.put("device_id", doNullStr(device_id));
		map.put("msisdn", doNullStr(msisdn));
		map.put("iccid", doNullStr(iccid));
		map.put("imsi", doNullStr(imsi));

		return map;
	}

	/**
	 * 判断字符串是否有空
	 * 
	 * @param str
	 * @return
	 */
	public static String doNullStr(String str) {
		return TextUtils.isEmpty(str) ? "" : str;
	}
}
