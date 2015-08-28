package com.tony.selene.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Aug 20, 2015 5:44:30 PM
 */
public abstract class TCBaseActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		int layoutId = getLayoutId();
		if (layoutId != 0) {
			setContentView(layoutId);
			getWindow().setBackgroundDrawable(null);
		}
		TCActivityManager.getInstance().addActivity(this);
		// 向用户展示信息前的准备工作在这个方法里处理
		preliminary();
	}

	/**
	 * 布局文件ID
	 * 
	 * @return
	 */
	protected abstract int getLayoutId();

	/**
	 * 向用户展示信息前的准备工作在这个方法里处理
	 */
	protected void preliminary() {
		// 初始化组件
		setupViews();
		// 初始化数据
		initialized();
	}

	/**
	 * 初始化组件
	 */
	protected abstract void setupViews();

	/**
	 * 初始化数据
	 */
	protected abstract void initialized();

	// 带有右进右出动画的退出
	@Override
	public void finish() {
		TCActivityManager.getInstance().removeActivity(this);
		super.finish();
		// overridePendingTransition(R.anim.push_right_in,
		// R.anim.push_right_out);
	}
}
