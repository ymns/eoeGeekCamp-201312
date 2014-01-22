package com.eoe.se2.day01;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadTimerTask {

	/**计数
	 * 定时
	 * @param args
	 */
	public static void main(String[] args) {
		final Timer timer =new Timer();
		//获取当前系统时间
		long startTime=System.currentTimeMillis();
		//结束时间
		final long endTime=startTime+1000*60*10;
		//创建一个计时器计划任务
		timer.schedule(new TimerTask() {
			long minute;
			long second;
			@Override
			public void run() {
				//获取剩余时间
				long leftTime=endTime-System.currentTimeMillis();
				minute=leftTime/1000/60;
				second=leftTime/1000%60;
				System.out.println(minute+":"+second);
			}
		}, 0,1000);  //立即开始计时  一秒执行一次
//		Date endDate =new Date(endTime);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				timer.cancel();
				System.out.println("考试时间到!!");
			}
		}, 1000*10);//可以是日期类的对象
	}

}
