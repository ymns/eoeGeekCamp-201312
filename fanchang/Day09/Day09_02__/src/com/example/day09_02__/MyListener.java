package com.example.day09_02__;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MyListener implements OnClickListener {

	@Override
	public void onClick(View v) {
		Log.i("main",v.getTag().toString()+"被点击...");
	}

}
