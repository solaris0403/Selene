package com.tony.selene.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Aug 21, 2015 9:01:34 AM
 */
public class ActionBarTool {
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	public static void setActionBarLayout(Activity act, Context context, int layoutId) {// 前两个参数一般情况下都可以填this,第三个参数为自定义View的Id
		ActionBar actionBar = act.getActionBar();
		if (null != actionBar) {
			actionBar.setDisplayShowHomeEnabled(false);// 是否显示左上角的应用图标
			actionBar.setDisplayShowCustomEnabled(true);// 是否使用自定义标题栏
			LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = inflator.inflate(layoutId, null);// 填充自定义布局
			ActionBar.LayoutParams layout = new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			actionBar.setCustomView(v, layout);// 把自定义View设置成ActionBar
		}
	}
}
