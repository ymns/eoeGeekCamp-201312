package com.eoe.se2.day11;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClient_GET1 {

	/**
	 * HttpClient案例1
	 * 
	 * @param args
	 */
	static final String URI = "http://localhost:8080/se2_day09/haa?name=张飞&age=35";

	public static void main(String[] args) {
		// 创建客户端
		HttpClient client = new DefaultHttpClient();
		// 创建客户端提交方式
		HttpGet get = new HttpGet(URI);
		try {
			// 以get方式启动客户端,返回一个HttpResponse类型的值,对象存放服务器响应的内容,并实例化
			HttpResponse response = client.execute(get);
			// 获取服务器响应的状态码
			System.out.println(response.getStatusLine().getStatusCode());
			// 获取服务器返回的结果
			System.out.println(response.getStatusLine().getReasonPhrase());
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
