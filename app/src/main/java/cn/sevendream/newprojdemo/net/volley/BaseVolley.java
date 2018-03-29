package cn.sevendream.newprojdemo.net.volley;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import cn.sevendream.newprojdemo.MyApplication;
import cn.sevendream.newprojdemo.common.log.Log;
import cn.sevendream.newprojdemo.net.listener.ResponseListener;
import cn.sevendream.newprojdemo.net.request.common.JsonObjReq;
import cn.sevendream.newprojdemo.net.request.common.StringRequest;
import cn.sevendream.newprojdemo.net.response.common.ParentResp;
import cn.sevendream.newprojdemo.net.util.ResCode;

/**
 * Created by zhangxue 2018年03月23日16:51:57
 * 用于已登录后的相关接口调用请求
 */
public class BaseVolley {
	/**
	 * Handler
	 */
	private Handler mHandler;
	/**
	 * 参数
	 */
	private String mParams;
	/**
	 * 地址
	 */
	private String mUrl;
	/**
	 * 响应参数
	 */
	private Class mClass;

	/**
	 * 请求成功标签，注意不一定返回的就是成功（000000），需要handmessage里面判断
	 */
	private int volleySuccess;
	/**
	 * 请求失败标签
	 */
	private int volleyError;

	/**
	 * 请求队列标签，用于标记请求，方便取消请求
	 */
	private String tag;

	private Context context;

	/**
	 * post网络请求
	 *
	 * @param mHandler       接口返回信息处理handler
	 * @param mParams        请求参数
	 * @param mUrl           请求地址
	 * @param mClass         响应参数
	 * @param volleysSuccess 请求成功标签
	 * @param volleyError    请求失败标签
	 */

	public BaseVolley(Handler mHandler, String mParams, String mUrl, Class mClass, int volleysSuccess, int volleyError, String tag) {
		this.mHandler = mHandler;
		this.mParams = mParams;
		this.mUrl = mUrl;
		this.mClass = mClass;
		this.volleySuccess = volleysSuccess;
		this.volleyError = volleyError;
		this.tag = tag;
		volleyJsonPost();
	}

	/**
	 * get网络请求
	 *
	 * @param mHandler
	 * @param mUrl
	 * @param mClass
	 * @param volleysSuccess
	 * @param volleyError
	 * @param tag
	 */
	public BaseVolley(Handler mHandler, String mUrl, Class mClass, int volleysSuccess, int volleyError, String tag) {
		this.mHandler = mHandler;
		this.mUrl = mUrl;
		this.mClass = mClass;
		this.volleySuccess = volleysSuccess;
		this.volleyError = volleyError;
		this.tag = tag;
		volleyStringGet();
	}

	/**
	 * String GET请求
	 */
	public void volleyStringGet() {
		cancelVolleyByTag(tag);
		StringRequest<ParentResp> mGsonRequest = new StringRequest<ParentResp>(mUrl, mClass,
				new ResponseListener<ParentResp>() {
					Message message = new Message();
					@Override
					public void onResponse(ParentResp response) {
						if (null != response && response.isSuccess()) {
							message.what = volleySuccess;
							message.obj = response;
							mHandler.sendMessage(message);
						} else {
							message.what = volleyError;
							mHandler.sendMessage(message);
						}
						Log.i("消息类型:" + message.what);
					}

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("请求url：" + mUrl + "error:" + error);
						message.what = volleyError;
						if (error != null)
							message.obj = error.getMessage();
						else
							message.obj = ResCode.UNKNOWN_ERROR_MSG;

						mHandler.sendMessage(message);
					}

				});
		mGsonRequest.setTag(tag);

		MyApplication.gethttpQueues().add(mGsonRequest);
	}

	/**
	 * JsonPost请求
	 */
	public void volleyJsonPost() {
		cancelVolleyByTag(tag);

		Log.i("请求参数：" + mUrl + "：" + mParams);
		JsonObjReq<ParentResp> mGsonRequest = new JsonObjReq<ParentResp>(
				Request.Method.POST, mUrl, mParams, mClass,
				new Response.Listener<ParentResp>() {
					Message message = new Message();

					@Override
					public void onResponse(ParentResp response) {

						if (null != response && response.isSuccess()) {
							message.what = volleySuccess;
							message.obj = response;
							mHandler.sendMessage(message);
						} else {
							message.what = volleyError;
							mHandler.sendMessage(message);
						}
						Log.i("消息类型:" + message.what);


					}
				}, new Response.ErrorListener() {
			Message message = new Message();

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("请求url：" + mUrl + "error:" + error);
				message.what = volleyError;
				if (error != null)
					message.obj = error.getMessage();
				else
					message.obj = ResCode.UNKNOWN_ERROR_MSG;

				mHandler.sendMessage(message);
			}
		});
		mGsonRequest.setTag(tag);

		MyApplication.gethttpQueues().add(mGsonRequest);
	}


	/**
	 * 通过tag标签取消对应的请求
	 *
	 * @param tag
	 */
	public void cancelVolleyByTag(String tag) {
		MyApplication.gethttpQueues().cancelAll(tag);
	}
}
