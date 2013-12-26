package com.eoe.pre.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<String>();
		names.add("’≈∑…");
		names.add("Õı∑∆");
		names.add("¡ı“‡∑∆");
		for(int i=0;i<names.size();i++){
			System.out.println(names.get(i));
		}
		for(String name:names){
			System.out.println(name);
		}
		System.out.println("*****************");
		System.out.println(names);
		System.out.println("*****************");
		names.remove(0);
		System.out.println(names);
		names.add(1, "’≈∑…");
		System.out.println("*****************");
		System.out.println(names);
		
		Collections.shuffle(names,new Random());
		System.out.println(names);
		System.out.println("******");
		Collections.shuffle(names);
		System.out.println(names);
	}

}
