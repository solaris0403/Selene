package com.tony.selene;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tony.selene.security.SecurityCode;

public class MainActivity extends FragmentActivity {
	private ImageView mTxtContent1;

	private TextView mTxtContent2;
	private Button mBtn1, mBtn2;
	private TextView mTxtTime1, mTxtTime2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTxtContent1 = (ImageView) findViewById(R.id.iv_content1);
		mTxtContent2 = (TextView) findViewById(R.id.tv_content2);
		mTxtTime1 = (TextView) findViewById(R.id.tv_time1);
		mTxtTime2 = (TextView) findViewById(R.id.tv_time2);
		mBtn1 = (Button) findViewById(R.id.btn_ok1);
		mBtn2 = (Button) findViewById(R.id.btn_ok2);
		mBtn1.setOnClickListener(listener);
		mBtn2.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			final String str = "ABCDEFG";
			long startTime = 0;
			switch (v.getId()) {
			case R.id.btn_ok1:
				Bitmap bm = SecurityCode.getInstance().createBitmap(200, 80, 18, MainActivity.this);
				mTxtContent1.setImageBitmap(bm);
				mTxtTime1.setText(SecurityCode.getInstance().getCode());
				break;
			case R.id.btn_ok2:
				break;
			default:
				break;
			}
		}
	};
}
