package com.tony.selene.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Aug 20, 2015 5:44:30 PM
 */
public class TCBaseActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		getWindow().setBackgroundDrawable(null);
		TCActivityManager.getInstance().addActivity(this);
	}

	@Override
	public void finish() {
		TCActivityManager.getInstance().removeActivity(this);
		super.finish();
	}
}
