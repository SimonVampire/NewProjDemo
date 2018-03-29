package cn.sevendream.newprojdemo.net.volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import cn.sevendream.newprojdemo.MyApplication;
import cn.sevendream.newprojdemo.R;
import cn.sevendream.newprojdemo.bean.BitmapCache;

/**
 * Created by zhangxue on 2018/3/29.
 */

public class ImageVolley {
	private String imgUrl;
	private NetworkImageView view;

	public ImageVolley(String imgUrl, NetworkImageView view) {
		this.imgUrl = imgUrl;
		this.view = view;
		volleyImage();
	}

	public void volleyImage() {
		RequestQueue mQueue = MyApplication.gethttpQueues();
		ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
		view.setDefaultImageResId(R.drawable.ico_default);
		view.setErrorImageResId(R.drawable.ico_default);
		view.setImageUrl(imgUrl,
				imageLoader);
	}
}
