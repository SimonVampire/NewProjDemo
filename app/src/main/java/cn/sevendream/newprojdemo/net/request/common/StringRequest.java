package cn.sevendream.newprojdemo.net.request.common;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cn.sevendream.newprojdemo.common.log.Log;
import cn.sevendream.newprojdemo.net.listener.ResponseListener;
import cn.sevendream.newprojdemo.net.response.common.ParentResp;

/**
 * Created by zhangxue on 2018/3/29.
 */

public class StringRequest<T> extends Request<T> {
	/**
	 * 正确数据的时候回掉用
	 */
	private ResponseListener mListener;
	/*用来解析 json 用的*/
	private Gson mGson;
	/*在用 gson 解析 json 数据的时候，需要用到这个参数*/
	private Class<T> mClazz;
	private String mUrl;
	public StringRequest(String url, Class<T> c, ResponseListener listener) {
		super(Method.GET, url, listener);
		this.mListener = listener;
		this.mGson = new Gson();
		this.mClazz = c;
		this.mUrl = url;
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			T result;
			String jsonString =
					new String(response.data, HttpHeaderParser.parseCharset(response.headers));
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
			Log.i("接口名:" + mUrl + "返回响应:" + mClazz + "：" + jsonString);

			return Response.success(mGson.fromJson(jsonString, mClazz),
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		}catch (JSONException e){
			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(Object response) {
		mListener.onResponse(response);
	}
}
