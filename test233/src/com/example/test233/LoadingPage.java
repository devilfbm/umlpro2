package com.example.test233;

import java.util.Map;

import com.sina.sae.cloudservice.api.CloudClient;
import com.sina.sae.cloudservice.api.Statistic;
import com.sina.sae.cloudservice.exception.CloudServiceException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoadingPage extends Activity {

	private static String appname = "acremind";
	private static String ak = "0zyn4olmzz";
	private static String sk = "ik34150ykwk4z5x3i22z1wy2l5mzjxwhyl12iyh1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        setContentView(R.layout.start);
        Button bt_login = (Button) findViewById(R.id.bt_login);
        Button bt_register = (Button) findViewById(R.id.bt_register);
        
        bt_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getApplicationContext(), Login.class);
				startActivity(it);
			}
		});
        
        bt_register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getApplicationContext(), Register.class);
				startActivity(it);
			}
		});
    }
}
