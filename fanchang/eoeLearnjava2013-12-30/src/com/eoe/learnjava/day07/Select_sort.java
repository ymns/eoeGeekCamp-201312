package com.eoe.learnjava.day07;

import java.util.Arrays;
import java.util.Random;

public class Select_sort {

	/**
	 * 选择排序
	 * 按降序
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a=new int[10];
		Random random =new Random();
		for (int i = 0; i < a.length; i++) {
			a[i]=random.nextInt(101);
		}
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i]<a[j]) {
					swap(a,i,j);					
				}
			}
		}
		System.out.println(Arrays.toString(a));

	}
	public static void swap(int[] a,int i,int j){
		int c=a[i];
		a[i]=a[j];
		a[j]=c;
	}

}
