package com.eoe.learnjava.day07;

import java.util.Random;

public class Random_array {

	/**
	 * 随机产生10个[60-100]的分数,显示所有超过平均分的分数和下标
	 * @param args
	 */
	public static void main(String[] args) {
		int[] score=new int[10];
		Random random = new Random();
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			score[i]=random.nextInt(41)+60;
			System.out.print(score[i]+"  ");
			total+=score[i];     //求总分
		}
		System.out.println("平均分:"+(total/10));
		for (int i = 0; i < score.length; i++) {	
			if (score[i]>total/10) {
				System.out.print(score[i]+":"+(i+1)+" ");
			}
		}
	}

}
