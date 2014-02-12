package com.eoe.se2.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpTest {

	/**
	 * 从HFS服务端下载user.txt文件，并显示该文件内容。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			// 创建服务端地址的对象
			URL url = new URL("http://127.0.0.1:80/user.txt");
			// 获取URLConnection对象
			URLConnection connection = url.openConnection();
			// 向服务端发出请求,获得指定文件输入流
			InputStream in = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in, "gbk"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
