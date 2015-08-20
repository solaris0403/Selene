package com.tony.selene.util;

import java.text.DecimalFormat;

/**
 * SizeUtils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-5-15
 */
public class SizeUtils {

    /** gb to byte **/
    public static final long GB_2_BYTE = 1073741824;
    /** mb to byte **/
    public static final long MB_2_BYTE = 1048576;
    /** kb to byte **/
    public static final long KB_2_BYTE = 1024;

    private SizeUtils() {
        throw new AssertionError();
    }
	/**
	 * 字节的大小，转成口头语
	 * @param size
	 * @return
	 */
	public static String byte2Oral(double size) {
		DecimalFormat df = new DecimalFormat("0.0");
		StringBuffer datas = new StringBuffer();
		if (size < 1048576) {
			datas.append((int) (size / 1024)).append("KB");
		} else if (size > 1048576) {
			datas.append(df.format((size / 1048576))).append("MB");
		} else if (size < 1024) {
			datas.append(size).append("B");
		}
		return datas.toString();
	}
}
