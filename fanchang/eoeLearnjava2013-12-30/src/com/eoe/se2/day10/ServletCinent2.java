package com.eoe.se2.day10;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServletCinent2 {

	/**
	 * Post方式提交
	 * 
	 * @param args
	 */
	private static final String BASE_URL = "http://localhost:8080/se2_day10/Servlet1";

	public static void main(String[] args) {
		HttpURLConnection conn = null;
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("name=").append("张飞").append("&age=").append(35);
			// 将字符串按utf-8序列化为字节数组
			byte[] data = sb.toString().getBytes("utf-8");
			URL url = new URL(BASE_URL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-length", data.length + "");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.getOutputStream().write(data);
			if (conn.getResponseCode() == 200) {
				System.out.println(conn.getResponseMessage());
				System.out.println("发送数据成功!");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
