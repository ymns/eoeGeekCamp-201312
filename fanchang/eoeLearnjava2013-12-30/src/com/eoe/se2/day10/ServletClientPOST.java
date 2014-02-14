package com.eoe.se2.day10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.eoe.se2.day10.entity.User;

public class ServletClientPOST {

	/**
	 * @param args
	 */
	private static final String BASE_URL = "http://localhost:8080/se2_day10_2/ServletTest";

	public static void main(String[] args) {
		HttpURLConnection conn = null;
		StringBuilder sb = new StringBuilder();
		sb.append("name=").append("刘亦菲").append("&password=").append(1234);
		ObjectInputStream ois = null;
		try {
			// 将登陆信息序列化(按utf-8)
			byte[] data = sb.toString().getBytes("utf-8");
			URL url = new URL(BASE_URL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(3000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-length", data.length + "");
			OutputStream out = conn.getOutputStream();
			out.write(data);
			if (conn.getResponseCode() == 200) {
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
