package cn.sevendream.newprojdemo.net.listener;


import com.android.volley.Response;

import cn.sevendream.newprojdemo.bean.BaseVO;

/**
 * 返回成功监听(自定义处理逻辑)
 * Created by zhangxue on 2018/3/22.
 */
public abstract class MyReponseListener implements Response.Listener<BaseVO> {
	@Override
	public void onResponse(BaseVO arg0) {
		onMyResponse(arg0);
	}

	public boolean onMyResponse(BaseVO t) {
		//      DialogMaker.closeProgressDialog();
		// 自定义处理逻辑

		return true;
	}
}