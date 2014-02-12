package com.eoe.se2.day07.download1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadServer {
	/**
	 * 分段下载的服务端
	 * 
	 * @param args
	 */
	// 定义常量
	private static final String SRC_PATH = "d:/java_test/";
	private static final int PORT = 9999;
	// 定义一个缓冲字节
	static final int BUF_SIZE = 1024;

	public static void main(String[] args) {
		// 创建线程池,数量是当前计算机的核心数*50
		ExecutorService pools = Executors.newFixedThreadPool(Runtime
				.getRuntime().availableProcessors() * 50);
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("等待客户端连接...");
			System.out.println("发送要下载的文件名...");
			while (true) {
				Socket socket = server.accept();
				// 响应客户端
				Record record = responseClient(socket);
				// 若record非空，即客户端发送的是下载请求
				if (record != null) {
					// 创建一个下载任务，放入线程池中执行
					pools.execute(new DownloadTask(socket, record));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 响应客户端发送的请求，请求分两种： 1.获取文件名。responseClient返回null
	 * 2.请求下载。responseClient返回客户端发送的record对象
	 */
	private static Record responseClient(Socket socket) throws IOException,
			ClassNotFoundException {
		ObjectInputStream ois = null;
		ois = new ObjectInputStream(socket.getInputStream());
		// 读取客户端发送的RecordInfo对象
		RecordInfo info = (RecordInfo) ois.readObject();
		if ("download".equals(info.getRequestType())) {
			return info.getRecord();
		}
		// 处理客户端请求获取文件长度
		if ("filename".equals(info.getRequestType())) {
			FileInputStream fis = new FileInputStream(SRC_PATH
					+ info.getRecord().getFileName());
			// 获取文件长度
			int fileSize = fis.available();
			// 保存在info对象中
			info.setFileSize(fileSize);
			// 创建对象输出流
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			// 将包含文件长度的info对象发送给客户端
			oos.writeObject(info);
		}
		return null;
	}

	// 创建一个下载任务类
	static class DownloadTask implements Runnable {
		Socket socket;
		Record record; // 记录断点和文件名

		public DownloadTask(Socket socket, Record record) {
			this.socket = socket;
			this.record = record;

		}

		@Override
		public void run() {
			RandomAccessFile raf = null;
			// 获得客户端传来的数据
			try {
				OutputStream out = socket.getOutputStream();
				raf = new RandomAccessFile(SRC_PATH + record.getFileName(), "r");
				// 获取本块下载的起始位置
				long start = record.getStartPos();
				// 获取本块下载结束的位置
				long end = record.getEndPos();
				// 定位到开始的位置
				raf.seek(start);
				byte[] buffer = new byte[BUF_SIZE];
				int len;
				while ((len = raf.read(buffer)) != -1 && start < end) {
					out.write(buffer, 0, len);
					start += len;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
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
