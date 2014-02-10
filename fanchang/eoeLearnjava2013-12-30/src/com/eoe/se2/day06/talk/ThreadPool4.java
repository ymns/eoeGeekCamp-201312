package com.eoe.se2.day06.talk;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建带缓存的线程池,由ThreadPoolExecutor变量引用
		final ThreadPoolExecutor pools = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		// 创建模拟聊天的任务
		TalkTask talk = new TalkTask();
		// 创建模拟扫描杀毒的任务
		ScanVirusTask scannVirus = new ScanVirusTask();
		// 向线程池中添加聊天任务
		pools.execute(talk);
		// 向线程池中添加扫描杀毒任务
		pools.execute(scannVirus);
		// 添加下载任务
		pools.execute(new DownLoadTask());
		// 向线程池添加一个实现了runnable的匿名类,用于监控线程池中线程的状态
		pools.execute(new Runnable() {

			@Override
			public void run() {
				int i = 1;
				while (true) {
					try {
						Thread.sleep(1000);
						i++;
						System.out.println("任务数:" + pools.getTaskCount());
						System.out.println("活动线程数量:" + pools.getActiveCount());
						System.out.println("线程池中的线程数量:" + pools.getPoolSize());
						System.out.println("执行完毕的线程数:"
								+ pools.getCompletedTaskCount());

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

	}

	// 模拟聊天线程
	static class TalkTask implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println("与客户聊天");
					Thread.sleep(1000 * 10);
					System.out.println("结束与客户的聊天");
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 模拟下载任务线程
	static class DownLoadTask implements Runnable {

		@Override
		public void run() {
			try {
				for (int i = 0; i < 50; i++) {

					Thread.sleep(100);
					System.out.println("下载文件...");
					break;
				}
				System.out.println("下载文件结束");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	// 模拟后台扫描杀毒线程
	static class ScanVirusTask implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					Thread.sleep(1000);
					System.out.println("执行后台扫描杀毒操作...");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
