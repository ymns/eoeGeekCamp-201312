package com.eoe.se2.day03;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDataStream {

	/**
	 * DataOutputStream类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("D:/java_test/se2_day03");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test.dat");
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("创建文件");
			}
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			dos.writeInt(255);
			dos.writeUTF("张飞");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
