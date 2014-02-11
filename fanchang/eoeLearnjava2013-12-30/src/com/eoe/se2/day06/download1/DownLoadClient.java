package com.eoe.se2.day06.download1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DownLoadClient {

	/**
	 * @param args
	 */
	private static final String DEST_PATH = "d:/java_test/se2_day06/";
	private static final String FILE_NAME = "eclipse.zip";

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 9988);
			oos = new ObjectOutputStream(socket.getOutputStream());
			// 创建info对象
			FileInfo info = new FileInfo(FILE_NAME, 0);
			// 向服务端发送封装了文件名的info对象
			oos.writeObject(info);
			fos = new FileOutputStream(DEST_PATH + info.getFileName());
			byte[] buffer = new byte[1024];
			int len;
			InputStream in = socket.getInputStream();
			System.out.println(FILE_NAME + "\t文件开始下载...");
			while ((len = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			System.out.println(FILE_NAME + "下载结束");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
