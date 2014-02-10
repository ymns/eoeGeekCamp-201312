package com.eoe.se2.day06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {

	/**
	 * 线程池
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pools = Executors.newSingleThreadExecutor();
		pools.execute(new CopyTask("文件1"));
		pools.execute(new CopyTask("文件2"));
		pools.execute(new CopyTask("文件3"));
		pools.shutdown();
	}

	static class CopyTask implements Runnable {

		String fileName;

		public CopyTask(String fileName) {
			this.fileName = fileName;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println(fileName + "在复制..." + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
