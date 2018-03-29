package cn.sevendream.newprojdemo.net.listener;

import com.android.volley.Response;

/**
 * Created by zhangxue on 2018/3/29.
 */

public interface ResponseListener<ParentResp> extends Response.ErrorListener,Response.Listener<ParentResp>  {
}
