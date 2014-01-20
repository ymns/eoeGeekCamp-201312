package com.eoe.se1.day04;

import java.util.HashMap;
import java.util.Set;

public class TestHashMap01 {

	/**
	 * 统计字符出现的次数个百分比
	 * @param args
	 */
	public static void main(String[] args) {
		String text="father and mother,we are family,";
		text+="grand father and grand mother we are family";
		HashMap<Character, Integer> counts =new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			char c=text.charAt(i);
			Integer count=counts.get(c);    //计算出现的次数
			count=count==null?1:count+1;
			counts.put(c, count);
		}
		System.out.println("字符\t\t出现次数\t\t百分比");
		Set<Character> key=counts.keySet();
		for (Character keys:key) {
			int value=counts.get(keys);
			double percent=Math.round(value*100.0/text.length()*100)/100.0;
			System.out.println(keys+"\t\t"+counts.get(keys)+"\t\t"+percent);
		}

	}

}
