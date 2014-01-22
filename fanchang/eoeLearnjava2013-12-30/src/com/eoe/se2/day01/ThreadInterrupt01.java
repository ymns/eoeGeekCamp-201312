package com.eoe.se2.day01;

import java.util.Scanner;

public class ThreadInterrupt01 {

	/**
	 * 键盘输入打断
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final Thread zhangFei = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("zZ..");
					try {
						Thread.sleep(1000); // 睡一秒
					} catch (InterruptedException e) {
						System.out.println("谁把我吵醒了");
						break;
					}
				}
			}
		};
		zhangFei.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println("请键盘输入");
				new Scanner(System.in).next();
				zhangFei.interrupt(); // 唤醒zhangfei
			}
		}.start();

	}

}
