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
	static final int memuid2 = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
		
		bMapManager = new BMapManager(this);
		bMapManager.init("E76F882A3E157ACC1635CAB24C330604549386FB", null);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		setContentView(R.layout.map);	
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);  
		
		mapView = (MapView)findViewById(R.id.bmapsView);
		
		mapController = mapView.getController();
		
		mapController.setCenter(new GeoPoint((int)(23.073493 * 1E6), (int)(113.398355 * 1E6)));
		mapController.setZoom(15);
	}
}