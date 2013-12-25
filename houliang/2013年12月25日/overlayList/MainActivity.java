package com.example.baidumap;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends MapActivity {

	// 添加百度地图的相关控件
	private MapView mapView;
	private BMapManager bMapManager;// 地图引擎管理类
	// 在百度地图上添加一些控件 如放大或是缩小的控件
	private MapController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mapView = (MapView) findViewById(R.id.bmapview);
		bMapManager = new BMapManager(this);
		bMapManager.init("C0EF05A481CAA729C2EE7AF6152EE1868FA1E755",
				new MKGeneralListener() {

					@Override
					public void onGetPermissionState(int arg0) {
						// TODO Auto-generated method stub
						if (arg0 == 300) {
							Toast.makeText(MainActivity.this, "输入的key有误", 1)
									.show();
						}
					}

					@Override
					public void onGetNetworkState(int arg0) {
						// TODO Auto-generated method stub

					}
				});
		initMapActivity(bMapManager);
		mapView.setBuiltInZoomControls(true);// 表示可以设置缩放功能
		controller = mapView.getController();// 实例化mapcontroller
		// 定义一个经纬度
		GeoPoint geoPoint = new GeoPoint((int) (39.915 * 1E6),
				(int) (116.404 * 1E6));
		controller.setCenter(geoPoint);// 设置中心点
		controller.setZoom(12);// 设置缩放
		// mapView.setTraffic(true);
		// mapView.setSatellite(true);
		Drawable drawable = getResources().getDrawable(R.drawable.eat_icon);
		MyOverLayItem overLayItem = new MyOverLayItem(drawable, mapView,this);
		mapView.getOverlays().add(overLayItem);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (bMapManager != null) {
			bMapManager.destroy();
			bMapManager = null;
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (bMapManager != null) {
			bMapManager.start();
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (bMapManager != null) {
			bMapManager.stop();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
