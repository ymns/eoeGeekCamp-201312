package com.eoe.se2.day10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.eoe.se2.day10.entity.User;

public class ServletClientGET {

	/**
	 * @param args
	 */
	private static final String BASE_URL = "http://localhost:8080/se2_day10_2/ServletTest";

	public static void main(String[] args) {
		HttpURLConnection conn = null;
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("?name=").append(URLEncoder.encode("刘亦菲", "utf-8"))
					.append("&password=").append(1234);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		ObjectInputStream ois = null;
		try {
			URL url = new URL(BASE_URL + sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(3000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);// 设置读取服务器
			conn.setDoOutput(true);// 设置写入服务器
			if (conn.getResponseCode() == 200) {
				// 接受服务端的user信息
				ois = new ObjectInputStream(conn.getInputStream());
				User user = (User) ois.readObject();
				System.out.println(user);
			} else {
				System.out.println("连接失败");
			}

		} catch (MalformedURLException e) {
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
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
