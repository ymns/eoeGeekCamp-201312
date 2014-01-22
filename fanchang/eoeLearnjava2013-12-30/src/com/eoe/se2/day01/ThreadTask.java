package com.eoe.se2.day01;

import java.util.ArrayList;
import java.util.Scanner;

public class ThreadTask {

	/**
	 * 实现一个线程输入数据,另一个线程取出数据的异步操作,并确保数据的正确性
	 * 
	 * @param args
	 */
	// 集合task存放任务列表
	static ArrayList<String> task = new ArrayList<>();

	public static void main(String[] args) {
		// 创建前台线程t1
		final Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				String s = null;
				while (true) {
					try {
						Thread.sleep(1000 * 60); // 休眠1分钟
					} catch (InterruptedException e) {
						// 捕获到异常后的处理,休眠的一分钟内
						for (int i = 0; i < 100000; i++) { // 浪费时间
							s += "a";
						}
						while (task.size() > 0) { // 确保有元素
							s = task.remove(0); // 移除第0个元素
							if (s.equals("q")) { // 如果输入q,打印
								System.out.println("Over Game");
								break;
							}
							System.out.println(Thread.currentThread().getName()
									+ ":" + s);
						}
					}
					if (s.equals("q")) {
						break;
					}
				}
			}
		};
		t1.start();
		// 创建后台进程
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("输入字符串");
					String text = new Scanner(System.in).next();
					task.add(text);
					t1.interrupt();
				}
			}
		};
		t2.setDaemon(true);// 设置后台进程
		t2.start();

	}

}
