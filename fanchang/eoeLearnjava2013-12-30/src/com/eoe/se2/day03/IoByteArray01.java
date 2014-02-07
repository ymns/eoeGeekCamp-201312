package com.eoe.se2.day03;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IoByteArray01 {

	/**
	 * ByteArrayOutputStream示例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(66);
		baos.write(88);
		baos.write(127);
		byte[] data = baos.toByteArray();
		System.out.println(Arrays.toString(data));
	}

}
