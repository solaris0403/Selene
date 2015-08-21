package com.tony.selene.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.Toast;

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
	
//	 public static int getRunningAppProcesses(Context context) {// 得到当前系统内运行的app进程数量
//	        ActivityManager am = (ActivityManager) context
//	                .getSystemService(Context.ACTIVITY_SERVICE);
//	        List<Runningappprocessinfo> appInfos = am.getRunningAppProcesses();
//	        return appInfos.size();
//	    }
//	 
//	    public static List<hashmap<string, object="">> getAppInfo(Context context) {// 得到非系统应用的app信息
//	        List<hashmap<string, object="">> appInfos = new ArrayList<hashmap<string, object="">>();
//	        HashMap<string, object=""> map = null;
//	        List<packageinfo> packages = context.getPackageManager()
//	                .getInstalledPackages(0);// 参数传入0表示过滤权限，因为可能有的手机不让你获取应用信息
//	        for (PackageInfo temp : packages) {
//	            if ((temp.applicationInfo.flags & temp.applicationInfo.FLAG_SYSTEM) == 0) {
//	                // 非系统应用
//	                // 得到应用的名称
//	                String appName = temp.applicationInfo.loadLabel(
//	                        context.getPackageManager()).toString();
//	                // 得到应用图标
//	                Drawable appIcon = temp.applicationInfo.loadIcon(context
//	                        .getPackageManager());
//	                // 得到应用最后一次更新的时间
//	                long lastUpdateTime = temp.lastUpdateTime;
//	                // 得到应用的包名
//	                String packageName = temp.packageName;
//	                // 得到应用的版本信息
//	                String versionName = temp.versionName;
//	                map = new HashMap<string, object="">();
//	                map.put(appName, appName);
//	                map.put(appIcon, appIcon);
//	                map.put(lastUpdateTime, lastUpdateTime);
//	                map.put(packageName, packageName);
//	                map.put(versionName, versionName);
//	                appInfos.add(map);// 把应用信息加入集合中返回
//	                map = null;
//	            } else {
//	                // 系统应用
//	            }
//	        }
//	        return appInfos;
//	    }
	 
	    // 获取sd卡容量
//	    public static String getSdSize(Context context) {
//	        String totalStr = null, availStr = null;
//	        if (Environment.getExternalStorageState().equals(
//	                Environment.MEDIA_MOUNTED)) {// 判断是否检测到sd卡
//	            File path = Environment.getExternalStorageDirectory();
//	            StatFs stat = new StatFs(path.getPath());
//	 
//	            long blockSize = stat.getBlockSizeLong();
//	            long availableBlocks = stat.getAvailableBlocksLong();
//	            long totalBlocks = stat.getBlockCountLong();
//	 
//	            long totalSize = blockSize * totalBlocks;
//	            long availSize = blockSize * availableBlocks;
//	 
//	            totalStr = Formatter.formatFileSize(context, totalSize);
//	            availStr = Formatter.formatFileSize(context, availSize);
//	 
//	        } else
//	            Toast.makeText(context, "没有检测到SD卡，请检查是否正确插入", Toast.LENGTH_SHORT).show();
//	        return "SD卡总容量为: "+ totalStr + "可用为:" + availStr;
//	    }
//	 
//	    // 获取手机内存
//	    public static String getRomSave(Context context) {
//	        String totalStr = null, availStr = null;
//	        File path = Environment.getDataDirectory();
//	        StatFs stat = new StatFs(path.getPath());// 得到手机内存的路径
//	 
//	        long blockSize = stat.getBlockSizeLong();
//	        long availableBlocks = stat.getAvailableBlocksLong();
//	        long totalBlocks = stat.getBlockCountLong();
//	 
//	        long totalSize = blockSize * totalBlocks;
//	        long availSize = blockSize * availableBlocks;
//	 
//	        totalStr = Formatter.formatFileSize(context, totalSize);
//	        availStr = Formatter.formatFileSize(context, availSize);
//	         
//	        return "手机内存总大小为:" + totalStr + "可用空间为:" + availStr;
//	    }
}
