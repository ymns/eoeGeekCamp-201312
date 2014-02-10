package com.eoe.se2.day06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool2 {

	/**
	 * 带缓存的线程池的创建与使用. 本例演示带缓存的线程池， 
	 * 当向该线程池添加多个代表下载 文件的任务时， 
	 * 该线程池将并发运行这些下载任务。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pools = Executors.newCachedThreadPool();
		pools.execute(new DownLoadTask("文件1"));
		pools.execute(new DownLoadTask("文件2"));
		pools.execute(new DownLoadTask("文件3"));
		pools.shutdown();
	}

	static class DownLoadTask implements Runnable {
		String fileName;

		public DownLoadTask(String fileName) {
			this.fileName = fileName;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println(fileName + "正在下载..." + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
