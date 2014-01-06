package com.eoe.learnjava.day05;
import java.util.Scanner;


public class Fivegrade {

	/**
	 * 键盘输入五分制,若不是五分制,则重新输入
	 * 知道输入正确
	 * @param args
	 */
	
	public static void main(String[] args) {
	    //do--while循环写
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入一个五分制的数:");
//		int score;
//		do{
//			score= scanner.nextInt();	
//		}while(score<0||score>5);
//		System.out.println("是五分制的数");
		
	    //用while循环做
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入一个五分制的数:");
//		int score=-1;
//		while(score<0||score>5){
//			score= scanner.nextInt();	
//		}
//		System.out.println("是五分制的数");

		//用for循环做
		Scanner scanner = new Scanner(System.in);
			System.out.println("请输入一个五分制的数:");
		int score=-1;
		for(;score<0||score>5;){
			score= scanner.nextInt();	
		}
		System.out.println("是五分制的数");
	}
}
