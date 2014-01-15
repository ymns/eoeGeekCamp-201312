package com.eoe.se1.day01;

import java.util.Scanner;

public class Abnormal {

	/**
	 * 系统常见的六种异常及抛出的异常信息
	 * 
	 * @param args
	 */
	private static final int N = 6;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-OutOfMemoryError");
		System.out.println("2-NullPointerException");
		System.out.println("3-NumberFormatException");
		System.out.println("4-ArrayIndexOutOfBoundsException");
		System.out.println("5-ArithmeticException");
		System.out.println("6-ClasscastException");
		System.out.println("select 1~" + N);
		int select;
		do {
			select = scanner.nextInt();
		} while (select < 1 || select > N);
		switch (select) {
		case 1:// 1-OutOfMemoryError
			double[] a = new double[400000000];
			break;
		case 2:// 2-NullPointerException
			String[] a2 = null;
			System.out.println(a2[2]);
			break;
		case 3:// 3-NumberFormatException
			int a3 = Integer.parseInt("aa");
			break;
		case 4:// 4-ArrayIndexOutOfBoundsException
			String[] a4 = new String[1];
			System.out.println(a4[2]);
			break;
		case 5:// 5-ArithmeticException
			System.out.println(5 / 0);
			break;
		case 6:// 6-ClasscastException
			Object o = "aaa";
			Integer a6 = (Integer) o;
			break;
		}

	}

}
