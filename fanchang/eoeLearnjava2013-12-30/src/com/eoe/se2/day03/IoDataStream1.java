package com.eoe.se2.day03;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IoDataStream1 {

	/**
	 * DataInputStream类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("D:/java_test/se2_day03");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test.dat");
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			int data = dis.readInt();
			System.out.println(data);
			String data1 = dis.readUTF();
			System.out.println(data1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
