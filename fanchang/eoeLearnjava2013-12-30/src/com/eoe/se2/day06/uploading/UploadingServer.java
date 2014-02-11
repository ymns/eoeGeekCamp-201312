package com.eoe.se2.day06.uploading;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.eoe.se2.day06.download2.FileInfo;

public class UploadingServer {

	/**
	 * 服务端接受文件
	 * 
	 * @param args
	 */
	private static final String DEST_PATH = "d:/java_test/se2_day06/";

	public static void main(String[] args) {
		ExecutorService pools = Executors.newCachedThreadPool();

		try {
			ServerSocket server = new ServerSocket(5555);
			System.out.println("客户端开始连接...");
			while (true) {
				Socket socket = server.accept();
				pools.execute(new UpLoadTask(socket));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 写一个上传线程类
	static class UpLoadTask implements Runnable {
		Socket socket;

		public UpLoadTask(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			ObjectInputStream oos = null;
			FileOutputStream fos = null;

			try {
				oos = new ObjectInputStream(socket.getInputStream());
				FileInfo info = (FileInfo) oos.readObject();
				fos = new FileOutputStream(DEST_PATH + info.getFileName());
				byte[] buffer = new byte[1024];
				InputStream in = socket.getInputStream();
				int len;
				System.out.println(info.getFileName() + "上传中...");
				while ((len = in.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				System.out.println(info.getFileName() + "上传完毕");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
					if (oos != null) {
						oos.close();
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
