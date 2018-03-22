package cn.sevendream.newprojdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;

import cn.sevendream.newprojdemo.bean.BaseVO;
import cn.sevendream.newprojdemo.net.MyVolley;
import cn.sevendream.newprojdemo.net.listener.MyErrorListener;
import cn.sevendream.newprojdemo.net.listener.MyReponseListener;
import cn.sevendream.newprojdemo.net.request.GsonRequest;
import cn.sevendream.newprojdemo.net.response.PersonalInfo;

public class MainActivity extends AppCompatActivity {

	private TextView mTextMessage;
	private Button reqButton;

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_home:
					mTextMessage.setText(R.string.title_home);
					return true;
				case R.id.navigation_dashboard:
					mTextMessage.setText(R.string.title_dashboard);
					return true;
				case R.id.navigation_notifications:
					mTextMessage.setText(R.string.title_notifications);
					return true;
			}
			return false;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTextMessage = (TextView) findViewById(R.id.message);
		reqButton = (Button) findViewById(R.id.reqBtn);
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


		reqButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				testGetRequest();
			}
		});
	}

	public void testGetRequest(){
		MyApplication application =new MyApplication();
		String url="http://api.k780.com:88/?app=idcard.get&idcard=110101199001011114&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
		GsonRequest request=new GsonRequest(url, PersonalInfo.class, new MyReponseListener() {

			@Override
			public void onResponse(BaseVO t) {
				super.onResponse(t);
				PersonalInfo bean=(PersonalInfo) t;
				Log.e("success", bean.toString());
			}

		}, new MyErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				super.onErrorResponse(error);
			}

		});
		MyVolley.addRequest(request);
	}

}
