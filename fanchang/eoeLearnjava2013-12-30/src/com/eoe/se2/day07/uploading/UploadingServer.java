package com.eoe.se2.day07.uploading;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UploadingServer {

	/**
	 * 服务端接受客户端上传的文件
	 * 
	 * @param args
	 */
	private static final String DEST_PATH = "d:/java_test/se2_day07/";

	public static void main(String[] args) {
		ExecutorService pools = Executors.newCachedThreadPool();
		try {
			ServerSocket server = new ServerSocket(6666);
			System.out.println("客户端连接...");
			while (true) {
				Socket socket = server.accept();
				pools.execute(new UploadTask(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 上传文件的线程类
	static class UploadTask implements Runnable {

		Socket socket;

		public UploadTask(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			ObjectInputStream ois = null;
			RandomAccessFile raf = null;

			try {
				// 创建对象输入流
				ois = new ObjectInputStream(socket.getInputStream());
				// 获得封装了文件名和位置
				FileInfo info = (FileInfo) ois.readObject();
				raf = new RandomAccessFile(DEST_PATH + info.getFileName(), "rw");
				byte[] buffer = new byte[1024];
				int len;
				InputStream in = socket.getInputStream();
				// 定位到上次的位置
				raf.seek(info.getPosition());
				while ((len = in.read(buffer)) != -1) {
					raf.write(buffer, 0, len);
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (raf != null) {
						raf.close();
					}
					if (ois != null) {
						ois.close();
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

}
