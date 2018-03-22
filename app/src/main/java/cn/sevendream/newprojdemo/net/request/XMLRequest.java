package cn.sevendream.newprojdemo.net.request;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * 服务器以XML格式返回数据
 * Created by zhangxue on 2018/3/22.
 */
public class XMLRequest extends Request<XmlPullParser> {
	private Response.Listener<XmlPullParser> mListener;

	public XMLRequest(int method, String url, Response.Listener<XmlPullParser> listener,
					  Response.ErrorListener errorListener) {
		super(method, url, errorListener);
		//不启用缓存
		setShouldCache(false);
		mListener = listener;
	}

	public XMLRequest(String url, Response.Listener<XmlPullParser> listener, Response.ErrorListener errorListener) {
		this(Method.GET, url, listener, errorListener);
	}


	/**
	 * 解析服务器返回的数据
	 */
	@Override
	protected Response<XmlPullParser> parseNetworkResponse(
			NetworkResponse response) {
		try {
			String xmlString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			//创建解析工厂
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			//获取解析器
			XmlPullParser xmlPullParser = factory.newPullParser();
			//设置解析数据
			xmlPullParser.setInput(new StringReader(xmlString));
			return Response.success(xmlPullParser, HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (XmlPullParserException e) {
			return Response.error(new ParseError(e));
		}
	}

	/**
	 * 分发结果
	 */
	@Override
	protected void deliverResponse(XmlPullParser response) {
		mListener.onResponse(response);
	}
}