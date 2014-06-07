package com.example.test233;

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

import com.example.baas.baas;
import com.example.test233.R;

public class Register extends Activity {
	int register = 0;
	EditText re_username;
	EditText re_password;
	EditText re_confirm;
	String str1 = null;
	String str2 = null;
	String str3 = null;
	
	private boolean registerIsSuccess() {
		if ("".equals(str1)) {
			Toast.makeText(Register.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}
		if ("".equals(str2)) {
			Toast.makeText(Register.this, "密码不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}
		else if (!str2.equals(str3)) {
			Toast.makeText(Register.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}
	
	private void register() {
		Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(getApplicationContext(), MapActivity.class);
		startActivity(it);
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		setContentView(R.layout.register);
		
		Button re_cancel = (Button) findViewById(R.id.r_cancel);
		Button re_register = (Button) findViewById(R.id.r_register);
		
		re_cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getApplicationContext(), LoadingPage.class);
				startActivity(it);
			}
		});
		
		re_register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				re_username = (EditText) findViewById(R.id.r_username);
				re_password = (EditText) findViewById(R.id.r_password);
				re_confirm = (EditText) findViewById(R.id.r_confirm);
				str1 = re_username.getText().toString();
				str2 = re_password.getText().toString();
				str3 = re_confirm.getText().toString();		
				if (registerIsSuccess()) {
					register();
				}
			}
		});
	}
}
