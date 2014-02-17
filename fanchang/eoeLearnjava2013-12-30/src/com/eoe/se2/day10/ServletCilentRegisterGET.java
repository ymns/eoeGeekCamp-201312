package com.eoe.se2.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ServletCilentRegisterGET {
	/**
	 * 客户端,用于注册信息
	 * 
	 * @param args
	 */
	private static final String BASE_URL = "http://localhost:8080/se2_day10_3/ServletServer";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		// 向服务器提交信息
		try {
			sb.append("?id=").append(1024).append("&name=")
					.append(URLEncoder.encode("荒废胡", "utf-8"))
					.append("&password=").append("123456").append("&email=")
					.append("wangfh@qq.com").append("&phone=")
					.append("12325691245");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(BASE_URL + sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setReadTimeout(3000);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {
				// 接受来自服务端的反馈信息
				reader = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				System.out.println(conn.getResponseMessage());
				System.out.println(reader.readLine());
			} else {
				System.out.println("连接失败");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
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
