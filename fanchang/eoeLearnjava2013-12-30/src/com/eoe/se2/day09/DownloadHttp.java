package com.eoe.se2.day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.eoe.se2.day07.download1.Record;

public class DownloadHttp {

	/**
	 * 用http编程实现文件的分块下载
	 * 
	 * @param args
	 */
	private static final String DEST_PATH = "D:/java_test/se2_day09/";
	private static final String BASE_URL = "http://127.0.0.1/";
	private static final String FILENAME = "eclipse.zip";
	private static final String RECORD_FILENAME = "record.dat";
	private static int THREAD_COUNT = 3;
	private static boolean isContinue = true;
	private static Record[] records;
	private static int BUF_SIZE = 1024;

	public static void main(String[] args) {
		final ExecutorService pool = Executors
				.newFixedThreadPool(THREAD_COUNT + 1);
		pool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("按任意键停止下载");
				new Scanner(System.in).next();
				isContinue = false;
				pool.shutdown();
			}
		});
		// 若没有断点记录
		if (!readRecord()) {
			// 从服务端获取文件长度
			long fileSize = requestFileSize();
			// 计算每块数据的长度
			long blockSize = fileSize / THREAD_COUNT;
			for (int i = 0; i < records.length; i++) {
				records[i] = new Record();
				records[i].setFileName(FILENAME);
				records[i].setStartPos(i * blockSize);
				records[i].setEndPos((i + 1) * blockSize - 1);
			}
			// 设置最后一块的结束位置是文件的总长度
			records[records.length - 1].setEndPos(fileSize - 1);
		}
		// 依次启动块的下载
		for (int i = 0; i < records.length; i++) {
			pool.execute(new DownloadTask(i));
		}
	}

	// 下载文件的进程
	static class DownloadTask implements Runnable {
		int Threadi;

		public DownloadTask(int threadi) {
			Threadi = threadi;
		}

		@Override
		public void run() {
			RandomAccessFile raf = null;
			HttpURLConnection connection = null;
			try {
				URL url = new URL(BASE_URL + FILENAME);
				connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(5000);
				connection.setRequestMethod("GET");
				connection.setReadTimeout(5000);
				connection.setDoInput(true);
				// 获取本块的位置
				long start = records[Threadi].getStartPos();
				long end = records[Threadi].getEndPos();
				// 设置下载的位置
				connection.setRequestProperty("Range", "bytes=" + start + "-"
						+ end);
				InputStream in = connection.getInputStream();
				int responseCode = connection.getResponseCode();
				// 判断服务器响应的状态码
				if (responseCode != 200 && responseCode != 206) {
					System.out.println(connection.getResponseMessage());
					return;
				}
				raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
				raf.seek(start);
				byte[] buffer = new byte[BUF_SIZE];
				int len;
				while (start < end && isContinue) {
					len = in.read(buffer);
					raf.write(buffer, 0, len);
					start += len;
					records[Threadi].setStartPos(start);
				}
				// 如果下载完成
				if (isContinue) {
					System.out.println("第" + (Threadi + 1) + "文件下载完成");
				} else {
					// 保存断点
					saveRecord();
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (raf != null) {
					try {
						raf.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (connection != null) {
					connection.disconnect();
				}
				int count = 0;
				for (Record record : records) {
					if (record.getStartPos() >= record.getEndPos()) {
						count++;
					}
				}
				if (count == THREAD_COUNT) {
					System.out.println(FILENAME + "下载完成");
					File file = new File(DEST_PATH + RECORD_FILENAME);
					if (file.exists()) {
						file.delete();
					}
				}
			}
		}

	}

	// 向服务器请求与返回文件长度
	static long requestFileSize() {
		HttpURLConnection connection = null;
		try {
			// 创建url对象
			URL url = new URL(BASE_URL + FILENAME);
			// 根据url地址类型获取HttpURLConnection对象
			connection = (HttpURLConnection) url.openConnection();
			// 设置连接服务器时间限制
			connection.setConnectTimeout(5000);
			// 设置读取服务器时间限制
			connection.setReadTimeout(5000);
			// 设置请求方式:get
			connection.setRequestMethod("GET");
			// 设置接收服务器数据
			connection.setDoInput(true);
			// 向服务器发送接收请求,成功则获得输入流
			InputStream in = connection.getInputStream();
			// 判断服务器响应的状态码
			if (connection.getResponseCode() != 200) {
				System.out.println(connection.getResponseMessage());
				return 0;// 成功则返回0
			}
			// 返回文件的长度
			long fileSize = connection.getContentLength();
			return fileSize;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return 0;
	}

	// 保存断点位置,保存在records数组里
	static void saveRecord() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(DEST_PATH
					+ RECORD_FILENAME));

			oos.writeObject(records);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 读取断点位置
	static boolean readRecord() {
		ObjectInputStream ois = null;
		File file = new File(DEST_PATH + RECORD_FILENAME);
		// 若断点文件不存在
		if (!file.exists()) {
			// 创建每块记录断点的数组
			records = new Record[THREAD_COUNT];
			return false;
		}
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			// 若文件存在读取断点文件
			records = (Record[]) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
