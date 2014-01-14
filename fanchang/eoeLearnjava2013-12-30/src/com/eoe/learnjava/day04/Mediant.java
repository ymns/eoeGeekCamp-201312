package com.eoe.learnjava.day04;

import java.util.Scanner;

public class Mediant {

	/**
	 * 输入三个数，找到中间值
	 * 不用判断语句
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入三个数a b c :");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int max=Math.max(a, Math.max(b, c));
		int min=Math.min(a, Math.min(b, c));
		System.out.println("最大值是："+max+"  中间值是："+(a+b+c-max-min)+"  最小值是："+min);
        /*用 a+b+c 减去最大值和最小值的结果 就是中间值*/
	}

}
