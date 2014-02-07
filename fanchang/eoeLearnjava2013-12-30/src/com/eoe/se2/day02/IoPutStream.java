package com.eoe.se2.day02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//复制文件
public class IoPutStream {
	public static void main(String[] args) {
		String path = "D:/";
		File dir = new File(path);
		if (!dir.exists()) { // 找不到
			System.err.println("路径错误!");
			return;
		}
		File file = new File(path, "apache-tomcat-7.0.34.rar"); // 源文件
		if (!file.exists()) {
			System.out.println("文件不存在");
			return;
		}
		File destDir = new File("D:/java_test/se2_day02"); // 文件夹路径
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		File desFile = new File(destDir, "apache-tomcat.rar"); // 目标文件路径
		FileInputStream fis = null; // 输入流
		FileOutputStream fos = null; // 输出流
		// 创建输入流,输出流对象
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(desFile);
			// 定义一个len,表示内存读取的字节数
			int len;
			// 定义缓存数组
			byte[] buffer = new byte[1024]; // 一次存入一个字节
			long startTime = System.currentTimeMillis(); // 获取系统时间
			// 循环读写文件
			while ((len = fis.read(buffer)) != -1) { // 读文件 =-1读取结束
				fos.write(buffer, 0, len); // 写文件
			}
			long endTime = System.currentTimeMillis();
			System.out.println("文件复制完毕!,花费时间：" + (endTime - startTime) + "毫秒");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 清理工作,如关闭输入输出流,一定会被执行
			try {
				if (fis != null) { // 判断不为空
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
