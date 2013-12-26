package com.eoe.basic.day03_;

import java.util.Scanner;

public class Text19 {

	public Text19() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("java android oracle:");
int java=scanner.nextInt();
int android=scanner.nextInt();
int oracle=scanner.nextInt();
int max=java;
if(max<android){
	max=android;
}
if(max<oracle){
	max=oracle;
}
System.out.println("最高分"+max);
	}

}
