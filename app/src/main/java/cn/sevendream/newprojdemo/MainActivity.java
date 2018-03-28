package cn.sevendream.newprojdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import cn.sevendream.newprojdemo.bean.User;
import cn.sevendream.newprojdemo.common.config.NetConstants;
import cn.sevendream.newprojdemo.net.handler.BaseHandler;
import cn.sevendream.newprojdemo.net.response.PersonalInfo;
import cn.sevendream.newprojdemo.net.volley.BaseVolley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private TextView mTextMessage;
	private Button reqButton;
	private Context context;
	private static final int GET_USERINFO_SUCCESS = 100;
	private static final int GET_USERINFO_ERROR = 200;
	private Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		toast = new Toast(context);
		mTextMessage = (TextView) findViewById(R.id.message);
		reqButton = (Button) findViewById(R.id.reqBtn);
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		reqButton.setOnClickListener(this);
	}


	private void testPostRequest() {
		User user = new User();
		user.setAccount("a");
		user.setPassword("b");
		new BaseVolley(myHandler, new Gson().toJson(user),
				NetConstants.getBaseUrl() + "5abb587cdde3a27b97aafef8",
				PersonalInfo.class,
				GET_USERINFO_SUCCESS,
				GET_USERINFO_ERROR,
				"testJsonPost");


	}


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

	private BaseHandler myHandler = new BaseHandler(this) {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case GET_USERINFO_SUCCESS:
					PersonalInfo personalInfo = (PersonalInfo) msg.obj;
					toast.makeText(context, personalInfo.toString(), Toast.LENGTH_LONG).show();
					break;
				case GET_USERINFO_ERROR:
					toast.makeText(context, "请求失败了", Toast.LENGTH_LONG).show();
					break;

				default:
					break;
			}
		}
	};

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.reqBtn:
				testPostRequest();
				break;
			default:
				break;
		}
	}
}
