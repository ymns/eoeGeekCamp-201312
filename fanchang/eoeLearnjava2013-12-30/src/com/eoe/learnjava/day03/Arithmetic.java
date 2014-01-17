package com.eoe.learnjava.day03;

import java.util.Scanner;

public class Arithmetic {

	/**四则运算
	 * 键盘输入一个整数，在输入一个字符，该字符是+、-、*、/、%中的任意一个
	 * 字符，在输入一个整数。程序对着两个数进行计算
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("a [+、-、*、/、%] b");
		int a = scanner.nextInt();
		char c = scanner.next().charAt(0);
		int b = scanner.nextInt();
		switch (c) {
		case '+':
			System.out.println(a + b);
			break;
		case '-':
			System.out.println(a - b);
			break;
		case '*':
			System.out.println(a * b);
			break;
		case '/':
			System.out.println(a / b);
			break;
		case '%':
			System.out.println(a % b);
			break;
		default :
			System.out.println("输入错误！！");
			break;
		}
 	}

}
