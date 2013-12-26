package day_02;

import java.util.Scanner;

public class Exercise01 {

	/**
	 * 编写程序，计算2^n，
	 * 要求： //a<<n; 
	 * (1)n由键盘输入。
	 *  (2)不能使用Math.pow() 
	 *  文件名：Exercise01.java
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入n的值：");
		long n=scanner.nextLong();
		int sum=1;
		for(int i=0;i<n;i++){   //计算2的n次方
			sum*=2;	
		}
        System.out.println("2的2次方为："+sum);
	}

}
