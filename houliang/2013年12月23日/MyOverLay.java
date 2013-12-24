package com.eoe.aa;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.widget.Toast;

import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.Overlay;

public class MyOverLay extends Overlay {
	GeoPoint mPoint;
	Context mContext;

	public MyOverLay(Context ctx, GeoPoint point) {
		this.mContext = ctx;
		this.mPoint = point;
		mPaint = new Paint();
	}

	Paint mPaint;

	@Override
	public void draw(Canvas canvas, MapView mpView, boolean flag) {
		super.draw(canvas, mpView, flag);
		Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),
				android.R.drawable.btn_star_big_on);
		Point point = mpView.getProjection().toPixels(mPoint, null);
		canvas.drawBitmap(bitmap,point.x,point.y, mPaint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0, MapView arg1) {
		//Toast.makeText(mContext, "当前位置:["+mPoint.getLatitudeE6()+","+mPoint.getLongitudeE6()+"]", Toast.LENGTH_LONG).show();
		return super.onTouchEvent(arg0, arg1);
	}
	
	@Override
	public boolean onTap(GeoPoint arg0, MapView arg1) {
		Toast.makeText(mContext, "当前位置:["+arg0.getLatitudeE6()+","+arg0.getLongitudeE6()+"]", Toast.LENGTH_LONG).show();
		return true;
	}
}