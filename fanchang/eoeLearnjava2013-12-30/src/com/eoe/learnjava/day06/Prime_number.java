package com.eoe.learnjava.day06;

import java.util.Scanner;

public class Prime_number {

	/**键盘输入一个整数,判断该数是否是质数
	 * 质数又称素数.指在一个大于1的自然数中，
	 * 除了1和此整数自身外，无法被其他自然数整除的数
	 * @param args
	 */
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入一个整数:");
//		int n = scanner.nextInt();
//		for(int i=2;i<n;i++){
//			if(n%i!=0){
//				System.out.println(n+"是质数");
//				break;
//			}else{
//				System.out.println(n+"不是质数");
//				break;
//			
//			}
//		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个整数:");
		int n = scanner.nextInt();
		int k = (int) Math.sqrt(n);
		boolean isPrime=true;
		for(int i=2;i<=k;i++){
			if(n%i==0){
				isPrime=false;
				break;
			}
		}
		if(isPrime==true){
			System.out.println(n+"是质数");
		}else{
			System.out.println(n+"不是质数");
		}
	}

}
