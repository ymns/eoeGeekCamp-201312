package day_02;

import java.util.Scanner;

public class Exercise05 {

	/**
	 * 编写程序，键盘输入一个int类型的负数，求出该数的补码。 文件名：Exercise05.java
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个int类型的负数");
		int a=scan.nextInt();   
		int  b=~Math.abs(a)+1;    // (未完成)
		System.out.println(b);
		
			

	}

}
