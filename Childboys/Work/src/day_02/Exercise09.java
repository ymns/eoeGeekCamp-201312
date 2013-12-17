package day_02;

import java.util.Scanner;

public class Exercise09 {

	/**
	 * 键盘输入三个整数，找出最大数、最小数和中间数。
	 */
	public static void main(String[] args) {
		Scanner scan1= new Scanner(System.in);
		System.out.print("请输入一个数a：");
		float a=scan1.nextFloat();
		Scanner scan2= new Scanner(System.in);
		System.out.print("请输入一个数b:");
		float b=scan2.nextFloat();
		Scanner scan3= new Scanner(System.in);
		System.out.print("请输入一个数c:");
		float c=scan3.nextFloat();
		float min=Math.min(a, Math.min(b, c)); //求最小值
		float max=Math.max(a, Math.max(b, c)); //求最大值
		float med=Math.max(a, Math.min(b, c));//求中间值
        System.out.println("最大数为："+max+"中间数为："+med+"最小数为："+min);
	}

}
