package com.eoe.se1.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Test_score {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Score> scores = new ArrayList<>();
		scores.add(new Score(95, 85, 88, 82));
		scores.add(new Score(92, 88, 76, 95));
		scores.add(new Score(92, 82, 95, 78));
		scores.add(new Score(92, 98, 91, 91));
		Collections.shuffle(scores, new Random());
		for (Score score : scores) {
			System.out.println(score);
		}
		Collections.sort(scores, new MyComparator());

		System.out.println("********************");

		for (Score score : scores) {
			System.out.println(score);
		}
	}

	// 创建一个MyComparator类
	static class MyComparator implements Comparator<Score> {

		@Override
		public int compare(Score o1, Score o2) {
			return o1.java * 10 + o1.android - (o2.java * 10 + o2.android);

		}

	}

}
