package com.eoe.se2.day01;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Thread t=new Thread("张飞"){
			
			@Override
			public void run() {
				while (true) {
					System.out.println(this.getName()+"zZZ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("谁把我吵醒了");
						break;
					}
				}
			}
		};
		t.start();
		final Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				t.interrupt();
				timer.cancel();
			}
		}, 1000*5);

	}

}
