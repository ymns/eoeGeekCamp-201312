package com.eoe.test;

import java.util.Scanner;

public class Test01 {

	/**
	 * @param args
	 * 不用判断语句输出三个数中大小居中的数字
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入三个数字");
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		int d=Math.max(a, Math.max(b, c));
		int e=Math.min(a, Math.min(b, c));
		int f=a+b+c-d-e;
		System.out.println("中间数是："+f);
	}

}
