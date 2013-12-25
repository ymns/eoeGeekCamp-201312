package com.example.baidumappoioverlay;
import android.app.Activity;
import android.content.Context;
import com.baidu.mapapi.MKAddrInfo;
import com.baidu.mapapi.MKBusLineResult;
import com.baidu.mapapi.MKDrivingRouteResult;
import com.baidu.mapapi.MKPoiResult;
import com.baidu.mapapi.MKSearchListener;
import com.baidu.mapapi.MKSuggestionResult;
import com.baidu.mapapi.MKTransitRouteResult;
import com.baidu.mapapi.MKWalkingRouteResult;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.PoiOverlay;

public class MyMKSearchListener implements MKSearchListener{
	Context context;
	MapView mapView;
	
	public MyMKSearchListener(Context context, MapView mapView) {
		super();
		this.context = context;
		this.mapView = mapView;
	}

	@Override
	public void onGetWalkingRouteResult(MKWalkingRouteResult arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGetTransitRouteResult(MKTransitRouteResult arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGetRGCShareUrlResult(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGetPoiResult(MKPoiResult result, int type, int iError) {
		if(result==null){
			return;
		}
		PoiOverlay overlay=new PoiOverlay((Activity) context, mapView);
		overlay.setData(result.getAllPoi());
		mapView.getOverlays().add(overlay);
		
	}
	
	@Override
	public void onGetPoiDetailSearchResult(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGetDrivingRouteResult(MKDrivingRouteResult arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGetBusDetailResult(MKBusLineResult arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGetAddrResult(MKAddrInfo arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}

