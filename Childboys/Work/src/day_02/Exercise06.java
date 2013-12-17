package day_02;

import java.util.Scanner;

public class Exercise06 {

	/**
	 * 编写程序，键盘输入两个int类型的数， 打印这两个数是否相等。 要求：用true和false表示两个数是否相等。
	 * 文件名：Exercise06.java
	 */
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("请输入一个数a：");
		int a = scan1.nextInt();
		Scanner scan2 = new Scanner(System.in);
		System.out.print("请再输入一个数b");
		int b = scan2.nextInt();
		boolean equal;
		if (a== b) {    //判断  a与b
			equal = true;
		} else {
			equal = false;
		}
		System.out.println("两个数为"+equal);
	}
}
