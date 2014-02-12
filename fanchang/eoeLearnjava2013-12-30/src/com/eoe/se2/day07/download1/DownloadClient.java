package com.eoe.se2.day07.download1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadClient {

	/**
	 * 分段下载的客户端
	 * 
	 * @param args
	 */
	private static final String DEST_PATH = "D:/java_test/se2_day07";
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 9999;
	private static final int BUF_SIZE = 1024;
	private static boolean iscontinue = true;
	private static final String FILE_NAME = "eclipse.zip";
	private static final String RECORD_FILENAME = "eclipse_record.dat";
	// 分3块下载文件
	private static final int THREAD_COUNT = 3;
	// 记录每一个块文件的起始和结束的数组
	private static Record[] records;

	public static void main(String[] args) {
		ExecutorService pools = Executors.newFixedThreadPool(THREAD_COUNT + 1);
		// 向线程池中放入用于停止下载的监控线程
		pools.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("按任意键停止下载");
				new Scanner(System.in).next();
				iscontinue = false;
			}
		});
		// 读取断点记录文件
		if (!readRecord()) {// 当没有读到断点记录时
			// 向服务端请求获取文件长度
			requestServer();
		}
		// 开始下载
		for (int i = 0; i < records.length; i++) {
			pools.execute(new DownloadTask(records[i], i));
		}
	}

	// 向服务端请求获取文件长度
	private static void requestServer() {
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			socket = new Socket(HOST, PORT);
			RecordInfo info = new RecordInfo();
			// 设置文件名
			info.getRecord().setFileName(FILE_NAME);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(info);
			ois = new ObjectInputStream(socket.getInputStream());
			info = (RecordInfo) ois.readObject();
			// 计算每一块的长度
			long blockSize = info.getFileSize() / THREAD_COUNT;
			// 计算每一块的起始、结束位置
			for (int i = 0; i < records.length; i++) {
				records[i] = new Record();
				records[i].setFileName(FILE_NAME);
				// 第一块的起始结束位置
				records[i].setStartPos(i * blockSize);
				records[i].setEndPos((i + 1) * blockSize - 1);
				// //第二块的起始结束位置
				// records[i].setStartPos(i*blockSize);
				// records[i].setEndPos((i+1)*blockSize-1);
				// //第三块的起始结束位置
				// records[i].setStartPos(i*blockSize);
				// records[i].setEndPos((i+1)*blockSize-1);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
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

	// 客户端接受服务端下载任务线程
	static class DownloadTask implements Runnable {
		Record record;
		int threadi;// 块的索引值，线程的索引值

		public DownloadTask(Record record, int threadi) {
			this.record = record;
			this.threadi = threadi;
		}

		@Override
		public void run() {
			ObjectOutputStream oos = null;
			RandomAccessFile raf = null;
			Socket socket = null;

			// 向服务端发送下载文件的请求
			try {
				socket = new Socket(HOST, PORT);
				oos = new ObjectOutputStream(socket.getOutputStream());
				RecordInfo info = new RecordInfo();
				// 将本块的起始结束位置等信息保存在info对写的中
				info.setRecord(record);
				// 设置请求类型为下载
				info.setRequestType("download");
				// 向服务端发送请求下载的信息,info对象
				oos.writeObject(info);
				raf = new RandomAccessFile(DEST_PATH
						+ FILE_NAME, " rw");
				// 获取本块数据的开始、结束位置
				long start = record.getStartPos();
				long end = record.getEndPos();
				raf.seek(start);
				byte[] buffer = new byte[BUF_SIZE];
				int len;
				InputStream in = socket.getInputStream();
				while (start < end && iscontinue) {
					len = in.read(buffer);
					raf.write(buffer, 0, len);
					start += len;
					record.setStartPos(start);
				}
				saveRecord();// 保存各块下载位置的信息

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
					if (socket != null) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			int count = 0;
			for (Record record : records) {
				if (record.getStartPos() >= record.getEndPos()) {
					count++;
				}
			}
			if (count == THREAD_COUNT) {
				System.out.println(FILE_NAME + "下载完毕");
				File file = new File(DEST_PATH + RECORD_FILENAME);
				if (file.exists()) {
					file.delete();// 删除文件呀
					System.exit(0);
				}
			}
		}
	}

	// 读取断点记录
	static boolean readRecord() {
		ObjectInputStream ois = null;
		File file = new File(DEST_PATH + RECORD_FILENAME);
		// 若记录文件不存在
		if (!file.exists()) {
			// 创建记录数组，并退出本方法
			records = new Record[THREAD_COUNT];
			return false;
		}
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			// 读取断点信息
			records = (Record[]) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 保存断点记录
	public static void saveRecord() {
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
}
