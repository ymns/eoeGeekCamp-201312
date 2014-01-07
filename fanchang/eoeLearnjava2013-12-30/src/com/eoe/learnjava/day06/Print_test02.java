package com.eoe.learnjava.day06;

import java.util.Scanner;

public class Print_test02 {

	/**打印一下图形,n由键盘输入
	 *    *
	 *    **
	 *    ***
	 *    ****
	 *    *****
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入n:");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
