package com.eoe.basic.day02_;

public class Test12 {
	public static void main(String[] args) {
		long l=0x20000000000001l;
		double d=l;
		System.out.println(Long.toBinaryString(l));;
		System.out.println(Long.toBinaryString((long)d));
	}
}
