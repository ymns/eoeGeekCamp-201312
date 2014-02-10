package com.eoe.se2.day06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolsDown {

	/**
	 * 使用单线程下载文件
	 * 
	 * @param args
	 */
	static final String SRC_PATH = "D:/java_test/";
	static final String DEST_PATH = "D:/java_test/se2_day06/";
	static ArrayList<String> taskList = new ArrayList<String>();
	static ExecutorService pools;

	public static void main(String[] args) {
		// 初始化任务列表
		initTaskList();
		// 创建单线程池
		pools = Executors.newSingleThreadExecutor();
		// 用户选择复制文件的线程,匿名内部类
		new Thread() {
			public void run() {
				while (true) {
					// 显示复制的文件列表
					showTaskList();
					Scanner scanner = new Scanner(System.in);
					int select = scanner.nextInt();
					if (select == taskList.size()) {// 如果选择的是最后一个
						System.out.println("退出");
						pools.shutdown();
						break;
					}
					// 移除你选择的这个下载文件
					String fileName = taskList.remove(select - 1);
					// 启动下载线程
					pools.execute(new DownLoadTask(fileName));
				}
			};
		}.start();

	}

	// 显示复制的文件列表
	protected static void showTaskList() {
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println(i + 1 + "-" + taskList.get(i));
		}
	}

	private static void initTaskList() {
		taskList.add("apache-tomcat.rar");
		taskList.add("javaapi.zip");
		taskList.add("Office2003.rar");
		taskList.add("eclipse.zip");
		taskList.add("退出");
	}

	// 复制任务的线程类
	static class DownLoadTask implements Runnable {
		String fileName;

		public DownLoadTask(String fileName) {
			this.fileName = fileName;
		}

		@Override
		public void run() {
			File file = new File(DEST_PATH);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileInputStream fis = null;
			FileOutputStream fos = null;

			try {
				fis = new FileInputStream(SRC_PATH + fileName);
				fos = new FileOutputStream(DEST_PATH + fileName);
				int len;
				byte[] buffer = new byte[1024];
				while ((len = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				System.out.println(fileName + "文件复制完毕");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
					if (fis != null) {
						fis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
