package cn.sevendream.newprojdemo.common.config;

/**
 * Created by zhangxue on 2018/3/23.
 */

public class NetConstants {

	public static final int PROD = 0;
	public static final int TEST = 1;
	public static final int DEV = 2;

	public final static int EVN = DEV;

	private static String BASE_URL_PROD = "";
	private static String BASE_URL_TEST = "";
	private static String BASE_URL_DEV = "http://server.api-mocker.com/client/";

	public static final int SUCCESS = 100;
	public static final int ERROR = 101;

	public static String getBaseUrl() {
		switch (NetConstants.EVN) {
			case NetConstants.PROD:
				return BASE_URL_PROD;
			case NetConstants.TEST:
				return BASE_URL_TEST;
			case NetConstants.DEV:
				return BASE_URL_DEV;
			default:
				return BASE_URL_PROD;
		}
	}
}
