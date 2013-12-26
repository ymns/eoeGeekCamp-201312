package com.eoe.pre.textday02;
import java.util.Scanner;
//键盘输入三个整数，找出最大数、最小数和中间数。
public class Exercise09 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.print("输入三个数：");
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		int d=Math.max(a, Math.max(b,c));
		int e=Math.min(a, Math.min(b,c));
		System.out.println("最大数："+d);
		System.out.println("最小数："+e);
		System.out.println("中间数是："+((a+b+c)-(d+e)));
	}

}
