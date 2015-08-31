package com.tony.selene.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @ClassName TCBaseActivity
 * @Description 所有Activity的父类 需要继承当前类
 * @author Tony.Cao E-mail:solaris0403@gmail.com
 * @date Aug 31, 2015
 */
public abstract class TCBaseActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		int layoutId = getLayoutId();
		if (layoutId != 0) {
			setContentView(layoutId);
			//Clear default background
			getWindow().setBackgroundDrawable(null);
		}
		TCActivityManager.getInstance().addActivity(this);
		preliminary();
	}

	/**
	 * @Title getLayoutId
	 * @Description 布局文件ID
	 * @return int
	 */
	protected abstract int getLayoutId();

	/**
	 * @Title preliminary
	 * @Description 向用户展示信息前的准备工作在这个方法里处理
	 * @return void
	 */
	protected void preliminary() {
		setupViews();
		initialized();
	}

	/**
	 * @Title setupViews
	 * @Description 初始化组件
	 * @return void
	 */
	protected abstract void setupViews();

	/**
	 * @Title initialized
	 * @Description 初始化数据
	 * @return void
	 */
	protected abstract void initialized();

	/*
	 * (非 Javadoc) 带有右进右出动画的退出
	 * @see android.app.Activity#finish()
	 */
	@Override
	public void finish() {
		TCActivityManager.getInstance().removeActivity(this);
		super.finish();
		// overridePendingTransition(R.anim.push_right_in,
		// R.anim.push_right_out);
	}
}
