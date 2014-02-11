package com.eoe.se2.day06.download2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownLoadServer {

	/**
	 * 服务端响应
	 * 
	 * @param args
	 */
	private static final String SRC_PATH = "d:/java_test/";

	public static void main(String[] args) {
		ExecutorService pools = Executors.newCachedThreadPool();

		try {
			ServerSocket server = new ServerSocket(6666);
			System.out.println("等待客户端的连接...");
			while (true) {
				Socket socket = server.accept();
				pools.execute(new DownLoadTask(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 定义一个下载线程类
	static class DownLoadTask implements Runnable {
		Socket socket;// 从main方法获取的客户端的socket

		public DownLoadTask(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			ObjectInputStream ois = null;
			FileInputStream fis = null;

			try {
				// 创建对象输入流
				ois = new ObjectInputStream(socket.getInputStream());
				// 读取来自客户端的文件,封装在info里
				FileInfo info = (FileInfo) ois.readObject();
				fis = new FileInputStream(SRC_PATH + info.getFileName());
				byte[] buffer = new byte[1024];
				int len;
				OutputStream out = socket.getOutputStream();
				System.out.println(info.getFileName() + "下载中...");
				while ((len = fis.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}
				System.out.println(info.getFileName() + "下载完成");
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
}
