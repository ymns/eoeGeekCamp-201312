package com.eoe.pre.textday02;
import java.util.Scanner;
/**
 * 示例：通过控制台输入一个人的姓名、性别、年龄、身高和性格
 * 然后，让该人和大家做自我介绍。
 */
public class Test22 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("姓名：");
		String name=scanner.next();
		System.out.println("性别：");
		char sex=scanner.next().charAt(0);
		System.out.println("年龄：");
		int age=scanner.nextInt();
		System.out.println("身高：");
		double height=scanner.nextDouble();
		System.out.println("性格：");
		String type=scanner.next();
		System.out.print("大家好，我叫"+name+
				"，我今年"+age+"岁，我是个"+sex+
				"生，我身高"+height+"米，我性格"+
				type);
	}

}
