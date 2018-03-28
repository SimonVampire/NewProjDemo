package cn.sevendream.newprojdemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zhangxue on 2018/3/22.
 */

public class MyApplication extends Application {
	public  static RequestQueue queues;
	@Override
	public void onCreate() {
		super.onCreate();
		queues = Volley.newRequestQueue(getApplicationContext());
	}
	/**
	 * 请求队列实例化
	 * @return
	 */
	public static  RequestQueue gethttpQueues(){
		return queues;
	}

}
