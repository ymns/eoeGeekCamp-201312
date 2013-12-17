package day_02;

import java.util.Scanner;

public class Exercise08 {

	/**
	 * 键盘输入一个数，该数要求在0~5之间，当超过5时设置为5，当小于0时设置为0
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("请输入一个数：");
		int a=scan.nextInt();
		if(a>0&&a<5)  //判断a是否在 0~5之间
		{
			System.out.println("你输入的数字为："+a);
		}else if(a<0){  //小于0输出
			
			System.out.println("重置为: 0");
		}else {  //大于5输出
			System.err.println("重置为：5");
		}

	}

}
