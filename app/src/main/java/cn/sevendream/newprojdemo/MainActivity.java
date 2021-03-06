package cn.sevendream.newprojdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.sevendream.newprojdemo.view.activity.net.NetActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private TextView mTextMessage;
	private Button netBtn;
	private Context context;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;

		mTextMessage = (TextView) findViewById(R.id.message);
		netBtn = (Button) findViewById(R.id.netBtn);
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		netBtn.setOnClickListener(this);
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

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.netBtn:
				Intent intent = new Intent(context, NetActivity.class);
				startActivity(intent);
				break;
			default:
				break;
		}
	}
}
