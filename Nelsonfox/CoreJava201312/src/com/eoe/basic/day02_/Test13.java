package com.eoe.basic.day02_;

public class Test13 {
	public static void main(String[] args) {
		int i=257;
		byte b=(byte) i;//ctrl+1
		System.out.println(b);
		//256+1=1 00000001
		i=129;//256-129
		b=(byte) i;
		System.out.println(b);
		//128+1=10000001
		      //01111111
	}
}
