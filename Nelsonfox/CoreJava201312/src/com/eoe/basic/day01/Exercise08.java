package com.eoe.basic.day01;

import java.util.Arrays;

public class Exercise08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(Math.max(3, 5));
		//System.out.println(Math.min(5, 3));
		int[] shu=new int[]{4,3,5};
		Arrays.sort(shu);
		System.out.println("中间数为："+shu[1]);
		
	}

}
