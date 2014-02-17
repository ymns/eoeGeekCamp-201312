package com.eoe.se2.day11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.SeekableByteChannel;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

public class DownloadHttpClient1 {

	/**
	 * 从hfs上下载eclipse.zip,到本地,支持断点续传
	 * 
	 * @param args
	 */
	static final String BASE_URL = "http://127.0.0.1/eclipse.zip";
	static final String DEST_PATH = "d://java_test/se2_day11/";
	static final String FILENAME = "eclipse.zip";
	static final String RECORD_FILENAME = "record.dat";
	static boolean isContiue = true;

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("按任意键停止下载");
				new Scanner(System.in).next();
				isContiue = false;
			};
		}.start();
		long position = readPoistion();
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_URL);
		post.addHeader(new BasicHeader("Range", "bytes=" + position + "-"));
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(DEST_PATH + FILENAME, "rw");
			HttpResponse response = client.execute(post);
			int code = response.getStatusLine().getStatusCode();
			if (code != 200 && code != 206) {
				System.out.println("下载失败");
				return;
			}
			InputStream in = response.getEntity().getContent();
			raf.seek(position);
			int len;
			byte[] buffer = new byte[1024];
			while ((len = in.read(buffer)) != -1 && isContiue) {
				raf.write(buffer, 0, len);
				position += len;
			}
			if (!isContiue) {
				savePosition(position);
			} else {
				System.out.println("文件下载完成");
				File file = new File(DEST_PATH + RECORD_FILENAME);
				if (file.exists()) {
					file.delete();
				}
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
				if (client != null) {
					client.getConnectionManager().shutdown();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 保存断点位置
	static void savePosition(long position) {
		DataOutputStream dos = null;

		try {
			dos = new DataOutputStream(new FileOutputStream(DEST_PATH
					+ RECORD_FILENAME));
			dos.writeLong(position);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 读取断点位置
	static long readPoistion() {
		DataInputStream dis = null;
		File file = new File(DEST_PATH + RECORD_FILENAME);
		if (!file.exists()) {
			return 0;
		}
		try {
			dis = new DataInputStream(new FileInputStream(file));
			dis.readLong();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;

	}
}
