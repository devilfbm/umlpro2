package com.example.test233;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MapActivity extends Activity {
	
	BMapManager bMapManager;
	MapView mapView;
	MapController mapController;
	static final int menuid1 = 1;
	static final int menuid2 = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		bMapManager = new BMapManager(this);
		bMapManager.init("E76F882A3E157ACC1635CAB24C330604549386FB", null);
		
		setContentView(R.layout.map);	
		
		mapView = (MapView) findViewById(R.id.bmapsView);
		mapController = mapView.getController();
		
		mapController.setCenter(new GeoPoint((int)(23.073493 * 1E6), (int)(113.398355 * 1E6)));
		mapController.setZoom(15);
	}
	
	protected void onDestroy()
	{
		mapView.destroy();
		if(bMapManager != null)
		{
			bMapManager.destroy();
			bMapManager = null;
		}
		super.onDestroy();
	}
	
	protected void onPause()
	{
		mapView.onPause();
		if(bMapManager != null)
			bMapManager.stop();
		super.onPause();
	}
	
	protected void onResume()
	{
		mapView.onResume();
		if(bMapManager != null)
			bMapManager.start();
		super.onResume();
	}
	
}