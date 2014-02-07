package com.eoe.se2.day02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class IoReader {

	/**
	 * 读取d:\demo\java.txt文件内容并显示在控制台
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D:/java_test/se2_day02/Test01.java";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		try {
			fis = new FileInputStream(path);
			isr = new InputStreamReader(fis, "gbk");
			reader = new BufferedReader(isr);
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
