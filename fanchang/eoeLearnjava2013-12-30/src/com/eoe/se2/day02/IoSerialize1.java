package com.eoe.se2.day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IoSerialize1 {

	/**
	 * 反序列化
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:/java_test/se2_day02/java.dat");
			int data = fis.read();
			System.out.println(data);
			data = fis.read();
			System.out.println(data);
			data = fis.read();
			System.out.println(Integer.toHexString(data));
			int data2 = fis.read();
			System.out.println(Integer.toHexString(data2));
			int data3 = data << 8 | data2;
			System.out.println((char) data3 + "\t" + data3);
			System.out.println(Integer.toHexString(data3));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
