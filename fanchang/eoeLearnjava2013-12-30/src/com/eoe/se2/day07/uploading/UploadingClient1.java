package com.eoe.se2.day07.uploading;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UploadingClient1 {

	/**
	 * 客户端向服务端上传文件
	 * 
	 * @param args
	 */
	private static final String SRC_PATH = "d:/java_test/";
	private static final String FILENAME = "eclipse.zip";
	// 记录文件声明
	private static final String RECORD_FILENAME = "eclipse_record.dat";
	private static boolean isContinue = true;// 是否继续上传

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("按任意键停止文件上传");
				new Scanner(System.in).next();
				isContinue = false;
				
			};
		}.start();
		ObjectOutputStream oos = null;
		RandomAccessFile raf = null;

		try {
			Socket socket = new Socket("127.0.0.1", 6666);
			// 读取断点位置
			long position = readPosition();
			oos = new ObjectOutputStream(socket.getOutputStream());
			FileInfo info = new FileInfo(FILENAME, position);
			// 上传封装了文件名和断点位置的info对象
			oos.writeObject(info);
			raf = new RandomAccessFile(SRC_PATH + info.getFileName(), "rw");
			byte[] buffer = new byte[1024];
			int len;
			// 定位断点位置
			raf.seek(position);
			OutputStream out = socket.getOutputStream();
			System.out.println(FILENAME + "开始上传");
			while ((len = raf.read(buffer)) != -1 && isContinue) {// isContinue为false
				out.write(buffer, 0, len);
				position += len;
			}
			position = isContinue ? 0 : position;
			// 保存断点
			savePosition(position);
			if (isContinue) {
				System.out.println(FILENAME + "上传结束");
			} else {
				System.out.println(FILENAME + "上传被终止");
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 保存断点位置
	static void savePosition(long position) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(SRC_PATH
					+ RECORD_FILENAME));
			dos.writeLong(position);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 读取断点位置
	static long readPosition() {
		long position = 0;
		DataInputStream dis = null;
		File file = new File(SRC_PATH + RECORD_FILENAME);
		if (!file.exists()) {
			return 0;
		}
		try {
			dis = new DataInputStream(new FileInputStream(file));
			dis.readLong();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return position;
	}
}
