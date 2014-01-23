package com.eoe.se2.day02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IoFile {

	/**
	 * 【示例-1】文件、文件夹的检测、创建和删除。
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("1-检测文件夹是否存在");
		System.out.println("2-检测文件是否存在");
		System.out.println("3-创建文件夹");
		System.out.println("4-创建文件");
		int select=scanner.nextInt();
		switch (select) {
		case 1://检测文件夹是否存在
			checkFloder();
			break;
		case 2:
			testFile();
			break;
		case 3:
			createFolder();
			break;
		case 4:
			createFile();
			break;
		}

	}
	//检测文件是否存在
	private static void testFile() {
		String path="d:/java_test/se2_day02";
		File file=new File(path, "test_day02.java");
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath()+" 不存在");
		}else{
			System.out.println(file.getAbsolutePath()+" 已存在");
		}
		
	}
	//创建文件
	private static void createFile() {
		String path="d:/java_test/se2_day02";
		File file=new File(path, "test_day02.java");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(file.getAbsolutePath()+" 被创建");
		}else{
			System.out.println(file.getAbsolutePath()+" 已存在");
		}
		
	}
	//创建文件夹
	private static void createFolder() {
		String path="d:/java_test/se2_day02";
		File folder=new File(path);
		if(!folder.exists()){
			folder.mkdirs();
			System.out.println(folder.getAbsolutePath()+" 被创建");
		}else{
			System.out.println(folder.getAbsolutePath()+" 已存在");
		}
		
	}
	//检测文件夹是否存在
	private static void checkFloder() {
		String path="d:/java_test/se2_day02";
		File folder=new File(path);
		if (folder.exists()) {
			System.out.println(folder.getAbsolutePath()+" 已存在");
		}else {
			System.out.println(folder.getAbsolutePath()+" 不存在");
		}
	}

}
