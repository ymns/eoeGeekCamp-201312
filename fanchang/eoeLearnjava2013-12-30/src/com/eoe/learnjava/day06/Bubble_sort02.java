package com.eoe.learnjava.day06;

import java.util.Arrays;
import java.util.Random;

public class Bubble_sort02 {

	/**冒泡排序
	 * 下沉,升序
	 * @param args
	 */
	public static void main(String[] args) {
		Random random =new Random();
		int[] a=new int [10];
		for (int i = 0; i < a.length; i++) {
			a[i]=random.nextInt(101);
		}
		System.out.println(Arrays.toString(a));
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length-i; j++) {
				if (a[j]>a[j+1]) {
					swap(a,j,j+1);					
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
