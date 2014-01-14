package com.eoe.learnjava.day07;

import java.util.Arrays;
import java.util.Random;

public class Descending_sort {

	/**
	 * 降序排列
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int[] score = new int[10];
		//产生10个随机数,保存到数组中
		for (int i = 0; i < score.length; i++) {
			score[i]=random.nextInt(40)+60;
			System.out.print(score[i]+" ");
		}
		System.out.println();
		//降序排列
		for (int j = 1; j < score.length; j++) {
			for (int i = 0; i < score.length-j; i++) {
				if (score[i]>score[i+1]) {
					swap(score,i,i+1);
				}
			}
		}
		System.out.println(Arrays.toString(score));
	}
	//交换
	static void swap(int[] a,int i,int j){
		int c=a[i];
		a[i]=a[j];
		a[j]=c;
	}

}
