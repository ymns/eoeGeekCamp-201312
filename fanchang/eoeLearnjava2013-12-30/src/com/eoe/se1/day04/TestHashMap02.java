package com.eoe.se1.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap02 {

	/**
	 * 统计字符出现的次数个百分比,并按降序排列
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "father and mother,we are family,";
		text += "grand father and grand mother we are family";
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			Integer count = counts.get(c);
			count = count == null ? 1 : count + 1;// 获取的字符如果是第一次则记一次,不是则加1
			counts.put(c, count);
		}
		Set<Entry<Character, Integer>> entrys = counts.entrySet();
		ArrayList<Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(
				entrys);
		Collections.sort(list, new Comparator<Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}

		});
		for (Entry<Character, Integer> entry :list) {
			int value =entry.getValue();
			double percent =Math.round(value*100.0/text.length()*100)/100.0;
			System.out.println(entry.getKey()+"\t\t"+entry.getValue()+"\t\t"+percent);
		}
	}

}
