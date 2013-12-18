package com.eoe.pre.textday02;
import java.util.Scanner;
//编写程序，键盘输入两个int类型的数，打印这两个数是否相等。
//要求：用true和false表示两个数是否相等。
//文件名：Exercise06.java
public class Exercise06 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入第一个数：");
		int a=scanner.nextInt();
		System.out.println("请输入第二个数：");
		int b=scanner.nextInt();
		if(a==b){
			System.out.println("相等");
		}else{
			System.out.println("不相等");
		}
		
	}

}
