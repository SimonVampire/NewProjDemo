package cn.sevendream.newprojdemo.net.util;

/**
 * Created by zhangxue on 2018/3/23.
 * 前端错误码统一管理，可用来定义常见错误
 * 主要的错误码维护建议放在后端建表维护
 */

public class ResCode {

	/**
	 * 成功
	 */
	public final static String SUCCESS = "000000";
	public final static String SUCCESS_MSG = "成功";
	/**
	 * 未知错误
	 */
	public static final String UNKNOWN_ERROR = "091102";
	public static final String UNKNOWN_ERROR_MSG = "未知错误";

	/**
	 * 服务返回的数据有误
	 */
	public static final String EMPTY_DATA_ERROR = "091101";
	public static final String EMPTY_DATA_ERROR_MSG = "数据有误";
}
