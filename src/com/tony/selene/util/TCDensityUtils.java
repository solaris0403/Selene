﻿package com.tony.selene.util;
import android.content.Context;
import android.util.TypedValue;

//常用单位转换的辅助类
public class TCDensityUtils {
	private TCDensityUtils() {
		throw new AssertionError();
	}

	/**
	 * dpTopx
	 * 
	 * @param context
	 * @param val
	 * @return
	 */
	public static int dp2px(Context context, float dpVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * spTopx
	 * 
	 * @param context
	 * @param val
	 * @return
	 */
	public static int sp2px(Context context, float spVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * pxTodp
	 * 
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2dp(Context context, float pxVal) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxVal / scale + 0.5f);
	}

	/**
	 * pxTosp
	 * 
	 * @param fontScale
	 * @param pxVal
	 * @return
	 */
	public static float px2sp(Context context, float pxVal) {
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxVal / fontScale + 0.5f);
	}
}
