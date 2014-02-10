package com.eoe.se2.day06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	/**
	 * 线程池
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pools = Executors.newFixedThreadPool(3);
		pools.execute(new MyThread("张飞"));
		pools.execute(new MyThread("万芳"));
		pools.execute(new MyThread("刘亦菲"));
		pools.shutdown();
	}

	static class MyThread extends Thread {
		String name;

		public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				if ("张飞".equals(name)) {
					System.out.println(name + "射箭..." + i);
				} else if ("万芳".equals(name)) {
					System.out.println(name + "唱歌..." + i);
				} else if ("刘亦菲".equals(name)) {
					System.out.println(name + "演戏..." + i);
				}
			}
		}
	}

}
