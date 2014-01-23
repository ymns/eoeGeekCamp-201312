package com.eoe.se2.day02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IoFile01 {

	/**
	 * getAbsoluteFile() 返回文件完整路径的File实例 
	 * getPath() 返回文件路径字符串 
	 * getName() 返回文件名称
	 * getParent() 返回文件父目录路径 
	 * getParentFile() 返回文件所在文件夹的路径
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("1-返回文件完整路径的File实例");
		System.out.println("2-返回文件名");
		System.out.println("3-返回文件父目录路径");
		System.out.println("4-返回文件所在的文件夹路径");
		System.out.println("5-判断指定路径是否为目录");
		System.out.println("6-判断指定路径是否为文件");
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
		switch (select) {
		case 1:// 返回文件完整路径的File实例
			getAbsolutePathFile();
			break;
		case 2:// 返回文件名
			getFileName();
			break;
		case 3://返回文件父目录路径
			getFileParent();
			break;
		case 4://返回文件所在的文件夹路径
			getFile();
			break;
		case 5://判断指定路径是否为目录
			getDirectory();
			break;
		case 6://判断指定路径是否为文件
			getDocument();
			break;
		}

	}
	private static void getDocument() {
		String path = "d:/java_test/se2_day02/Test00.java";
		File file = new File(path);
		if(file.isDirectory()){
			System.out.println(file.getPath()+" :is folder");
		}else{
			System.out.println(file.getPath()+" :is file");
		}
		
	}
	private static void getDirectory() {
	
		String path = "d:/java_test/se2_day02/";
		File file = new File(path);
		if(file.isDirectory()){
			System.out.println(file.getPath()+" :is folder");
		}else{
			System.out.println(file.getPath()+" :is file");
		}
	}
	//返回文件所在的文件夹路径
	private static void getFile() {
		String path = "d:/java_test/se2_day02/Test00.java";
		File file = new File(path);
		String dir=file.getParent();
		System.out.println(dir);
	}

	private static void getFileParent() {
		String path = "d:/java_test/se2_day02";
		File file = new File(path);
		File parent = file.getParentFile();
		System.out.println(parent.getPath());
	}

	// 返回文件完整路径的File实例
	private static void getAbsolutePathFile() {
		String path = "d:/java_test/se2_day02";
		File folder = new File(path);
		File parent = folder.getAbsoluteFile();
		System.out.println(parent.getPath());
	}

	// 返回文件名
	private static void getFileName() throws IOException {
		String path = "d:/java_test/se2_day02";
		File file = new File(path, "Test00.java");
		file.createNewFile();
		if (file.isDirectory()) {
			System.out.println(file.getPath()+" :is folder");
		}else{
			System.out.println(file.getPath()+" :is file");
		}
		System.out.println(file.getName());
		System.out.println(file.getParent());
			
	}

}
