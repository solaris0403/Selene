package com.tony.selene.application;

import android.app.Application;

import com.tony.selene.activity.TCActivityManager;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Aug 28, 2015 9:18:19 AM
 */
public class TCBaseApplication extends Application{
    /**
     * 退出应用程序的时候，手动调用,结束所有的Activity
     */
    @Override
    public void onTerminate() {
    	TCActivityManager.getInstance().clearAllActivity();
    }
}
