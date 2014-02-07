package com.eoe.se2.day02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class IoReader1 {

	/**
	 * 拷贝d:\demo\java.txt文件至当前文件夹， 改名为java_new.txt。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "d:/java_test/se2_day02/Test01.java";
		String destPath = "d:/java_test/se2_day02/Test01_new.java";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		FileWriter writer = null; // 基于字符的文件输出流

		try {
			fis = new FileInputStream(path);
			isr = new InputStreamReader(fis, "gbk");
			reader = new BufferedReader(isr);
			writer = new FileWriter(destPath);
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line + "\r\n"); // 文本换行\r\n
			}
			System.out.println("文件复制完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
