package com.eoe.se2.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class IoPrint {

	/**
	 * PrintStream类示例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建PrintStream对象
		PrintStream out = null;
//		out = new PrintStream(System.out);
//		out.print('中' + "\t" + 100);
//		out.close();
		File dir = new File("d:/java_test/se2_day04");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "Test01.java");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new PrintStream(file);
			out.println('中');
			out.println(1000);
			// 创建一个Map对象,存放三个键值对
			Map<String, Object> person = new HashMap<String, Object>();
			person.put("name", "张飞");
			person.put("sex", '男');
			person.put("age", 25);
			out.println(person);
			System.out.println("文件复制完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}
}
