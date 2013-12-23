package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test02 {

	public Test02() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	static String name;
	static char sex;
	static int age;
	static double height;
	static String type;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scanner=new Scanner(System.in);
     System.out.println("姓名：");
     name=scanner.next();
     System.out.println("性别：");
     sex=scanner.next().charAt(0);
     System.out.println("年龄：");
     age=scanner.nextInt();
     System.out.println("身高");
     height=scanner.nextDouble();
     System.out.println("性格：");
     type=scanner.next();
     System.out.println("嗨，大家好，我叫"+name+"今年"+age+"岁，身高"+height+"米，是一个"+type+"的"+sex+"士");
     
	}

}
