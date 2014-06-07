package com.example.test233;

import com.example.baas.Baas;
import com.example.test233.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Login extends Activity {
	String str1 = null;
	String str2 = null;
	EditText l_username;
	EditText l_password;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		setContentView(R.layout.start);
		
		Button bt_login = (Button) findViewById(R.id.bt_login);
		l_username = (EditText) findViewById(R.id.l_username);
		l_password = (EditText) findViewById(R.id.l_password);
		
		bt_login.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				str1 = l_username.getText().toString();
				str2 = l_password.getText().toString();
				
				if (str1 != null && str2 != null) {
					Toast.makeText(getApplicationContext(), "登陆成功", 0).show();
					Intent it = new Intent(getApplicationContext(), MapActivity.class);
					startActivity(it);
					finish();
				}
				else {
					Toast.makeText(getApplicationContext(), "账号或密码错误", 0).show();
					l_username.setText("");
					l_password.setText("");
				}
			}
		});
	}
}