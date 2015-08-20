package com.tony.selene;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TCMainActivity extends TCBaseActivity {
	private Button mBtnUtils;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtnUtils = (Button) findViewById(R.id.btn_utils);
		mBtnUtils.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_utils:
				Intent intent = new Intent(TCMainActivity.this, TCUtilsActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
	};
}
