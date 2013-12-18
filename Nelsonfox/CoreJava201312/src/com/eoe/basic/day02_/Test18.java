package com.eoe.basic.day02_;

public class Test18 {
	public static void main(String[] args) {
		int a=5;
		int b=50;
		System.out.println("a="+a+"  b="+b);
		int c=a;//将a的值保存在c中
		a=b;//a获取b的值，  a=50 b=50 c=5
		b=c;//b=5;
		System.out.println("a="+a+"  b="+b);
	}
}
