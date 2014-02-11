package com.eoe.se2.day06.download1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DownLoadServer {

	/**
	 * 下载的服务端
	 * 
	 * @param args
	 */
	private static final String SRC_PATH = "d:/java_test/";

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Socket socket = null;

		System.out.println("等待客户连接...");
		try {
			ServerSocket server = new ServerSocket(9988);
			socket = server.accept();
			// 创建对象输入流
			ois = new ObjectInputStream(socket.getInputStream());
			// 获取客户端发送的下载文件名,该文件名封装在info对象中
			FileInfo info = (FileInfo) ois.readObject();
			// 创建文件输入流
			fis = new FileInputStream(SRC_PATH + info.getFileName());
			OutputStream out = socket.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
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
