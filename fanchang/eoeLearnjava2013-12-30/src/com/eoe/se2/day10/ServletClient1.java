package com.eoe.se2.day10;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ServletClient1 {

	/**
	 * GET方式提交
	 * 
	 * @param args
	 */
	private static final String BASE_URL = "http://localhost:8080/se2_day10/Servlet1";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		HttpURLConnection conn = null;

		try {
			sb.append("?name=").append(URLEncoder.encode("张飞", "utf-8"));
			URL url = new URL(BASE_URL + sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			InputStream in = conn.getInputStream();
			if (conn.getResponseCode() == 200) {
				System.out.println(conn.getResponseMessage());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				conn.disconnect();
			}
		}
	}
}
