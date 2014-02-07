package com.eoe.se2.day02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class IoReader2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "d:/java_test/se2_day02/Test01.java";
		String destPath = "d:/java_test/se2_day02/Test01_new.java";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;

		try {
			fis = new FileInputStream(path);
			isr = new InputStreamReader(fis, "gbk");
			reader = new BufferedReader(isr);
			fos = new FileOutputStream(destPath);
			osw = new OutputStreamWriter(fos, "utf-8");
			String line;
			while ((line = reader.readLine()) != null) {
				osw.write(line + "\r\n");
				osw.flush();
			}
			System.out.println("文件复制完毕!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (osw != null) {
					osw.close();
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
