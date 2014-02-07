package com.eoe.se2.day03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class IoRandom01 {

	/**
	 * RandomAccessFile的seek()定位读取文件中的不同类型的数据。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile("D:/java_test/se2_day03/test.dat", "r");
			System.out.println("1-读取第一个数据");
			System.out.println("2-读取第二个数据");
			System.out.println("3-读取第三个数据");
			System.out.println("4-读取第四个数据");
			int select=scanner.nextInt();
			switch (select) {
			case 1:
				raf.seek(0);
				System.out.println(raf.read());
				break;

			case 2:
				raf.seek(1);
				System.out.println(raf.readInt());
				break;
			case 3:
				raf.seek(5);
				System.out.println(raf.readUTF());
				break;
			case 4:
				raf.seek(13);     //utf占八个字节
				System.out.print(raf.readChar());
				System.out.print(raf.readChar());
				System.out.println(raf.readChar());
				break;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (raf!=null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
