package cn.sevendream.newprojdemo.common.util.image;

import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

/**
 * 图片加载状态监听
 * Created by zhangxue on 2018/3/22.
 *
 */
public class ImageListenerFactory {
	private static final String TAG="ImageListenerFactory";

	public static ImageLoader.ImageListener getImageListener(final ImageView view,
															 final int defaultImageResId, final int errorImageResId){
		return new ImageLoader.ImageListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				if(errorImageResId!=0){
					view.setImageResource(errorImageResId);
				}
			}

			@Override
			public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
				if(response.getBitmap()!=null){
					if(view.getTag().toString().equals(response.getRequestUrl())){
						view.setImageBitmap(response.getBitmap());
					}
				}
				else if(defaultImageResId!=0){
					view.setImageResource(defaultImageResId);
				}
			}
		};
	}
}