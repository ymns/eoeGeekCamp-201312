package com.eoe.se2.day04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class IoDownLoad1 {

	/**
	 * 文件的断点续传
	 * 
	 * @param args
	 */
	// 声明路径的常量
	private static final String SRC_PATH = "d:/java_test/";
	private static final String DEST_PATH = "d:/java_test/se2_day04/";
	// 被操作的文件名
	private static final String FILE_NAME = "Office2003.rar";
	// 保存断点位置的文件
	static final String RECORD_FILENAME = "record.data";

	// 枚举文件的状态
	enum Action {
		READY, // 准备下载
		DOWNING, // 下载中
		STOP;// 停止下载
	}

	// 定义枚举引用变量,表示下载的状态
	static Action action;

	public static void main(String[] args) {
		// 设置准备状态
		action = Action.READY;
		// 创建下载线程对象
		final DownLoadTask downLoadTask = new DownLoadTask();
		// 启动下载线程
		downLoadTask.start();
		// 创建用于选择的线程
		Thread ctrlThread = new Thread() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (true) {
					System.out.println("1-开始下载\t2-停止下载");
					int select = scanner.nextInt();
					// 返回枚举类对象数组
					action = Action.values()[select];
					// 唤醒下载线程
					synchronized (downLoadTask) {
						downLoadTask.notify();
					}
				}
			}
		};
		ctrlThread.setDaemon(true);// 设置成后台守护线程
		ctrlThread.start();// 启动用于选择的线程
	}

	// 下载文件线程
	static class DownLoadTask extends Thread {
		@Override
		public void run() {
			// 如果是准备状态则进入设置该线程进入等待状态
			if (action == Action.READY) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			// 设置成下载中状态
			action = Action.DOWNING;
			// 从记录文件中读取上次保存的断点位置
			long pos = readLocation();
			RandomAccessFile srcRaf = null;
			RandomAccessFile destRaf = null;

			// 源文件路径
			try {
				srcRaf = new RandomAccessFile(SRC_PATH + FILE_NAME, "r");
				// 目标文件路径
				destRaf = new RandomAccessFile(DEST_PATH + FILE_NAME, "rw");
				srcRaf.seek(pos);
				destRaf.seek(pos);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = srcRaf.read(buffer)) != -1
						&& action == Action.DOWNING) {
					destRaf.write(buffer, 0, len);
					pos += len;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (srcRaf != null) {
						srcRaf.close();
					}
					if (destRaf != null) {
						destRaf.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (action == Action.DOWNING) { // 正常下载完毕
				pos = 0;
				// 保存断点位置为0
				saveLocation(pos);
				System.out.println("文件下载完毕");
			} else {
				System.out.println("下载被终止");
				// 下载不了则 保存当前断点位置
				saveLocation(pos);
			}

		}
	}

	// 保存断点位置
	public static void saveLocation(long pos) {
		DataOutputStream dos = null;

		try {
			File file = new File(SRC_PATH, RECORD_FILENAME);
			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeLong(pos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 从记录文件中读取上次保存的断点位置
	static public long readLocation() {
		long pos = 0;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		// 查找记录文件
		File file = new File(SRC_PATH, RECORD_FILENAME);
		try {
			if (!file.exists()) {
				file.createNewFile();
				dos = new DataOutputStream(new FileOutputStream(file));
				dos.writeLong(0);
			} else {
				dis = new DataInputStream(new FileInputStream(file));
				pos = dis.readLong();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pos;
	}

}
