package com.eoe.se2.day07.download;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DownloadClient2 {

	/**
	 * @param args
	 */
	private static final String DEST_PATH = "d:/java_test/se2_day07/";
	private static final String FILE_NAME = "eclipse.zip";
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
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 6666);
			oos = new ObjectOutputStream(socket.getOutputStream());
			// 读取断点位置
			long position = readPosition();
			FileInfo info = new FileInfo(FILE_NAME, position);
			oos.writeObject(info);
			raf = new RandomAccessFile(DEST_PATH + info.getFileName(), "rw");
			byte[] buffer = new byte[1024];
			int len;
			InputStream in = socket.getInputStream();
			// 定位到读取的断点位置
			raf.seek(position);
			System.out.println(info.getFileName() + "下载中...");
			while ((len = in.read(buffer)) != -1 && isContinue) {
				raf.write(buffer, 0, len);
				position += len;
			}
			// 保存断点位置
			if (isContinue) {
				System.out.println(info.getFileName() + "下载完成");
				position = 0;
			} else {
				System.out.println(info.getFileName() + "下载被终止");
			}
			savePosition(position);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (raf != null) {
					raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 保存断点位置
	private static void savePosition(long position) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(DEST_PATH
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
	private static long readPosition() {
		long position = 0;
		DataInputStream dis = null;
		File file = new File(DEST_PATH + RECORD_FILENAME);
		if (!file.exists()) {
			return 0;
		}
		try {
			dis = new DataInputStream(new FileInputStream(DEST_PATH
					+ RECORD_FILENAME));
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
