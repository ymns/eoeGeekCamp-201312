package com.study.se2_http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Http_Test {

	public static void main(String[] args) {
			BufferedReader reader = null;
		try {
			URL url = new URL("http://10.0.0.60/test03.dat");
			//获取HttpURLConnection 对象
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			//设置允许接收服务器发送的数据
			connection.setDoInput(true);
			//设置请求方式为GET
			connection.setRequestMethod("GET");
			//设置读取服务器数据超时时间为3秒
			connection.setReadTimeout(3000);
			//获取连接失败时间
			int timeout = connection.getConnectTimeout();
			//设置连接服务器的时间限制
			connection.setConnectTimeout(3000);
			//返回服务器返回状态码
			int code=connection.getResponseCode();
			//打印服务端返回的数据长度
			System.out.println(connection.getContentLength());
			InputStream in=connection.getInputStream();
			reader=new BufferedReader(new InputStreamReader(in,"GBK"));
			String line;
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
