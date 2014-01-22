package com.eoe.day15;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	
	TextView mtvLeftTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mtvLeftTime=findViewById_(R.id.tvLeftTime);
	}
	public void start(View v){
		long startTime=System.currentTimeMillis();
		final long endTime=startTime+1000*60*10;
		final Timer timer =new Timer();
		timer.schedule(new TimerTask() {
			long minute;
			long second;
			
			@Override
			public void run() {
				//计算剩余时间
				long LeftTime=endTime-System.currentTimeMillis();
				minute=LeftTime/1000/60;
				second=LeftTime/1000%60;
				runOnUiThread(new Runnable() {  //在主线程中执行
					
					@Override
					public void run() {
						mtvLeftTime.setText(minute+":"+second);	
					}
				});
			}
		}, 0,1000);
		//设置第二个计划任务，在10秒钟之后关闭所有计划任务
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				timer.cancel();
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						mtvLeftTime.setText("成功!!!");
					}
				});
				
			}
		}, 1000*10);
	}
	

}
