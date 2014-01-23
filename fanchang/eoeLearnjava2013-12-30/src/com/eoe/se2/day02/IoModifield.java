package com.eoe.se2.day02;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IoModifield {

	/**
	 * lastModified()：返回该文件最后更改时间标志 length()：返回文件长度 list()：返回文件和目录清单
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-获取文件修改的最后时间");
		System.out.println("2-返回文件长度");
		System.out.println("3-获取当前文件夹下所有文件和文件夹");
		System.out.println("4-获取当前文件夹下所有java文件");
		int select = scanner.nextInt();
		switch (select) {	
		case 1:// 获取文件修改的最后时间
			getFieleModifield();
			break;
		case 2:// 获取文件长度
			getFileSize();
			break;
		case 3:// 获取当前文件夹下所有文件和文件夹
			getDirLists();
			break;
		case 4:// 获取当前文件夹下所有java文件
			getJavaFiles();
			break;
		}
	}

	// 获取文件长度
	private static void getFileSize() {
		String path="d:/java_test/se2_day02/Test04.java";
		File dir=new File(path);
		System.out.println(dir.length());
	}

	// 获取当前文件夹下所有java文件
	private static void getJavaFiles() {
		String path="d:/java_test/se2_day02";
		File dir=new File(path);
		File[] files=dir.listFiles(new FileFilter() {    //匿名内部接口,过滤作用
			
			@Override
			public boolean accept(File file) {
				//所有事文件和名字的最后是java
				return file.isFile()&&file.getPath().endsWith("java");
			}
		});
		//循环打印
		for(File file:files){
			System.out.println(file.getName());
		}
	}

	// 获取当前文件夹下所有文件和文件夹
	private static void getDirLists() {
		String path="d:/java_test/se2_day02";
		File dir=new File(path);
		File[] files=dir.listFiles();    //返回文件和目录清单
		for(File file:files){
			String text=file.isFile()?"file":"folder";
			System.out.println(file.getName()+"\t"+text);
		}
		
	}

	// 获取文件修改的最后时间
	private static void getFieleModifield() {
		String path="d:/java_test/se2_day02";
		File dir=new File(path);

		if(!dir.exists()){
			System.out.println("文件夹不存在");
			return ;
		}
		File file=new File(dir, "Test04.java");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(!file.exists()){
			System.out.println(file.getAbsolutePath()+"不存在");
			return ;
		}
		long time =file.lastModified();
		Date date=new Date(time);
		String sdate=new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").format(date);
		System.out.println(sdate);
				
	}

}
