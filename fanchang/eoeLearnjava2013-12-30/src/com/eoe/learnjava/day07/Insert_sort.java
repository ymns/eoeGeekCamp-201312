package com.eoe.learnjava.day07;

import java.util.Arrays;
import java.util.Random;

public class Insert_sort {

	/**
	 * 插入排序
	 *	降序
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int[] a=new int [10];
		for (int i = 0; i < a.length; i++) {
			a[i]=random.nextInt(101);
		}
		System.out.println(Arrays.toString(a));
		
		for (int i = 1; i < a.length; i++) {
			int k=a[i];
			for (int j = i-1; j >= 0&&k>a[j]; j--) {
				a[j+1]=a[j];
				a[j]=k;
			}
		
		}
		System.out.println(Arrays.toString(a));

	}
	

}
