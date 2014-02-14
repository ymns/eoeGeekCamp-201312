package com.eoe.se2.day09;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Download1 {

	/**
	 * 从HFS服务器读取eclipse.zip文件并下载
	 * 
	 * @param args
	 */
	private static final String BASE_URL = "http://127.0.0.1/";
	private static final String DEST_PATH = "D:/java_test/se2_day09/";
	private static final String FILENAME = "eclipse.zip";

	public static void main(String[] args) {
		FileOutputStream fos = null;
		HttpURLConnection conn = null;

		try {
			URL url = new URL(BASE_URL + FILENAME);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);
			conn.setDoInput(true);
			conn.setReadTimeout(3000);
			conn.setRequestMethod("GET");

			InputStream in = conn.getInputStream();
			fos = new FileOutputStream(DEST_PATH + FILENAME);
			byte[] buffer = new byte[1024];
			int len;
			System.out.println(FILENAME + "开始下载");
			while ((len = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			System.out.println(FILENAME + "下载完毕");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (conn != null) {
					conn.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
