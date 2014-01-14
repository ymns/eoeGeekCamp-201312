package com.eoe.learnjava.day05;

import java.util.Scanner;

public class Equal {

	/**
	 * 键盘输入两个int类型的数，打印这两个数是否相等
	 * 要求：用true和false表示两个数是否相等
	 * @param args
	 */
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("输入两个数：");
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		boolean result = true ;
//		if (a - b == 0){
//			System.out.println(result);
//		}else{
//			System.out.println(!result);
//		}
        /*按位异或解题*/
		Scanner scanner=new Scanner(System.in);
		System.out.println("a b=");
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		System.out.println("a等于b:"+((a^b)==0));
	}

}
