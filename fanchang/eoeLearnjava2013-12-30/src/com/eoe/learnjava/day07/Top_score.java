package com.eoe.learnjava.day07;

import java.util.Random;

public class Top_score {

	/**
	 * 随机60-100的10个数,找出最高分
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
		//找出最高分
		for (int i = 0; i < score.length-1; i++) {
			if (score[0]<score[i+1]) {
				swap(score,0,i+1);
			}
		}
		System.out.println(score[0]);
	}
	//交换
	static void swap(int[] a,int i,int j){
		int c=a[i];
		a[i]=a[j];
		a[j]=c;
	}

}
