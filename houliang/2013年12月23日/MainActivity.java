package com.eoe.aa;
import android.os.Bundle;
import android.view.Menu;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
public class MainActivity extends MapActivity {
	BMapManager mbMapManager;//声明地图引擎管理器
	MapView mMapView;//
	String key="TH9EuNmPVGB0X9Ki4fHCjp1i";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//创建地图引擎管理器
		mbMapManager=new BMapManager(getApplication());
		//初始化地图引擎管理器
		mbMapManager.init(key, null);
		super.initMapActivity(mbMapManager);
		mMapView = (MapView) findViewById(R.id.bmapsView);
		mMapView.setBuiltInZoomControls(true);
		//设置启用内置的缩放控件
		MapController controller=mMapView.getController();
		GeoPoint geoPoint=new GeoPoint((int) (39.915* 1E6),
				(int) (116.404 * 1E6));
		controller.setCenter(geoPoint);
		controller.setZoom(12);
		
		mMapView.getOverlays().add(new MyOverLay(this, geoPoint));
	}
	

	@Override
	protected void onDestroy() {
		if(mbMapManager!=null){
			mbMapManager.destroy();
			mbMapManager=null;
		}
	}
	@Override
	protected void onPause() {
		if(null!=mbMapManager){
			mbMapManager.stop();
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
