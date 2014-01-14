package com.eoe.learnjava.day06;

import java.util.Scanner;

public class Monkey_guess {

	/**
	 * 猜数字的游戏,电脑随机产生一个0-99之间的整数数
	 * @param args
	 */
	public static void main(String[] args) {
		//声明变量
		int guessed=(int) (Math.random()*100);
		int guess=0;
		int count=0;
		
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("请输入一个0-99之间的整数:");
			guess = scanner.nextInt();
			if(guess>guessed){
				System.out.println("猜大了吧!");
			}else if(guess<guessed){
				System.out.println("猜小了吧");
			}
			count++;    //计猜了的次数
		}while (guess!=guessed);
		if(count==1){
			System.out.println("太厉害了,偶像啊~~");
		}else if(count==2){
			System.out.println("蒙的吧!");
		}else if(count>=3&&count<=7){
			System.out.println("你很懂猜数的策略!");
		}else{
			System.out.println("脑积水了吧");
		}

	}

}
