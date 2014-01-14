package com.eoe.learnjava.day05;

public class Narcissus {

	/**
	 * 求100-9999之间的水仙花个数
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=100;i<10000;i++){
			int g=i%10;           //求个位,十位和百位
			int s=i/10%10;
			int b=i/100;
			int q=i/1000;
			if(i==g*g*g+s*s*s+b*b*b+q*q*q){		
				System.out.println(i);
			}
		}

	}

}
