package com.eoe.pre.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//源文件的路径
		String src="f:/java_test/src/cocos2d_x.zip";
		//目标文件的路径
		String dest="f:/java_test/dest/cocos2d_x.zip";
		FileInputStream fis=null;
		FileOutputStream fos=null;
		//alt+shift+z
		try {
			fis=new FileInputStream(src);
			fos=new FileOutputStream(dest);
			byte[] buffer=new byte[1024*100];
			int len;
			//计算文件复制开始的系统时间
			long start=System.currentTimeMillis();
			while((len=fis.read(buffer))!=-1){
				fos.write(buffer, 0, len);
			}
			//计算文件复制结束的系统时间
			long end=System.currentTimeMillis();
			System.out.println("cost time="+(end-start)/1000+"秒");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(fis!=null){
					fis.close();
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
