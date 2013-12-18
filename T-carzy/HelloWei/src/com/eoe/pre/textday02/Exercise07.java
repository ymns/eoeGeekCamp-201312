package com.eoe.pre.textday02;
import java.util.Scanner;
//键盘输入一个整数，要求只输入四位数。然后将该数反向打印。
//例如：输入5327,显示7235
//提示：用％运算分离每一位数字。
//文件名：Exercise07.java
public class Exercise07 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入四位数");
		int a=scanner.nextInt();
		int b=a%10;//个位
		int c=a/10%10;//十位
		int d=a/100%10;//百位
		int e=a/1000;//千位
		System.out.println("翻转四位数："+b+c+d+e);
	}

}
