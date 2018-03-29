package cn.sevendream.newprojdemo.view.activity.net;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.volley.toolbox.NetworkImageView;

import cn.sevendream.newprojdemo.R;
import cn.sevendream.newprojdemo.net.volley.ImageVolley;

/**
 * Created by zhangxue on 2018/3/29.
 */

public class ImageActivity extends Activity {
	private NetworkImageView iv_image;
	private String url;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		iv_image = (NetworkImageView) this.findViewById(R.id.iv_image);
		url="http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg";
		new ImageVolley(url,iv_image);
	}
}
