package com.eoe.learnjava.day06;

import java.util.Scanner;

public class Test_work {

	/**
	 *访问修饰符引入案例
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("1---");
		System.out.println("2---");
		System.out.println("3---");
		System.out.println("4---");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			com.eoe.learnjava.day06.Deal.main(null);
			break;
		case 2:
			com.eoe.learnjava.day05.Login_check.main(null);
			break;
		case 3:
			com.eoe.learnjava.day06.Grade.main(null);
			break;
		case 4:com.eoe.learnjava.day04.Factorial.main(null);
			break;
		default:
			System.out.println("输入错误!");
			break;
		}
	}

}
