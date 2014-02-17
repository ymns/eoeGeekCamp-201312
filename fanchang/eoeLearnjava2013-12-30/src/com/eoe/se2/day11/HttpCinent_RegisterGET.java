package com.eoe.se2.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.eoe.se2.day10.entity.User;

public class HttpCinent_RegisterGET {

	/**
	 * HttpGet方式实现注册
	 * 
	 * @param args
	 */
	static final String BASE_URL = "http://localhost:8080/se2_day10_3/ServletServer";

	public static void main(String[] args) {
		// 以默认值得方式创建客户端
		StringBuilder sb = new StringBuilder(BASE_URL);
		sb.append("?name=").append("王大飞").append("&password=").append("12314")
				.append("&id=").append(1025).append("&email=")
				.append("sadf@qq.com").append("&phone=").append("1236254912");
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(sb.toString());
		ObjectInputStream ois = null;
		try {
			HttpResponse response = client.execute(get);
			// 获得响应的实体数据
			HttpEntity entity = response.getEntity();
			// 获得输入流
			InputStream in = entity.getContent();
			ois = new ObjectInputStream(in);
			User user = (User) ois.readObject();
			System.out.println(user);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}

	}
}
