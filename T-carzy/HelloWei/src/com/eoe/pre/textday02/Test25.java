package com.eoe.pre.textday02;

import java.util.Scanner;

/**
 * 不借助第三个变量，直接交换两个变量的值，打印出交换前、
 * 交换后两个变量的值。
 */
public class Test25 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.print("a=");
		int a=scanner.nextInt();
		System.out.print("b=");
		int b=scanner.nextInt();
		a=a+b;//a=a+b,b=b
		b=a-b;//a=a+b,b=a
		a=a-b;//a=b,b=a
		System.out.println("a="+a+"\tb="+b);
	}

}
