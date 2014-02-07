package com.eoe.se2.day03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IoRandom {

	/**
	 * RandomAccessFile向文件读写不同类型的数据
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("D:/java_test/se2_day03/test.dat", "rw");
			raf.write(255);// 无符号的，最高位不是符号，是数据
			raf.writeInt(1000);
			raf.writeUTF("张飞");
			raf.writeChars("刘亦菲");
			raf.seek(0);
			System.out.println(raf.read());
			System.out.println(raf.readInt());
			System.out.println(raf.readUTF());
			System.out.println(raf.readChar() + "" + raf.readChar()
					+ raf.readChar());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
