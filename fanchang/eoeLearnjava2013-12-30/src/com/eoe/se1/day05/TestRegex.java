package com.eoe.se1.day05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	/**
	 * 查找字符串中的逗号并显示该逗号在字符串的开始和
	 * 结束的位置.
	 * @param args
	 */
	public static void main(String[] args) {
		String text ="a b , c d";
		Pattern p=Pattern.compile(",");
		Matcher m=p.matcher(text);
		if (m.find()) {
			System.out.println(m.group()+"\tstart"+m.start()+"\tend"+m.end());
		}else{
			System.out.println("not found!");
		}
	}

}
