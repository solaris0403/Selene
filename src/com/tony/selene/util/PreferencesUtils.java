package com.tony.selene.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharedPreferences工具包<br>
 * 
 * @author Tony E-mail:solaris0403@gmail.com
 * @version 1.0
 * @time 2015-09-22 08:40:31
 */
public class PreferencesUtils {
	public static String PREFERENCE_NAME = "share_name";

	/**
	 * Put string preferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putString(Context context, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString(key, value);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * Get string preferences
	 * 
	 * @param context
	 * @param key
	 * @return The preference value if it exists, or null. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a string
	 * @see #getString(Context, String, String)
	 */
	public static String getString(Context context, String key) {
		return getString(context, key, null);
	}

	/**
	 * Get string preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 * @return The preference value if it exists, or null. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a string
	 */
	public static String getString(Context context, String key, String defaultValue) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getString(key, defaultValue);
	}

	/**
	 * Put int preferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putInt(Context context, String key, int value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putInt(key, value);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * Get int preferences
	 * 
	 * @param context
	 * @param key
	 * @return The preference value if it exists, or -1. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a int
	 * @see #getInt(Context, String, int)
	 */
	public static int getInt(Context context, String key) {
		return getInt(context, key, -1);
	}

	/**
	 * Get int preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            Value to return if this preference does not exist
	 * @return The preference value if it exists, or defValue. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a int
	 */
	public static int getInt(Context context, String key, int defaultValue) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getInt(key, defaultValue);
	}

	/**
	 * Put long preferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return True if the new values were successfully written to persistent
	 *         storage.
	 */
	public static void putLong(Context context, String key, long value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putLong(key, value);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * Get long preferences
	 * 
	 * @param context
	 * @param key
	 * @return The preference value if it exists, or -1. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a long
	 * @see #getLong(Context, String, long)
	 */
	public static long getLong(Context context, String key) {
		return getLong(context, key, -1);
	}

	/**
	 * Get long preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            Value to return if this preference does not exist
	 * @return The preference value if it exists, or defValue. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a long
	 */
	public static long getLong(Context context, String key, long defaultValue) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getLong(key, defaultValue);
	}

	/**
	 * Put float preferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 *            The new value for the preference
	 */
	public static void putFloat(Context context, String key, float value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putFloat(key, value);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * Get float preferences
	 * 
	 * @param context
	 * @param key
	 * @return The preference value if it exists, or -1. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a float
	 * @see #getFloat(Context, String, float)
	 */
	public static float getFloat(Context context, String key) {
		return getFloat(context, key, -1);
	}

	/**
	 * Get float preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            Value to return if this preference does not exist
	 * @return The preference value if it exists, or defValue. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a float
	 */
	public static float getFloat(Context context, String key, float defaultValue) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getFloat(key, defaultValue);
	}

	/**
	 * Put boolean preferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 *            The new value for the preference
	 */
	public static void putBoolean(Context context, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * Get boolean preferences, default is false
	 * 
	 * @param context
	 * @param key
	 * @return The preference value if it exists, or false. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a boolean
	 */
	public static boolean getBoolean(Context context, String key) {
		return getBoolean(context, key, false);
	}

	/**
	 * Get boolean preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            Value to return if this preference does not exist
	 */
	public static boolean getBoolean(Context context, String key, boolean defaultValue) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getBoolean(key, defaultValue);
	}

	/**
	 * Remove the value what follow the key<br>
	 *
	 * @param context
	 * @param key
	 */
	public static void remove(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.remove(key);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * Clear all data <br>
	 * 
	 * @param context
	 */
	public static void clear(Context context) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.clear();
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * whether a key already exists
	 *
	 * @param context
	 * @param key
	 * @return
	 */
	public static boolean contains(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.contains(key);
	}

	/**
	 * Return all content
	 *
	 * @param context
	 * @return all data that has save
	 */
	public static Map<String, ?> getAll(Context context) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getAll();
	}

	/**
	 * 解决SharedPreferencesCompat.apply方法的一个兼容类
	 */
	private static class SharedPreferencesCompat {
		private static final Method sApplyMethod = findApplyMethod();

		private static Method findApplyMethod() {
			try {
				Class<Editor> clazz = SharedPreferences.Editor.class;
				return clazz.getMethod("apply");
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			return null;
		}

		public static void apply(SharedPreferences.Editor editor) {
			try {
				if (sApplyMethod != null) {
					sApplyMethod.invoke(editor);
					return;
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			editor.commit();
		}
	}
}
