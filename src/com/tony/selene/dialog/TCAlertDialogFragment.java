package com.tony.selene.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

/**
 * © 2012 amsoft.cn 名称：AbAlertDialogFragment.java 描述：弹出框
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2014-07-29 上午9:00:52
 */
@SuppressLint("NewApi")
public class TCAlertDialogFragment extends DialogFragment {
	private int mIcon;
	private String mTitle;
	private String mMessage;
	private static View mContentView;
	private static TCAlertDialogFragmentOnClickListener mOnClickListener;

	/**
	 * Create a new instance of AbDialogFragment.
	 */
	public static TCAlertDialogFragment newInstance(int icon, String title, String message, View view, TCAlertDialogFragmentOnClickListener onClickListener) {
		TCAlertDialogFragment alertDialogFragment = new TCAlertDialogFragment();
		mOnClickListener = onClickListener;
		mContentView = view;
		Bundle args = new Bundle();
		args.putInt("icon", icon);
		args.putString("title", title);
		args.putString("message", message);
		alertDialogFragment.setArguments(args);
		return alertDialogFragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mIcon = getArguments().getInt("icon");
		mTitle = getArguments().getString("title");
		mMessage = getArguments().getString("message");
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), AlertDialog.THEME_HOLO_LIGHT);
		if (mIcon > 0) {
			builder.setIcon(mIcon);
		}
		if (mTitle != null) {
			builder.setTitle(mTitle);
		}
		if (mMessage != null) {
			builder.setMessage(mMessage);
		}
		if (mContentView != null) {
			builder.setView(mContentView);
		}
		if (mOnClickListener != null) {
			builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					if (mOnClickListener != null) {
						mOnClickListener.onPositiveClick();
					}
				}
			});
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					if (mOnClickListener != null) {
						mOnClickListener.onNegativeClick();
					}
				}
			});
		}
		return builder.create();
	}

	/**
	 * Dialog事件的接口.
	 */
	public interface TCAlertDialogFragmentOnClickListener {
		public void onPositiveClick();
		public void onNegativeClick();
	}
}
