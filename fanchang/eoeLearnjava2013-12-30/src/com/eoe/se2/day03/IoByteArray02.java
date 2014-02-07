package com.eoe.se2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IoByteArray02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		baos.write(50);
		baos.write(58);
		baos.write(98);
		//将字节输出流中的数据转换为字节数组
		byte[] data =baos.toByteArray();
		ByteArrayInputStream bais= new ByteArrayInputStream(data);
		byte[] buffer=new byte[3];
		try {
			bais.read(buffer);
			System.out.println(Arrays.toString(buffer));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
