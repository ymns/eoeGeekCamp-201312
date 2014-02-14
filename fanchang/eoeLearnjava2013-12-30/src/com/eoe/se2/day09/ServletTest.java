package com.eoe.se2.day09;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ServletTest {

	/**
	 * @param args
	 */
	private static final String BASE_URL = "http://localhost:8080/se2_day09/haa";

	public static void main(String[] args) {
		HttpURLConnection conn = null;

		try {
			URL url = new URL(BASE_URL);
			conn = (HttpURLConnection) url.openConnection();
			InputStream in = conn.getInputStream();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(3000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			if (conn.getResponseCode() == 200) {
				System.out.println(conn.getResponseMessage());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

	}

}
