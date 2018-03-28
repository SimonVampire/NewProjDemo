package cn.sevendream.newprojdemo.net.request.common;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cn.sevendream.newprojdemo.common.log.Log;
import cn.sevendream.newprojdemo.net.response.common.ParentResp;


public class JsonObjReq<T> extends JsonRequest<T> {
	private Gson mGson;
	private String mUrl;
	private Class<T> mClass;
	private boolean mNeedSignVerification;
	private String mKeep;

	public JsonObjReq(int method, String url, String jsonBody, Class<T> mClass,
					  Listener<T> listener, ErrorListener errorListener) {

		this(method, url, jsonBody, mClass, false, null, listener,
				errorListener);


	}

	/**
	 * @param method
	 * @param url
	 * @param jsonBody
	 * @param mClass
	 * @param needSignVerification 是否需要对接口返回信息进行验签
	 * @param keep                 延签关键字
	 * @param listener
	 * @param errorListener
	 */
	public JsonObjReq(int method, String url, String jsonBody, Class<T> mClass,
					  boolean needSignVerification, String keep, Listener<T> listener,
					  ErrorListener errorListener) {
		super(method, url, jsonBody, listener, errorListener);
		this.mClass = mClass;
		this.mUrl = url;
		mGson = new Gson();
		mNeedSignVerification = needSignVerification;
		mKeep = keep;
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = "";

			jsonString = new String(response.data,"utf-8");
			JSONObject obj = new JSONObject(jsonString);
			boolean success = obj.getBoolean("success");
			if(success){
				jsonString = obj.getString("data");
			}else{
				ParentResp parentResp = new ParentResp();
				parentResp.setSuccess(obj.getBoolean("success"));
				parentResp.setDescription(obj.getString("description"));
				parentResp.setSign("");
				jsonString = mGson.toJson(parentResp);
			}

			Log.i("接口名:" + mUrl + "返回响应:" + mClass + "：" + jsonString);

			return Response.success(mGson.fromJson(jsonString, mClass),
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException e){
			return Response.error(new ParseError(e));
		}
	}
}
