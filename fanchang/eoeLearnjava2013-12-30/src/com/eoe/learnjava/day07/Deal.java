package com.eoe.learnjava.day07;

import java.util.Random;

public class Deal {

	/**
	 * ¸øÈıÃ÷ÅÆÊÖË³Ğò·¢ÅÆ
	 * @param args
	 */
	public static void main(String[] args) {
		String[] player={"ÕÅ·É","Íõ·Æ","ÁõÒà·Æ"};
		String[] cards={"ºìÌÒ3","ºìÌÒ4","ºìÌÒ5","ºìÌÒ6",
				"ºìÌÒ7","ºìÌÒ8","ºìÌÒ9","ºìÌÒ10","ºìÌÒJ",
				"ºìÌÒQ","ºìÌÒK","ºìÌÒA"};
		Random random = new Random();
		for (int i = cards.length-1; i >= 0; i--) {
			int j=random.nextInt(i+1);//Ëæ»ú²úÉúi¸öÊı
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
