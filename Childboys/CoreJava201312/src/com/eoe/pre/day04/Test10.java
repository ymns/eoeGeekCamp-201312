package com.eoe.pre.day04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream in=null;
		FileOutputStream fos=null;
		//步骤1、创建URL对象
		try {
			URL url=new URL("http://127.0.0.1/users.xml");
			//步骤2、创建URLConnection对象
			URLConnection connection=url.openConnection();
			//步骤3、连接服务端，获取InputStream对象
			in=connection.getInputStream();
			//步骤4、创建FileOuputStream对象
			fos=new FileOutputStream("f:/java_test/dest/users.xml");
			byte[] buffer=new byte[1024];
			int len;
			while((len=in.read(buffer))!=-1){
				fos.write(buffer,0,len);
			}
			System.out.println("下载成功!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(in!=null){
					in.close();
				}
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
