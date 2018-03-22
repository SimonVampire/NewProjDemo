package cn.sevendream.newprojdemo.net.listener;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * 自定义返回错误信息监听
 *Created by zhangxue on 2018/3/22.
 *
 */
public abstract class MyErrorListener implements Response.ErrorListener {

	public void onErrorResponse(VolleyError error) {
		//自定义同意错误逻辑处理
	}
}