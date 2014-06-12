package com.example.test233;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class NewActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		setContentView(R.layout.add);	
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.add_titlebar);
		
		Button addActivity = (Button) findViewById(R.id.addActivity);
		Button back = (Button) findViewById(R.id.back);
		
//		addActivity.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent it = new Intent(getApplicationContext(), ActivityList.class);
//				startActivity(it);
//			}
//		});
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getApplicationContext(), MapActivity.class);
				startActivity(it);
			}
		});
	}
}