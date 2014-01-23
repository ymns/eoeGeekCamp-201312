package com.example.day09_02__;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity 
implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button mbutton=(Button) findViewById(R.id.btnClick);
		mbutton.setOnClickListener(new MyListener());
		//button.setOnClickListener(this);
		//mOnClickListener:按钮的成员变量
	}

	@Override
	public void onClick(View v) {
		Log.i("main",v.getTag().toString()+"被点击");
	}
}
