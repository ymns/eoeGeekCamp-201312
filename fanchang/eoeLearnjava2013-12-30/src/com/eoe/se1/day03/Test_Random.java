package com.eoe.se1.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test_Random {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> in=new ArrayList<Integer>();
		in.add(10);
		in.add(100);
		in.add(1000);
		in.add(10000);
		Collections.shuffle(in,new Random());
		System.out.println(in);
	}

}
