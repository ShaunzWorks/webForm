package com.shaunz.framework.common.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	public static JSONObject toJsonObj(Object object){
		return JSONObject.parseObject(object.toString());
	}
}
