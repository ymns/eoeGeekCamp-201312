package com.eoe.learnjava.day06;

import java.util.Random;

public class Rand_number {

	/**
	 * 随机产生10个分数(在60-100之间),找出最高数
	 * 思路:
	 * 1.需要循环10次,用for
	 * 2.创建max存放最大数
	 * 3.产生随机数
	 * 4.判断
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int max=Integer.MIN_VALUE;
		int score;
		for(int i=0;i<10;i++){
			score=random.nextInt(41)+60;
			System.out.println(score);
			if(score>max){
				max=score;
			}
		}
		System.out.println("最大数:"+max);

	}

}
