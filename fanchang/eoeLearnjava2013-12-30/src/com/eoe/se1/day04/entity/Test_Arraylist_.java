package com.eoe.se1.day04.entity;

import java.util.Iterator;

public class Test_Arraylist_ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Arraylist_<Integer> scores = new Arraylist_<>();
		scores.add(100);
		scores.add(200);
		scores.add(300);
		scores.add(400);
		 for(Integer score:scores){
		 System.out.println(score);
		 }
		
		Iterator<Integer> iterator=scores.iterator();
		while(iterator.hasNext()){
			Integer score=iterator.next();
			System.out.println(score);
		}

	}

}
