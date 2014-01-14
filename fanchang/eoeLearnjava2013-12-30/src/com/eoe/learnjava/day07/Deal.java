package com.eoe.learnjava.day07;

import java.util.Random;

public class Deal {

	/**
	 * 给三明牌手顺序发牌
	 * @param args
	 */
	public static void main(String[] args) {
		String[] player={"张飞","王菲","刘亦菲"};
		String[] cards={"红桃3","红桃4","红桃5","红桃6",
				"红桃7","红桃8","红桃9","红桃10","红桃J",
				"红桃Q","红桃K","红桃A"};
		Random random = new Random();
		for (int i = cards.length-1; i >= 0; i--) {
			int j=random.nextInt(i+1);//随机产生i个数
			swap(cards,i,j);
			System.out.println(player[i%3]+":"+cards[i]);
		}
	}
	static void swap(String[] a,int i,int j){
		String c=a[i];
		a[i]=a[j];
		a[j]=c;
	}
	

}
