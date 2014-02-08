package com.eoe.se2.day04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IoDownLoad {

	/**
	 * 异步下载多个文件
	 * 
	 * @param args
	 */
	// 待选下载列表路径
	static ArrayList<String> tasklist = new ArrayList<String>();
	// 选的当前下载的任务
	static ArrayList<String> tasks = new ArrayList<String>();
	// 下载源文件路径
	static final String SRC_PATH = "d:/java_test";
	// 下载目标文件路径
	static final String DEST_PATH = "d:/java_test/se2_day04";

	public static void main(String[] args) {
		// 任务列表初始化
		initTasklist();
		// 创建下载线程
		final DownLoadTask downLoadTask = new DownLoadTask();
		// 启动下载线程
		downLoadTask.start();
		// 创建用户等待选择下载文件的线程
		Thread ctrlThread = new Thread() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (true) {
					// 显示下载列表
					showTaskList();
					int select;
					// 保护输入的数据
					do {
						select = scanner.nextInt();
					} while (select < 1 || select > tasklist.size());
					if (select == tasklist.size()) {
						System.out.println("下载结束");
						return;
					}
					// 将选中文件从tasklist删除添加到task中
					tasks.add(tasklist.remove(select - 1));
					// 通知下载线程开始下载
					synchronized (downLoadTask) {
						downLoadTask.notify();
					}
				}
			}

			// 显示下载列表
			private void showTaskList() {
				for (int i = 0; i < tasklist.size(); i++) {
					System.out.println(i + 1 + "-" + tasklist.get(i));
				}
			}
		};
		ctrlThread.setDaemon(true);
		ctrlThread.start();

	}

	private static void initTasklist() {
		tasklist.add("爱情公寓4.FLV");
		tasklist.add("Office2003.rar");
		tasklist.add("javaapi.zip");
		tasklist.add("apache-tomcat.rar");
		tasklist.add("退出");
	}

	// 复制文件的线程类
	static class DownLoadTask extends Thread {
		@Override
		public void run() {
			while (true) {
				// 判断是否有当前下载任务
				while (!tasks.isEmpty()) {
					download(tasks.remove(0)); // 进行下载第一个任务
				}
				// 使本线程进入等待状态
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// 复制文件方法
	private static void download(String fileName) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File srcFile = new File(SRC_PATH, fileName);
		if (!srcFile.exists()) {
			System.out.println("文件不存在");
			return;
		}
		File destFile = new File(DEST_PATH, fileName);

		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			// 创建缓冲数组
			byte[] buffer = new byte[1024];
			int len;
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
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
