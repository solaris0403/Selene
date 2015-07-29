package com.tony.selene.util;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Jul 20, 2015 8:46:04 AM
 */
public class ArrayUtils {
	/**
	 * Is null or its length is 0
	 * 
	 * @param sourceArray
	 * @param <V>
	 * @return return true if its null or length 0, other false
	 */
	public static <V> boolean isEmpty(V[] sourceArray) {
		return (sourceArray == null || sourceArray.length == 0);
	}
}
