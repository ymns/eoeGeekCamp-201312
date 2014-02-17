package com.eoe.se2.day11;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.eoe.se2.day05.serverTalk1.ClinetTalk2;

public class HttpClientPhone {

	/**
	 * @param args
	 */
	static final String BASE_URL = "http://haoma.imobile.com.cn/index.php";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入查询的手机号:");
		String mobile = scanner.next();
		HttpClient client = new DefaultHttpClient();
		String content = BASE_URL + "?mob=" + mobile;
		HttpUriRequest request = new HttpGet(content);
		try {
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				String msg = EntityUtils.toString(entity);
				System.out.println(msg);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}

	}

}
