package com.eoe.se2.day11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class UploadingHttpClient {

	/**
	 * @param args
	 */
	static final String BASE_URL = "http://localhost:8080/se2_day11/ServletServer";
	static final String SRC_PATH = "D:/java_test/";
	static final String FILENAME = "eclipse.zip";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_URL);
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("fileName", FILENAME));
		InputStream in = null;
		InputStreamEntity ise = null;
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,
					"utf-8");
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("服务器连接失败");
				return;
			}
			// 终止本次连接
			post.abort();
			in = new FileInputStream(SRC_PATH + FILENAME);
			ise = new InputStreamEntity(in, in.available());
			post.setEntity(ise);
			client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}
	}
}
