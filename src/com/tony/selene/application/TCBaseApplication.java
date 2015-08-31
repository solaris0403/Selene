package com.tony.selene.application;

import android.app.Application;

import com.tony.selene.activity.TCActivityManager;

/**
 * @ClassName TCBaseApplication
 * @Description Application的父类 实现通用方法
 * @author Tony.Cao E-mail:solaris0403@gmail.com
 * @date Aug 31, 2015
 */
public class TCBaseApplication extends Application {
	
	/**
	 * 退出应用程序的时候，手动调用,结束所有的Activity
	 * @see android.app.Application#onTerminate()
	 */
	@Override
	public void onTerminate() {
		TCActivityManager.getInstance().clearAllActivity();
	}
}
