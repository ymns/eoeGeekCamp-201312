package com.eoe.se1.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arraylist01 {

	/**数组转化为集合aslist()
	 * 集合不可删除和添加
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names={"王朵朵","钱多多","刘飞","张飞"};
		List<String> list=Arrays.asList(names);
		System.out.println(list); 
		list.set(0, "关羽");
		System.out.println(list);
		List<String> list2=new ArrayList<>(list);
		list2.remove(2);
		System.out.println(list2);

	}

}
