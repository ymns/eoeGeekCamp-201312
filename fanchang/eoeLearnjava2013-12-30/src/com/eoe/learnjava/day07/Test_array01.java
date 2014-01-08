package com.eoe.learnjava.day07;

import java.util.Arrays;

public class Test_array01 {

	/**
	 * 数组的扩容和减容
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a=new int [0];// 创建一个空数组
		//扩容   +1
		a=Arrays.copyOf(a, a.length+1);
		a[0]=100;
		System.out.println(Arrays.toString(a));
		//减容   -1
		a=Arrays.copyOf(a, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
