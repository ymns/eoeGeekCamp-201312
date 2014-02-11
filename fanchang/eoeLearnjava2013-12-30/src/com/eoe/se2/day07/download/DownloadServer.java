package com.eoe.se2.day07.download;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadServer {

	/**
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
				pools.execute(new DownloadTask(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 下载任务进程类
	static class DownloadTask implements Runnable {
		Socket socket;

		public DownloadTask(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			ObjectInputStream ois = null;
			RandomAccessFile raf = null;

			try {
				ois = new ObjectInputStream(socket.getInputStream());
				FileInfo info = (FileInfo) ois.readObject();
				raf = new RandomAccessFile(SRC_PATH + info.getFileName(), "rw");
				raf.seek(info.getPosition());
				byte[] buffer = new byte[1024];
				int len;
				OutputStream out = socket.getOutputStream();
				
				while ((len = raf.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ois != null) {
						ois.close();
					}
					if (raf != null) {
						raf.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
