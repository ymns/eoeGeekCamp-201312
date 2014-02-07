package com.eoe.se2.day03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoBufferStream {

	/**
	 * 使用BufferedInputStream和BufferedOutputStream 实现文件的复制
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			FileInputStream fis = new FileInputStream("D:/java_test/apache-tomcat.rar");
			bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream(
					"D:/java_test/se2_day03/apache-tomcat.rar");
			byte[] buffer=new byte[1024*10];
			bos=new BufferedOutputStream(fos);
			int len;//每次读取字节数
			while((len=fis.read(buffer))!=-1){
				fos.write(buffer,0,len);
			}
			System.out.println("文件复制完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
