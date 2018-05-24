package com.shaunz.framework.core;

/***
 * 系统初始化信息的的全局记录的静态变量信息
 * @author dengxiong90@foxmail.com
 *
 */
public final class YgdrasilConst {
	/***
	 * xss检测例外的url
	 */
	public static String XSS_EXCLUED_URL="index.do";

	/***
	 * xss检测例外有攻击的url后的跳转路径
	 */
	public static String XSS_REDIRECT_URL="index.do";
	
	public static String DATE_FORMART = "yyyy-MM-dd HH:mm";
	
	public static String CUSTOMER_IMAGE_PATH = "/staticResources/customerResources/images/";
	
}
