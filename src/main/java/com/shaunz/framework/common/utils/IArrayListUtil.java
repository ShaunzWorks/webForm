package com.shaunz.framework.common.utils;

import java.util.List;

public class IArrayListUtil {
	
	public static boolean isBlankList(List<?> list) {
		return list == null || list.size() == 0;
	}
	
	public static boolean isBlankArray(Object[] objects) {
		return objects == null || objects.length == 0;
	}
	
}
