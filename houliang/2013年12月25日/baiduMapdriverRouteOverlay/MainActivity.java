package com.example.baidumap;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MKAddrInfo;
import com.baidu.mapapi.MKBusLineResult;
import com.baidu.mapapi.MKDrivingRouteResult;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.MKPlanNode;
import com.baidu.mapapi.MKPoiResult;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MKSearchListener;
import com.baidu.mapapi.MKSuggestionResult;
import com.baidu.mapapi.MKTransitRouteResult;
import com.baidu.mapapi.MKWalkingRouteResult;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.RouteOverlay;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;
/**
 * 获取行车路线
 * @author Administrator
 *
 */
public class MainActivity extends MapActivity {
	MapView mapView;//地图控件
	BMapManager bMapManager;//添加地图引擎
	String key="C0EF05A481CAA729C2EE7AF6152EE1868FA1E755";
	MKSearch mkSearch;//用于检索的类
	//定义起始点和终点
	MKPlanNode start,end;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bMapManager = new BMapManager(this);
		bMapManager.init(key, new MKGeneralListener() {
			
			@Override
			public void onGetPermissionState(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onGetNetworkState(int arg0) {
				if(arg0==300){
					Toast.makeText(MainActivity.this, "key有误", 1);
				}
			}
		});
		initMapActivity(bMapManager);//初始化化引擎
		mapView=(MapView) findViewById(R.id.bmapview);
		mkSearch=new MKSearch();
		mkSearch.init(bMapManager, new MysearchListener());
		start=new MKPlanNode();
		start.pt=new GeoPoint((int)(39.915*1e6), (int)(116.404*1e6));
		end=new MKPlanNode();
		end.pt=new GeoPoint(40057034, 116307852);
		//驾车路线图考虑的优先策略 时间优先
		mkSearch.setDrivingPolicy(MKSearch.EBUS_TIME_FIRST);
		//设置搜索  起点所在城市 起点所在坐标 终点所在城市 终点所在坐标
		mkSearch.drivingSearch(null, start, null, end);
		
	}
	class MysearchListener implements MKSearchListener{

		@Override
		public void onGetAddrResult(MKAddrInfo arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGetBusDetailResult(MKBusLineResult arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGetDrivingRouteResult(MKDrivingRouteResult arg0, int arg1) {
			if(arg0==null){
				return;
			}
			RouteOverlay overlay=new RouteOverlay(MainActivity.this, mapView);
			//两点之间的驾车路线有多条 选择其中第一条
			overlay.setData(arg0.getPlan(0).getRoute(0));
			mapView.getOverlays().add(overlay);
			mapView.invalidate();
			
		}

		@Override
		public void onGetPoiDetailSearchResult(int arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGetPoiResult(MKPoiResult arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGetRGCShareUrlResult(String arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGetTransitRouteResult(MKTransitRouteResult arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onGetWalkingRouteResult(MKWalkingRouteResult arg0, int arg1) {
			// TODO Auto-generated method stub
			
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

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(null!=bMapManager){
			bMapManager.destroy();
			bMapManager=null;
		}
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(null!=bMapManager){
			bMapManager.start();
		}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(bMapManager!=null){
			bMapManager.start();
		}
	}

}
