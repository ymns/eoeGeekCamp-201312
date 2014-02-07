package com.eoe.se2.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoSerialize {

	/**
	 * 对int类型的数据进行序列化并保存至文件中。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FileOutputStream fos = null;
		File dir = new File("D:/java_test/se2_day02");
		if (!dir.exists()) { // 不存在则创建
			dir.mkdirs();
		}
		try {
			File file = new File(dir, "java.dat");
			fos = new FileOutputStream(file);
			fos.write(65); // 写入65
			fos.write(0x7a); // 写入122
			int zhong = '中';
			fos.write(zhong >>> 8);// 右移8位,高八位变低八位
			fos.write(zhong);
			System.out.println(Integer.toHexString(zhong));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
