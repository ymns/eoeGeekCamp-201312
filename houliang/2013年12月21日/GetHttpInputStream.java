package com.study.download;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetHttpInputStream {
	private URL url;
	public GetHttpInputStream(URL url) {
		this.url = url;
	}
	public InputStream getInputStream() throws Exception {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setReadTimeout(3000);
		connection.setConnectTimeout(4000);
		int code = connection.getResponseCode();
		if (code == 200) {
			InputStream in = connection.getInputStream();
			return in;
		} 
		else {
			throw new Exception("连接失败");
		}
	}

}
