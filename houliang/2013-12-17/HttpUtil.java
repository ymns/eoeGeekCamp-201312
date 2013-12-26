package com.eoe.myjava.xml;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	public static InputStream getXML(String path){
		InputStream inputStream=null;
		try {
			URL url=new URL(path);
			if(url!=null){
				HttpURLConnection connection=(HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(3000);//设置连接超时时间
				connection.setDoInput(true);//设置
				connection.setRequestMethod("GET");
				int code=connection.getResponseCode();
				if(code==200){
					inputStream=connection.getInputStream();
				}
				
			}
			return inputStream;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}

}
