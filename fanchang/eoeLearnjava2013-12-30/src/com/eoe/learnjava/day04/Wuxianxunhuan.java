package com.eoe.learnjava.day04;

public class Wuxianxunhuan {

	/**
	 * 无限循环中,打印0-5的数
	 * @param args
	 */
	
	public static void main(String[] args) {
//		int i= 1;
//		while(true){
//			i=i<5?i+1:0;
//			System.out.println(i);
//		}
		for(int i=1;;i++){
			System.out.println(i%6);
		}
	}

}
