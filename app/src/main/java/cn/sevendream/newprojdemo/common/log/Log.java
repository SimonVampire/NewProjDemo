package cn.sevendream.newprojdemo.common.log;

import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import cn.sevendream.newprojdemo.BuildConfig;

/**
 * @ClassName: Log
 * @Description: 自定义日志（日志级别从高到低为error, warn, info, debug,
 *               verbose.），可获取文件名、行号、函数名及当前时间
 * @date 2014年12月5日 上午9:17:49
 * @author JW.Lee
 */
public final class Log {
	public static final String TAG = "PayEasy";
	private static boolean isDebug;
	static {
		if (Build.VERSION.SDK_INT < 10)
			isDebug = false;
		else
			isDebug = BuildConfig.DEBUG;// 应用正式打包签名之后，BuildConfig.DEBUG的�?会自动变为false
	}

	/**
	 * @Method_name: getFileLineMethod
	 * @Description: 当前文件名 行号 函数名
	 * @return
	 * @return_type: String
	 * @throws
	 * @author lijinwen
	 */
	public static String getFileLineMethod() {
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		StringBuffer toStringBuffer = new StringBuffer("[")
				.append(traceElement.getFileName()).append(" | ")
				.append(traceElement.getLineNumber()).append(" | ")
				.append(traceElement.getMethodName()).append("()").append("]");
		return toStringBuffer.toString();
	}

	/**
	 * @Method_name: _FILE_
	 * @Description: 当前文件名
	 * @return
	 * @return String
	 * @throws
	 * @author lijinwen
	 */
	public static String _FILE_() {
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		return traceElement.getFileName();
	}

	/**
	 * @Method_name: _FUNC_
	 * @Description: 当前方法名
	 * @return
	 * @return_type: String
	 * @throws
	 * @author lijinwen
	 */
	public static String _FUNC_() {
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		return traceElement.getMethodName();
	}

	/**
	 * @Method_name: _LINE_
	 * @Description: 当前行号
	 * @return
	 * @return_type: int
	 * @throws
	 * @author lijinwen
	 */
	public static int _LINE_() {
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		return traceElement.getLineNumber();
	}

	/**
	 * @Method_name: _TIME_
	 * @Description: 当前时间
	 * @return
	 * @return_type: String
	 * @throws
	 * @author lijinwen
	 */
	public static String _TIME_() {
		Date now = new Date(0);

		/*
		 * To get local formatting use getDateInstance(), getDateTimeInstance(),
		 * or getTimeInstance(), or use new SimpleDateFormat(String template,
		 * Localelocale) with for example Locale.US for ASCII dates
		 */
		// SimpleDateFormat sdf = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",
				Locale.getDefault());
		return sdf.format(now);
	}

	/**
	 * @Method_name: v
	 * @Description: 输出大于或等于verbose日志级别的信息
	 * @param msg
	 * @return_type: void
	 * @throws
	 * @author lijinwen
	 */
	public static void v(String msg) {
		if (!isDebug)
			return;
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		StringBuffer toStringBuffer = new StringBuffer("[")
				.append(traceElement.getFileName()).append(" | ")
				.append(traceElement.getLineNumber()).append(" | ")
				.append(traceElement.getMethodName()).append("()").append("]");
		String TAG = toStringBuffer.toString();
		android.util.Log.v(TAG, msg);
	}

	/**
	 * @Method_name: d
	 * @Description: 输出大于或等于debug日志级别的信息
	 * @param msg
	 * @return_type: void
	 * @throws
	 * @author lijinwen
	 */
	public static void d(String msg) {
		if (!isDebug)
			return;
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		StringBuffer toStringBuffer = new StringBuffer("[")
				.append(traceElement.getFileName()).append(" | ")
				.append(traceElement.getLineNumber()).append(" | ")
				.append(traceElement.getMethodName()).append("()").append("]");
		String TAG = toStringBuffer.toString();

		android.util.Log.d("\033[0;34m" + TAG, msg + "\033[0m");
	}

	/**
	 * @Method_name: i
	 * @Description: 输出大于或等于info日志级别的信息
	 * @param msg
	 * @return_type: void
	 * @throws
	 * @author lijinwen
	 */
	public static void i(String msg) {
		if (!isDebug)
			return;
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		StringBuffer toStringBuffer = new StringBuffer("[")
				.append(traceElement.getFileName()).append(" | ")
				.append(traceElement.getLineNumber()).append(" | ")
				.append(traceElement.getMethodName()).append("()").append("]");
		String TAG = toStringBuffer.toString();
		android.util.Log.i("\033[0;32m" + TAG, msg + "\033[0m");
	}

	/**
	 * @Method_name: w
	 * @Description: 输出大于或等于warn日志级别的信息
	 * @param msg
	 * @return_type: void
	 * @throws
	 * @author lijinwen
	 */
	public static void w(String msg) {
		if (!isDebug)
			return;
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		StringBuffer toStringBuffer = new StringBuffer("[")
				.append(traceElement.getFileName()).append(" | ")
				.append(traceElement.getLineNumber()).append(" | ")
				.append(traceElement.getMethodName()).append("()").append("]");
		String TAG = toStringBuffer.toString();
		android.util.Log.w("\033[0;33m" + TAG, msg + "\033[0m");
	}

	/**
	 * @Method_name: e
	 * @Description: 仅输出error日志级别的信息
	 * @param msg
	 * @return_type: void
	 * @throws
	 * @author lijinwen
	 */
	public static void e(String msg) {
		if (!isDebug)
			return;
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		StringBuffer toStringBuffer = new StringBuffer("[")
				.append(traceElement.getFileName()).append(" | ")
				.append(traceElement.getLineNumber()).append(" | ")
				.append(traceElement.getMethodName()).append("()").append("]");
		String TAG = toStringBuffer.toString();
		android.util.Log.e("\033[0;31m" + TAG, msg + "\033[0m");
	}

	public static void e(String msg, Throwable tr) {
		e(TAG, msg, tr);
	}

	public static void e(String tag, String msg) {
		if (!isDebug)
			return;
		android.util.Log.e(tag, msg);
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (!isDebug)
			return;
		android.util.Log.e(tag, msg, tr);
	}
}