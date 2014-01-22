package com.eoe.se2.day01;

import java.util.Random;

public class ThreadDaemon {

	/**
	 * 守护线程
	 * 
	 * @param args
	 */
	static int[] a = new int[30];
	static int index;

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			// 前台线程
			@Override
			public void run() {
				super.run();
				while (index < 10) {
					if (a[index] > 0) {
						System.out.println(Thread.currentThread().getName()
								+ ":" + a[index] + ":" + index);
						Thread.yield();
					}
				}
			}
		};
		t1.start();
		final Random random = new Random(); // 匿名内部类引用常量
		Thread t2 = new Thread() {
			// 守护线程
			@Override
			public void run() {
				super.run();
				while (true) {
					a[index] = random.nextInt(100); // 产生随机数
					System.out.println(Thread.currentThread().getName() + ":"
							+ a[index] + ":" + index);
					yield();// 让时间
					index++;
				}
			}
		};
		t2.setDaemon(true);
		t2.start();

	}

}
