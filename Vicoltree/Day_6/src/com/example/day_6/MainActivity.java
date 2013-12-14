package com.example.day_6;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button showPgBtn;

	ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showPgBtn = (Button) findViewById(R.id.showPgBtn);
		showPgBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				pd = ProgressDialog.show(MainActivity.this, "加载中", "正在加载...");
				handler.sendEmptyMessageDelayed(1, 3000);
			}
		});
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				pd.dismiss();
				break;

			default:
				break;
			}

		};
	};
}
