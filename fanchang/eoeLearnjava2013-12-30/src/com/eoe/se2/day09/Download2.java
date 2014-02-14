package com.eoe.se2.day09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Download2 {

	/**
	 * 从HFS服务器读取eclipse.zip文件并下载 加入断点续传功能
	 * 
	 * @param args
	 */
	private static final String BASE_URL = "http://127.0.0.1/";
	private static final String DEST_PATH = "D:/java_test/se2_day09/";
	private static final String FILENAME = "eclipse.zip";
	private static final String RECORD = "record.dat";
	private static boolean isContinue = true;

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("按任意键停止下载");
				new Scanner(System.in).next();
				isContinue = false;
			};
		}.start();
		RandomAccessFile raf = null;
		HttpURLConnection conn = null;

		try {
			URL url = new URL(BASE_URL + FILENAME);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			// 读取断点位置
			long position = readPosition();
			conn.setRequestProperty("Range", "bytes=" + position);
			InputStream in = conn.getInputStream();
			raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
			raf.seek(position);
			byte[] buffer = new byte[1024];
			int len;
			System.out.println(FILENAME + "开始下载");
			while ((len = in.read(buffer)) != -1 && isContinue) {
				raf.write(buffer, 0, len);
				position += len;
			}
			if (!isContinue) {
				savePosition(position);
				System.out.println(FILENAME + "下载被停止");
			} else {
				System.out.println(FILENAME + "下载完成");
				File file = new File(DEST_PATH + RECORD);
				if (file.exists()) {
					file.delete();
				}
				System.exit(0);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
				if (conn != null) {
					conn.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 读取断点位置
	static long readPosition() {
		DataInputStream dis = null;
		long position = 0;
		File file = new File(DEST_PATH + RECORD);
		if (!file.exists()) {
			return 0;
		}
		try {
			dis = new DataInputStream(new FileInputStream(file));
			position = dis.readLong();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return position;
	}

	// 保存断点位置
	static void savePosition(long position) {
		DataOutputStream dos = null;

		try {
			dos = new DataOutputStream(new FileOutputStream(DEST_PATH + RECORD));
			dos.writeLong(position);
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
}
