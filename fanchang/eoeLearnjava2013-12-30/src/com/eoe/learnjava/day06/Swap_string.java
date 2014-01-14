package com.eoe.learnjava.day06;
import java.util.Scanner;


public class Swap_string {

	/**
	 * 不用第三方变量交换两个String类型的值
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入两个String类型的值:");
		String a=scanner.next();
		String b=scanner.next();
		System.out.println(a+"     "+b);
		a=a+b;
		b=a.substring(0,a.length()-b.length());
		a=a.substring(b.length(), a.length());
		System.out.println(a+"     "+b);
	}

}
