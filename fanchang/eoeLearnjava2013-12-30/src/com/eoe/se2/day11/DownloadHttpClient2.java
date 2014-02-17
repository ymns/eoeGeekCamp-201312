package com.eoe.se2.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

import com.eoe.se2.day07.download1.Record;

public class DownloadHttpClient2 {

	/**
	 * 用分段下载的方式下载hfs上的文件
	 * 
	 * @param args
	 */
	static final String BASE_URL = "http://127.0.0.1/eclipse.zip";
	static final String DEST_PATH = "d://java_test/se2_day11/";
	static final String FILENAME = "eclipse.zip";
	static final String RECORD_FILENAME = "record.dat";
	static boolean isContiue = true;
	static final int THREAD_COUNT = 3;
	static Record[] records;

	public static void main(String[] args) {

	}

	// 请求服务端返回下载文件长度，计算各块起始、结束位置
	static void repuestServer() {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(BASE_URL);
		try {
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
				long fileSize = response.getEntity().getContentLength();
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 分块下载线程
	static class DownloadTask implements Runnable {
		int threadi;

		public DownloadTask(int threadi) {
			this.threadi = threadi;
		}

		@Override
		public void run() {
			Record record = records[threadi];
			long start = record.getStartPos();
			long end = record.getEndPos();
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(BASE_URL);
			RandomAccessFile raf = null;
			post.addHeader(new BasicHeader("Range", "bytes=" + start + "-"
					+ end));

			try {
				HttpResponse response = client.execute(post);
				InputStream in = response.getEntity().getContent();
				int code = response.getStatusLine().getStatusCode();
				if (code != 200) {
					System.out.println("下载失败");
					return;
				}
				raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
				raf.seek(start);
				int len;
				byte[] buffer = new byte[1024];
				while (start > end && isContiue) {
					len = in.read(buffer);
					raf.write(buffer, 0, len);
					start += len;
					record.setStartPos(start);
				}
				// 保存断点
				saveRecord();

			} catch (ClientProtocolException e) {
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
				if (client != null) {
					client.getConnectionManager().shutdown();
				}
				// 判断是第几块
				int count = 0;
				for (int i = 0; i < records.length; i++) {
					if (records[threadi].getStartPos() >= records[threadi]
							.getEndPos()) {
						count++;
					}
				}
				if (count == THREAD_COUNT) {
					System.out.println(FILENAME + "下载完成");
					File file = new File(DEST_PATH + RECORD_FILENAME);
					if (file.exists()) {
						file.delete();// 删除记录文件
					}
					System.exit(0);
				}
			}
		}

	}

	// 读取记录位置
	static boolean readRecord() {
		ObjectInputStream ois = null;
		try {
			File file = new File(DEST_PATH + RECORD_FILENAME);
			if (!file.exists()) {
				records = new Record[THREAD_COUNT];
				return false;
			}
			ois = new ObjectInputStream(new FileInputStream(file));
			records = (Record[]) ois.readObject();
			return true;
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
		return false;
	}

	// 把records对象数组保存
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
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
