package com.eoe.learnjava.day06;

public class Multiplication_table {

	/**
	 * 打印九九表
	 * 去掉重复的
	 * @param args
	 */
	public static void main(String[] args) {
		//下三角
//		String space = " ";
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= i; j++) {
//				if(i*j<10){
//					System.out.print(+i+"*"+j+"="+space+i*j+space+space);
//				}else{	
//				System.out.print(+i+"*"+j+"="+i*j+space+space);
//				}
//			}
//			System.out.println();
//		}
		//上三角
		String space = " ";
		for (int i = 1; i <= 9; i++) {
			for (int j = i; j <= 9; j++) {
				if(i*j<10){
					System.out.print(+i+"*"+j+"="+space+i*j+space+space);
				}else{	
				System.out.print(+i+"*"+j+"="+i*j+space+space);
				}
			}
			System.out.println();
		}

	}

}
