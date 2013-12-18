package com.eoe.pre.textday02;
//编写程序，不用第三个变量，用减法实现两个变量值互换
import java.util.Scanner;
public class Exercise03 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("a=");
		int a=scanner.nextInt();
		System.out.println("b=");
		int b=scanner.nextInt();
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a="+a+"   "+"b="+b);
		}

}
