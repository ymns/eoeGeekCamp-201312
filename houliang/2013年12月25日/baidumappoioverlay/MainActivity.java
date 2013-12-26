package com.example.baidumappoioverlay;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapView;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;
/**
 *搜索服务
 */
public class MainActivity extends MapActivity {
	BMapManager bMapManager=null;//百度地图的引擎
	MapView mapView;
	String key="C0EF05A481CAA729C2EE7AF6152EE1868FA1E755";
	MKSearch mkSearch;//用于搜索服务

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bMapManager=new BMapManager(this);
		bMapManager.init(key, new MKGeneralListener() {
			
			@Override
			public void onGetPermissionState(int arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onGetNetworkState(int arg0) {
				if(arg0!=300){
					Toast.makeText(MainActivity.this, "输入的key有误", 1).show();
				}
			}
		});
		initMapActivity(bMapManager);//初始化地图引擎
		//初始化控件
		mapView=(MapView) findViewById(R.id.bmapview);
		mkSearch=new MKSearch();
		mkSearch.init(bMapManager, new MyMKSearchListener(this,mapView));
		
		GeoPoint geoPoint=new GeoPoint((int)(39.915*1e6),(int)(116.454*1e6));
		//根据中心点geoPoint在1000半径内查询KFC
		mkSearch.poiSearchNearBy("饭店", geoPoint, 5000);
		
		
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(bMapManager!=null){
			bMapManager.destroy();
			bMapManager=null;
		}
	}
	@Override
	protected void onResume() {
		super.onResume();
		if(bMapManager!=null){
			bMapManager.start();
		}
	}
	@Override
	protected void onPause() {
		super.onPause();
		if(bMapManager!=null){
			bMapManager.stop();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
