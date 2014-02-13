package com.eoe.se2.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {

	/**
	 * 从HFS服务器读取user.txt文件并在控制台打印该文件内容。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			// 创建url对象
			URL url = new URL("http://127.0.0.1:80/user.txt");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(3000);
			connection.setRequestMethod("GET");
			InputStream in = connection.getInputStream();
			if (connection.getResponseCode() != 200) {
				System.out.println(connection.getResponseMessage());
				return;
			}
			reader = new BufferedReader(new InputStreamReader(in,"gbk"));
			String line;
			byte[] buffer = new byte[1024];
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
