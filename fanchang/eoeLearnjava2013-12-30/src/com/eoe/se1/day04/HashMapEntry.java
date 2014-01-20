package com.eoe.se1.day04;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEntry {

	/**
	 * 统计字符出现的次数个百分比
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "father and mother,we are family,";
		text += "grand father and grand mother we are family";
		HashMap<Character, Integer> counts = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			Integer count = counts.get(c);
			count = count == null ? 1 : count + 1;
			counts.put(c, count);
		}
		System.out.println("字符\t\t出现次数\t\t百分比");
		Set<Entry<Character, Integer>> entrys = counts.entrySet();
		for (Entry<Character, Integer> entry : entrys) {
			int value =entry.getValue();
			double percent =Math.round(value*100.0/text.length()*100)/100.0;
			System.out.println(entry.getKey()+"\t\t"+entry.getValue()+"\t\t"+percent);
		}

	}

}
