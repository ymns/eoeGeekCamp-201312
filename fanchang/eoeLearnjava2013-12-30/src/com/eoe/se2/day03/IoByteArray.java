package com.eoe.se2.day03;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class IoByteArray {

	/**
	 * ByteArrayInputStram示例1
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] data = { 45, 87, 66 };
		System.out.println(Arrays.toString(data));
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		byte[] buffer = new byte[3];
		try {
			bais.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(buffer));

	}

}
