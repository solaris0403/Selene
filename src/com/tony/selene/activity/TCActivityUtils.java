package com.tony.selene.activity;

import android.app.Activity;
import android.content.Intent;

/**
 * @ClassName TCActivityUtils
 * @Description Activity工具类
 * @author Tony.Cao E-mail:solaris0403@gmail.com
 * @date Aug 31, 2015
 */
public class TCActivityUtils {
	/**
	 * @Title startActivity
	 * @Description Activity转跳
	 * @param context
	 * @param clazz
	 * @param isFinish
	 *            是否关闭当前Activity
	 * @return void
	 */
	public static void startActivity(Activity context, Class<?> clazz, boolean isFinish) {
		Intent intent = new Intent(context, clazz);
		context.startActivity(intent);
		if (isFinish)
			context.finish();
	}
}
