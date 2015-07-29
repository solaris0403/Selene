package com.tony.selene.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Jul 20, 2015 8:48:48 AM
 */
public class PreferencesUtils {
	public static String PREFERENCE_NAME = "selene_preferences";

	/**
	 * Put string preferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return True if the new values were successfully written to persistent
	 *         storage.
	 */
	public static boolean putString(Context context, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString(key, value);
		return editor.commit();
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
	 * @return True if the new values were successfully written to persistent
	 *         storage.
	 */
	public static boolean putInt(Context context, String key, int value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putInt(key, value);
		return editor.commit();
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
	public static boolean putLong(Context context, String key, long value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putLong(key, value);
		return editor.commit();
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
	 * @return True if the new values were successfully written to persistent
	 *         storage.
	 */
	public static boolean putFloat(Context context, String key, float value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putFloat(key, value);
		return editor.commit();
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
	 * @return True if the new values were successfully written to persistent
	 *         storage.
	 */
	public static boolean putBoolean(Context context, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		return editor.commit();
	}

	/**
	 * Get boolean preferences, default is false
	 * 
	 * @param context
	 * @param key
	 * @return The preference value if it exists, or false. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a boolean
	 * @see #getBoolean(Context, String, boolean)
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
	 * @return The preference value if it exists, or defValue. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a boolean
	 */
	public static boolean getBoolean(Context context, String key, boolean defaultValue) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getBoolean(key, defaultValue);
	}

	/**
	 * Put Set preferences
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return True if the new values were successfully written to persistent
	 *         storage.
	 */
	public static boolean putStringSet(Context context, String key, Set<String> value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putStringSet(key, value);
		return editor.commit();
	}

	/**
	 * Get Set preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            Value to return if this preference does not exist
	 * @return The preference value if it exists, or defValue. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a boolean
	 */
	public static Set<String> getStringSet(Context context, String key, Set<String> defaultValue) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sp.getStringSet(key, defaultValue);
	}

	/**
	 * Get Set preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            Value to return if this preference does not exist
	 * @return The preference value if it exists, or defValue. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a boolean
	 */
	public static Set<String> getStringSet(Context context, String key) {
		return getStringSet(context, key, null);
	}

	/**
	 * Put object preferences
	 * 
	 * @param context
	 * @param key
	 * @param object
	 *            (String/Integer/Boolean/Float/Long/Set)
	 */
	public static void put(Context context, String key, Object object) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		if (object instanceof String) {
			editor.putString(key, (String) object);
		} else if (object instanceof Integer) {
			editor.putInt(key, (Integer) object);
		} else if (object instanceof Boolean) {
			editor.putBoolean(key, (Boolean) object);
		} else if (object instanceof Float) {
			editor.putFloat(key, (Float) object);
		} else if (object instanceof Long) {
			editor.putLong(key, (Long) object);
		} else if (object instanceof Set<?>) {
			editor.putStringSet(key, (Set<String>) object);
		} else {
			editor.putString(key, object.toString());
		}
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * Get object preferences
	 * 
	 * @param context
	 * @param key
	 * @return The preference value if it exists, or null. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a object
	 */
	public static Object get(Context context, String key) {
		return get(context, key, null);
	}

	/**
	 * Get Set preferences
	 * 
	 * @param context
	 * @param key
	 * @param defaultValue
	 *            Value to return if this preference does not exist
	 * @return The preference value if it exists, or defValue. Throws
	 *         ClassCastException if there is a preference with this name that
	 *         is not a object
	 */
	public static Object get(Context context, String key, Object defaultObject) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		if (defaultObject instanceof String) {
			return sp.getString(key, (String) defaultObject);
		} else if (defaultObject instanceof Integer) {
			return sp.getInt(key, (Integer) defaultObject);
		} else if (defaultObject instanceof Boolean) {
			return sp.getBoolean(key, (Boolean) defaultObject);
		} else if (defaultObject instanceof Float) {
			return sp.getFloat(key, (Float) defaultObject);
		} else if (defaultObject instanceof Long) {
			return sp.getLong(key, (Long) defaultObject);
		} else if (defaultObject instanceof Set<?>) {
			return sp.getStringSet(key, (Set<String>) defaultObject);
		}
		return null;
	}

	/**
	 * Remove the value what follow the key (Same to remove, but hasn't return
	 * value)<br>
	 * {@link #delete}
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
	 * Remove the value what follow the key (Same to remove, but has return
	 * value)<br>
	 * {@link #remove}
	 * 
	 * @param context
	 * @param key
	 * @return True if the new values were successfully remove from persistent
	 *         storage.
	 */
	public static boolean delete(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.remove(key);
		return editor.commit();
	}

	/**
	 * Clear all data (Same to wipe(), but no return)<br>
	 * {@link #wipe}
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
	 * Clear all data (Same to clear(), has return)<br>
	 * {@link #clear}</li>
	 * 
	 * @param context
	 * @return True if the values were successfully clear from persistent
	 *         storage.
	 */
	public static boolean wipe(Context context) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.clear();
		return editor.commit();
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
			}
			return null;
		}

		public static void apply(SharedPreferences.Editor editor) {
			try {
				if (sApplyMethod != null) {
					sApplyMethod.invoke(editor);
					return;
				}
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
			editor.commit();
		}
	}
}
