package com.example.test233;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.platform.comapi.basestruct.GeoPoint;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

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
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.map_titlebar);  
		
		Button add = (Button) findViewById(R.id.add);
		
		mapView = (MapView)findViewById(R.id.bmapsView);

		mapController = mapView.getController();
		
		mapController.setCenter(new GeoPoint((int)(23.073493 * 1E6), (int)(113.398355 * 1E6)));
		mapController.setZoom(15);
		
		   
		//准备要添加的Overlay  
		double mLat1 = 23.073493;  
		double mLon1 = 113.398355;  
		double mLat2 = 23.064831;  
		double mLon2 = 113.402484; 
		double mLat3 = 23.064432;  
		double mLon3 = 113.391702; 
		// 用给定的经纬度构造GeoPoint，单位是微度 (度 * 1E6)  
		GeoPoint p1 = new GeoPoint((int) (mLat1 * 1E6), (int) (mLon1 * 1E6));  
		GeoPoint p2 = new GeoPoint((int) (mLat2 * 1E6), (int) (mLon2 * 1E6));  
		GeoPoint p3 = new GeoPoint((int) (mLat3 * 1E6), (int) (mLon3 * 1E6));  
		
		//准备overlay图像数据，根据实情情况修复  
		Drawable unfinishedMark= this.getResources().getDrawable(R.drawable.blueflag);  
		Drawable finishedMark= this.getResources().getDrawable(R.drawable.redflag);  
		//用OverlayItem准备Overlay数据  
		OverlayItem item1 = new OverlayItem(p1,"item1","item1");  
		OverlayItem item2 = new OverlayItem(p2,"item2","item2");  
		OverlayItem item3 = new OverlayItem(p3,"item3","item3");  
		   
		//创建IteminizedOverlay  
		ItemizedOverlay<OverlayItem> unfinishedItem = new ItemizedOverlay<OverlayItem>(unfinishedMark, mapView);  
		ItemizedOverlay<OverlayItem> finishedItem = new ItemizedOverlay<OverlayItem>(finishedMark, mapView); 
	   
		mapView.getOverlays().clear();  
		mapView.getOverlays().add(unfinishedItem); 
		mapView.getOverlays().add(finishedItem); 

		unfinishedItem.addItem(item1);  
		unfinishedItem.addItem(item3);
		finishedItem.addItem(item2);
		mapView.refresh();  
		
		add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(getApplicationContext(), NewActivity.class);
				startActivity(it);
			}
		});
	}
	
}