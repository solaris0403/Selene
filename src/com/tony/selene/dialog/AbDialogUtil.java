/*
 * Copyright (C) 2012 www.amsoft.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tony.selene.dialog;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;

import com.tony.selene.dialog.TCAlertDialogFragment.TCAlertDialogFragmentOnClickListener;
import com.tony.selene.dialog.TCDialogFragment.AbDialogOnLoadListener;
import com.tony.selene.util.AbViewUtil;

// TODO: Auto-generated Javadoc
/**
 * © 2012 amsoft.cn 名称：AbDialogUtil.java 描述：Dialog工具类.
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2014-07-02 下午11:52:13
 */

@SuppressLint("NewApi")
public class AbDialogUtil {

	/** dialog 标记 */
	public static String dialogTag = "dialog";

	public static int ThemeHoloLightDialog = android.R.style.Theme_Holo_Light_Dialog;

	public static int ThemeLightPanel = android.R.style.Theme_Light_Panel;

	private static int defaultStyle = ThemeHoloLightDialog;

	/**
	 * 全屏显示一个对话框.
	 * 
	 * @param view
	 * @return
	 */
	public static AbSampleDialogFragment showFullScreenDialog(View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment.newInstance(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
		newFragment.setContentView(view);
		FragmentManager fm = activity.getFragmentManager();
		android.app.FragmentTransaction ft = fm.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(fm, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个隐藏的的对话框.
	 * 
	 * @param view
	 */
	public static void showDialog(Context context, DialogFragment fragment) {
		FragmentActivity activity = (FragmentActivity) context;
		fragment.show(activity.getSupportFragmentManager(), dialogTag);
	}

	/**
	 * 显示一个自定义的对话框.
	 * 
	 * @param view
	 */
	public static AbSampleDialogFragment showDialog(View view) {
		return showDialog(view, Gravity.CENTER);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param gravity
	 *            位置
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int gravity) {
		return showDialog(view, gravity, defaultStyle);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param gravity
	 *            位置
	 * @param style
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int gravity, int style) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style, gravity);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);

		return newFragment;
	}

	/**
	 * 显示一个自定义的对话框
	 * 
	 * @param view
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, DialogInterface.OnCancelListener onCancelListener) {
		return showDialog(view, Gravity.CENTER, defaultStyle, onCancelListener);
	}

	/**
	 * 显示一个自定义的对话框
	 * 
	 * @param view
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int style, DialogInterface.OnCancelListener onCancelListener) {
		return showDialog(view, Gravity.CENTER, style, onCancelListener);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param gravity
	 *            位置
	 * @param style
	 * @param onCancelListener
	 *            　取消事件
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int gravity, int style, DialogInterface.OnCancelListener onCancelListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style, gravity);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.setOnCancelListener(onCancelListener);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter, int animExit, int animPopEnter, int animPopExit, DialogInterface.OnCancelListener onCancelListener) {
		return showDialog(view, animEnter, animExit, animPopEnter, animPopExit, Gravity.CENTER, defaultStyle, onCancelListener);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter, int animExit, int animPopEnter, int animPopExit, int style, DialogInterface.OnCancelListener onCancelListener) {
		return showDialog(view, animEnter, animExit, animPopEnter, animPopExit, Gravity.CENTER, style, onCancelListener);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @param gravity
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter, int animExit, int animPopEnter, int animPopExit, int gravity, int style, DialogInterface.OnCancelListener onCancelListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style, gravity);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		ft.setCustomAnimations(animEnter, animExit, animPopEnter, animPopExit);
		newFragment.setOnCancelListener(onCancelListener);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter, int animExit, int animPopEnter, int animPopExit) {
		return showDialog(view, animEnter, animExit, animPopEnter, animPopExit, Gravity.CENTER, defaultStyle);
	}

	/**
	 * 显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter, int animExit, int animPopEnter, int animPopExit, int style) {
		return showDialog(view, animEnter, animExit, animPopEnter, animPopExit, Gravity.CENTER, style);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框.
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @param gravity
	 *            位置
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter, int animExit, int animPopEnter, int animPopExit, int gravity, int style) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style, gravity);
		newFragment.setContentView(view);
		// 自定义转场动画
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		ft.setCustomAnimations(animEnter, animExit, animPopEnter, animPopExit);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （图标，标题，String内容）.
	 * 
	 * @param context
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static TCAlertDialogFragment showAlertDialog(Context context, int icon, String title, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(icon, title, message, null, null);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（图标，标题，string内容，确认，取消）.
	 * 
	 * @param context
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param message
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static TCAlertDialogFragment showAlertDialog(Context context, int icon, String title, String message, TCAlertDialogFragmentOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) context;
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(icon, title, message, null, onClickListener);
		FragmentManager fm = activity.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（标题，String内容，确认，取消）.
	 * 
	 * @param context
	 * @param title
	 *            对话框标题内容
	 * @param message
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static TCAlertDialogFragment showAlertDialog(Context context, String title, String message, TCAlertDialogFragmentOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) context;
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(0, title, message, null, onClickListener);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（View内容）.
	 * 
	 * @param view
	 *            对话框标题内容
	 */
	public static TCAlertDialogFragment showAlertDialog(View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(0, null, null, view, null);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（String内容）.
	 * 
	 * @param context
	 * @param title
	 *            对话框标题内容
	 */
	public static TCAlertDialogFragment showAlertDialog(Context context, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(0, null, message, null, null);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （图标，标题，View内容）.
	 * 
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static TCAlertDialogFragment showAlertDialog(int icon, String title, View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(icon, title, null, view, null);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（图标，标题，View内容，确认，取消）.
	 * 
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static TCAlertDialogFragment showAlertDialog(int icon, String title, View view, TCAlertDialogFragmentOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(icon, title, null, view, onClickListener);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （标题，View内容）.
	 * 
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static TCAlertDialogFragment showAlertDialog(String title, View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(0, title, null, view, null);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（标题，View内容，确认，取消）.
	 * 
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static TCAlertDialogFragment showAlertDialog(String title, View view, TCAlertDialogFragmentOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(0, title, null, view, onClickListener);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （标题，String内容）.
	 * 
	 * @param context
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static TCAlertDialogFragment showAlertDialog(Context context, String title, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		TCAlertDialogFragment newFragment = TCAlertDialogFragment.newInstance(0, title, message, null, null);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示进度框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 *            用默认请写0
	 * @param message
	 *            the message
	 */
	public static AbProgressDialogFragment showProgressDialog(Context context, int indeterminateDrawable, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbProgressDialogFragment newFragment = AbProgressDialogFragment.newInstance(indeterminateDrawable, message);
		FragmentManager fm = activity.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 */
	public static AbLoadDialogFragment showLoadDialog(Context context, int indeterminateDrawable, String message) {
		return showLoadDialog(context, indeterminateDrawable, message, defaultStyle);
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 */
	public static AbLoadDialogFragment showLoadDialog(Context context, int indeterminateDrawable, String message, AbDialogOnLoadListener abDialogOnLoadListener) {
		return showLoadDialog(context, indeterminateDrawable, message, defaultStyle, abDialogOnLoadListener);
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 * @param style
	 */
	public static AbLoadDialogFragment showLoadDialog(Context context, int indeterminateDrawable, String message, int style) {
		FragmentActivity activity = (FragmentActivity) context;
		AbLoadDialogFragment newFragment = AbLoadDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 * @param style
	 * @param abDialogOnRefreshListener
	 */
	public static AbLoadDialogFragment showLoadDialog(Context context, int indeterminateDrawable, String message, int style, AbDialogOnLoadListener abDialogOnLoadListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbLoadDialogFragment newFragment = AbLoadDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(abDialogOnLoadListener);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 * @param abDialogOnRefreshListener
	 */
	public static AbRefreshDialogFragment showRefreshDialog(Context context, int indeterminateDrawable, String message) {
		return showRefreshDialog(context, indeterminateDrawable, message, defaultStyle);
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 * @param indeterminateDrawable
	 * @param message
	 * @param abDialogOnRefreshListener
	 * @return
	 */
	public static AbRefreshDialogFragment showRefreshDialog(Context context, int indeterminateDrawable, String message, AbDialogOnLoadListener abDialogOnLoadListener) {
		return showRefreshDialog(context, indeterminateDrawable, message, defaultStyle, abDialogOnLoadListener);
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 * @param style
	 */
	public static AbRefreshDialogFragment showRefreshDialog(Context context, int indeterminateDrawable, String message, int style) {
		FragmentActivity activity = (FragmentActivity) context;
		AbRefreshDialogFragment newFragment = AbRefreshDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(null);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 * @param indeterminateDrawable
	 * @param message
	 * @param style
	 * @param abDialogOnRefreshListener
	 * @return
	 */
	public static AbRefreshDialogFragment showRefreshDialog(Context context, int indeterminateDrawable, String message, int style, AbDialogOnLoadListener abDialogOnLoadListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbRefreshDialogFragment newFragment = AbRefreshDialogFragment.newInstance(DialogFragment.STYLE_NO_TITLE, style);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(abDialogOnLoadListener);
		FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, dialogTag);
		return newFragment;
	}

	/**
	 * 描述：移除Fragment.
	 * 
	 * @param context
	 *            the context
	 */
	public static void removeDialog(final Context context) {
		try {
			FragmentActivity activity = (FragmentActivity) context;
			FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
			// 指定一个系统转场动画
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
			Fragment prev = activity.getFragmentManager().findFragmentByTag(dialogTag);
			if (prev != null) {
				ft.remove(prev);
			}
			ft.addToBackStack(null);
			ft.commit();
		} catch (Exception e) {
			// 可能有Activity已经被销毁的异常
			e.printStackTrace();
		}
	}

	/**
	 * 描述：移除Fragment和View
	 * 
	 * @param view
	 */
	public static void removeDialog(View view) {
		removeDialog(view.getContext());
		AbViewUtil.removeSelfFromParent(view);
	}

}
