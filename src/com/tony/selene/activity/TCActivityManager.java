package com.tony.selene.activity;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

/**
 * @ClassName TCActivityManager
 * @Description 用于处理退出程序时可以退出所有的activity，而编写的通用类
 * @author Tony.Cao E-mail:solaris0403@gmail.com
 * @date Aug 31, 2015
 */    
public class TCActivityManager {
	private List<Activity> activityList = new LinkedList<Activity>();
	private static TCActivityManager instance;
	private TCActivityManager() {
	}

	/**
	 * @Title getInstance
	 * @Description 单例模式中获取唯一的TCActivityManager实例.
	 * @return TCActivityManager
	 */
	public static TCActivityManager getInstance() {
		if (null == instance) {
			instance = new TCActivityManager();
		}
		return instance;
	}

	/**
	 * @Title addActivity
	 * @Description 添加Activity到容器中.
	 * @param activity
	 * @return void
	 */
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}
	
	/**
	 * @Title removeActivity
	 * @Description 移除Activity从容器中.
	 * @param activity
	 * @return void
	 */
	public void removeActivity(Activity activity) {
		activityList.remove(activity);
	}

	/**
	 * @Title clearAllActivity
	 * @Description 遍历所有Activity并finish.
	 * @return void
	 */
	public void clearAllActivity() {
		for (Activity activity : activityList) {
			if(activity!=null){
				activity.finish();
			}
		}
	}
}