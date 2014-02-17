package com.eoe.se2.day11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class DownloadHttpClient {

	/**
	 * 使用HttpClient下载文件
	 * 
	 * @param args
	 */
	static final String BASE_URL = "http://127.0.0.1/eclipse.zip";
	static final String DEST_PATH = "d://java_test/se2_day11/";
	static final String FILENAME = "eclipse.zip";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(BASE_URL);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(DEST_PATH + FILENAME);
			HttpResponse response = client.execute(get);
			InputStream in = response.getEntity().getContent();
			int len;
			byte[] buffer = new byte[1024 * 10];
			long start = System.currentTimeMillis();
			System.out.println(FILENAME + "开始下载");
			while ((len = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len);

			}
			long end = System.currentTimeMillis();
			System.out.println(end - start + "ms");
			System.out.println(FILENAME + "下载结束");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
