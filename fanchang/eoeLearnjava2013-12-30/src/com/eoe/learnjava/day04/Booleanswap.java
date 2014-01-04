package com.eoe.learnjava.day04;

import java.util.Scanner;

public class Booleanswap {

	/**
	 * 实现两个布尔变量值的互换
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入第一个逻辑值（true或false）:");
		boolean a = scanner.nextBoolean();
		System.out.println("输入第二个逻辑值（true或false）:");
		boolean b = scanner.nextBoolean();
		System.out.println("a="+a+"\tb="+b);
		a = a!=b?!(b=a):a;
		System.out.println("a="+a+"\tb="+b);
	}

}
