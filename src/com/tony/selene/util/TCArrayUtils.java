package com.tony.selene.util;

public class TCArrayUtils {
	private TCArrayUtils() {
		throw new AssertionError();
	}

	/**
	 * is null or its length is 0
	 * 
	 * @param <V>
	 * @param sourceArray
	 * @return
	 */
	public static <V> boolean isEmpty(V[] sourceArray) {
		return (sourceArray == null || sourceArray.length == 0);
	}
}
