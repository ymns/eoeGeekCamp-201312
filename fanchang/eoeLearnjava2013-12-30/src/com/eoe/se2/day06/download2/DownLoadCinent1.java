package com.eoe.se2.day06.download2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DownLoadCinent1 {

	/**
	 * 客户端1请求下载文件
	 * 
	 * @param args
	 */
	private static final String DEST_PATH = "d:/java_test/se2_day06/";
	private static final String FILE_NAME = "eclipse.zip";

	public static void main(String[] args) {
		Socket socket = null;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			socket = new Socket("127.0.0.1", 6666);
			// 创建对象流
			oos = new ObjectOutputStream(socket.getOutputStream());
			FileInfo info = new FileInfo(FILE_NAME, 0);
			// 写入对象info,文件名
			oos.writeObject(info);
			fos = new FileOutputStream(DEST_PATH + info.getFileName());
			byte[] buffer = new byte[1024];
			int len;
			InputStream in = socket.getInputStream();
			while ((len = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
