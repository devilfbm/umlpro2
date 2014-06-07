package com.example.test233;

import com.sina.sae.cloudservice.api.CloudClient;
import com.sina.sae.cloudservice.api.Statistic;
import com.sina.sae.cloudservice.exception.CloudServiceException;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        setContentView(R.layout.activity_main);
        /*
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.welcome);
		*/
        LinearLayout layout = new LinearLayout(this);
        setContentView(layout);
        
        final TextView show = new TextView(this);
        Button bn = new Button(this);
        
        bn.setText("Hello world.");
        bn.setLayoutParams(
        		new ViewGroup.LayoutParams(
        				ViewGroup.LayoutParams.WRAP_CONTENT, 
        				ViewGroup.LayoutParams.WRAP_CONTENT)
        		);
        layout.addView(show);
        layout.addView(bn);
        
        final Context context = this.getApplicationContext();
        
        bn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if( context != null)
					show.setText("Hello, Android " + new java.util.Date() + context.toString());
				
			}
        });
    }
}
