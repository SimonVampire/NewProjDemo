package cn.sevendream.newprojdemo.view.activity.net;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import cn.sevendream.newprojdemo.R;
import cn.sevendream.newprojdemo.bean.User;
import cn.sevendream.newprojdemo.common.config.NetConstants;
import cn.sevendream.newprojdemo.net.handler.BaseHandler;
import cn.sevendream.newprojdemo.net.response.PersonalInfo;
import cn.sevendream.newprojdemo.net.volley.BaseVolley;

public class NetActivity extends AppCompatActivity implements View.OnClickListener {
	private Context context;
	private static final int USERINFO_POST_SUCCESS = 100;
	private static final int USERINFO_POST_ERROR = 200;
	private static final int USERINFO_GET_SUCCESS = 300;
	private static final int USERINFO_GET_ERROR = 400;
	private Toast toast;
	private Button postBtn;
	private Button getBtn;
	private Button imageBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_net);
		context = this;
		toast = new Toast(context);
		postBtn = (Button) findViewById(R.id.postBtn);
		getBtn = (Button) findViewById(R.id.getBtn);
		imageBtn = (Button) findViewById(R.id.imageBtn);
		postBtn.setOnClickListener(this);
		getBtn.setOnClickListener(this);
		imageBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.postBtn:
				testPostRequest();
				break;
			case R.id.getBtn:
				testGetRequest();
				break;
			case R.id.imageBtn:
				Intent intent = new Intent(context, ImageActivity.class);
				startActivity(intent);
				break;
			default:
				break;
		}
	}

	private BaseHandler myHandler = new BaseHandler(this) {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case USERINFO_POST_SUCCESS:
					PersonalInfo personalInfo = (PersonalInfo) msg.obj;
					toast.makeText(context, personalInfo.toString(), Toast.LENGTH_LONG).show();
					break;
				case USERINFO_POST_ERROR:
					toast.makeText(context, "POST请求失败了", Toast.LENGTH_LONG).show();
					break;

				case USERINFO_GET_SUCCESS:
					PersonalInfo personalInfo2 = (PersonalInfo) msg.obj;
					toast.makeText(context, personalInfo2.toString(), Toast.LENGTH_LONG).show();
					break;
				case USERINFO_GET_ERROR:
					toast.makeText(context, "GET请求失败了", Toast.LENGTH_LONG).show();
					break;

				default:
					break;
			}
		}
	};

	private void testPostRequest() {
		User user = new User();
		user.setAccount("a");
		user.setPassword("b");
		new BaseVolley(myHandler, new Gson().toJson(user),
				NetConstants.getBaseUrl() + "5abb587cdde3a27b97aafef8",
				PersonalInfo.class,
				USERINFO_POST_SUCCESS,
				USERINFO_POST_ERROR,
				"testJsonPost");


	}

	private void testGetRequest() {
		new BaseVolley(myHandler,
				NetConstants.getBaseUrl() + "5abb793da989de7badbe19ee/:account/:password",
				PersonalInfo.class,
				USERINFO_GET_SUCCESS,
				USERINFO_GET_ERROR,
				"testJsonPost");
	}

}
