package com.eoe.pre.day04;

import java.util.Timer;
import java.util.TimerTask;

public class Test07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个计划任务对象
		final Timer timer=new Timer();
		//获取系统当前时间，单位：毫秒
		long start=System.currentTimeMillis();
		final long end=start+1000*10;//60秒以后的时间
		
		timer.schedule(new TimerTask() {
			long minute,second;
			@Override
			public void run() {
				//计算剩余时间
				long leftTime=end-System.currentTimeMillis();
				minute=leftTime/1000/60;//计算分钟
				second=leftTime/1000%60;//计算秒
				System.out.println(minute+":"+second);
			}
		}, 0,1000);
		//设置第二个计划任务，10秒后停止所有计划任务
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("发射!");
				timer.cancel();
			}
		}, 10*1000);
	}

}
