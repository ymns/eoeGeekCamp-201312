package com.eoe.basic.day02_;

import java.util.Scanner;
//张飞 男
public class Test16 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("输入姓名：");
		String name=scanner.next();
		System.out.print("性别:");
		char sex=scanner.next().charAt(0);
		System.out.print("年龄:");
		int age=scanner.nextInt();
		System.out.print("身高：");
		float height=scanner.nextFloat();
		System.out.println("嗨，大家好，俺叫"+name+
			"，今年"+age+"岁,身高:"+height+
			"米,俺是一个"+sex+"士");
	}
}
