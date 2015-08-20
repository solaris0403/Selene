package com.tony.selene.util;

import java.io.File;

import android.os.Environment;
import android.os.StatFs;

/**
 * 内存卡 工具类<br>
 * 内部已经封装了打印功能,只需要把DEBUG参数改为true即可<br>
 * 如果需要更换tag可以直接更改,默认为KEZHUANG
 * 
 * @author KEZHUANG
 *
 */
public class SDCardUtils {

	/**
	 * 判断SDCard是否可用
	 * 
	 */
	public static boolean isSDCardEnable() {
		boolean result = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
		//if (result)
			//LogUtils.inner_i("当前内存卡有效", DEBUG);
		//else
			//LogUtils.inner_i("当前内存卡无效", DEBUG);

		return result;

	}
	/**
	 * 判断是否装有SD卡、是否可读写、是否有空间
	 * 
	 * @param size 需存入的文件大小，SD剩余空间必须大于该值
	 * @return true可用，false不可用
	 */
	public static boolean checkSDStatus(long size) {
		try {
			/* 读取SD卡大小 */
			File storage = Environment.getExternalStorageDirectory();
			StatFs stat = new StatFs(storage.getPath());
			long blocks = stat.getAvailableBlocks();
			long blocksize = stat.getBlockSize();

			/* 判断 */
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) && (blocks * blocksize) > size) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 获取SD卡路径
	 * 
	 * @return
	 */
	public static String getSDCardPath() {
		String path = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + File.separator;
		//LogUtils.inner_i("当前内存卡路径" + path, DEBUG);
		return path;
	}
	

	/**
	 * 获取SD卡的剩余容量 单位byte
	 * 
	 * @return
	 */
	public static long getSDCardAllSize()
	{
		if (isSDCardEnable())
		{
			StatFs stat = new StatFs(getSDCardPath());
			// 获取空闲的数据块的数量
			long availableBlocks = (long) stat.getAvailableBlocks() - 4;
			// 获取单个数据块的大小（byte）
			long freeBlocks = stat.getAvailableBlocks();
			return freeBlocks * availableBlocks;
		}
		return 0;
	}
	/**
	 * 获取指定路径所在空间的剩余可用容量字节数，单位byte
	 * 
	 * @param filePath
	 * @return 容量字节 SDCard可用空间，内部存储可用空间
	 */
	public static long getFreeBytes(String filePath)
	{
		// 如果是sd卡的下的路径，则获取sd卡可用容量
		if (filePath.startsWith(getSDCardPath()))
		{
			filePath = getSDCardPath();
		} else
		{// 如果是内部存储的路径，则获取内存存储的可用容量
			filePath = Environment.getDataDirectory().getAbsolutePath();
		}
		StatFs stat = new StatFs(filePath);
		long availableBlocks = (long) stat.getAvailableBlocks() - 4;
		return stat.getBlockSize() * availableBlocks;
	}
	/**
	 * 获取系统存储路径
	 * 
	 * @return
	 */
	public static String getRootDirectoryPath() {
		String path = Environment.getRootDirectory().getAbsolutePath();
		return path;
	}

}
