package com.tony.selene.util;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * Asset 工具类<br>
 * 
 */
public class AssetUtils {

	/**
	 * 打开Asset下的文件
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static InputStream openAssetFile(Context context, String fileName) {
		AssetManager am = context.getAssets();
		InputStream is = null;
		try {
			is = am.open(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}
}
