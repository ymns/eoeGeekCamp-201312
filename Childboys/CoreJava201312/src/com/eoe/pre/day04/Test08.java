package com.eoe.pre.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName="F:/java_test/user.txt";
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(fileName);
			byte[] buffer=new byte[100];
			int len;//保存读取的字节数
			while((len=fis.read(buffer))!=-1){
				String s=new String(buffer);
				System.out.print(s);
			}
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
