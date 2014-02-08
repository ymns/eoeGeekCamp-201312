package com.eoe.se2.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class IoPrint02 {

	/**
	 * PrintWriter类的示例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("d:/java_test/se2_day04");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test03.java");
		PrintWriter writer = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new PrintWriter(file);
			writer.write("哈喽!大家好\t俺叫张飞");
			System.out.println("完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

}
