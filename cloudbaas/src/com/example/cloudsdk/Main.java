package com.example.cloudsdk;

import com.sina.sae.cloudservice.api.CloudClient;
import com.sina.sae.cloudservice.exception.CloudServiceException;

import android.app.Application;
import android.os.Bundle;

public class Main extends Application {

	private static String appname = "acremind";
	private static String ak = "0zyn4olmzz";
	private static String sk = "ik34150ykwk4z5x3i22z1wy2l5mzjxwhyl12iyh1";
	
	protected void onCreate(Bundle savedInstanceState) {
		//首先检测网络是否通畅
		if(CloudClient.checkNetwork(this)){
			try {
				CloudClient.init(this, appname, ak, sk);//执行初始化操作
				//接下来就可以使用SDK各功能接口了
				// CloudObject CloudDB CloudFile CloudMail ......
			} catch (CloudServiceException e) {
				e.printStackTrace();
			}
		}
	}
}
