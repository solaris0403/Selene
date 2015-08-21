package com.tony.selene.activity;

import android.app.Activity;
import android.content.Intent;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Aug 20, 2015 6:12:18 PM
 */
public class TCActivityUtils {
	/**
	 * 开启新的activity
	 */
	public static void startActivity(Activity context, Class<?> clazz, boolean isFinish) {
		Intent intent = new Intent(context, clazz);
		context.startActivity(intent);
		if (isFinish) {
			context.finish();
		}
	}
}
