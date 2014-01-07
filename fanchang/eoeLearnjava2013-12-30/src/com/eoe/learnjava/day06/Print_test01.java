package com.eoe.learnjava.day06;

import java.util.Scanner;

public class Print_test01 {

	/**
	 * 打印一下的n行n列的字符图形,n由键盘来输入
	 * 要求:一次输入一个*号
	 *    *****
	 *    *****
	 *    *****
	 *    *****
	 *    *****
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入n:");
		int n = scanner.nextInt();
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				System.out.print("*");
			}
			System.out.println();	
		}

	}

}
