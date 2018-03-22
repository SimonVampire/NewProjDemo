package cn.sevendream.newprojdemo;

import android.app.Application;

import cn.sevendream.newprojdemo.net.MyVolley;

/**
 * Created by zhangxue on 2018/3/22.
 */

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		MyVolley.init(getApplicationContext());
	}
}
