package com.eoe.se2.day02;

public class TestBit01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = -5;
		int b=5;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		a = a << 1;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a);

	}

}
