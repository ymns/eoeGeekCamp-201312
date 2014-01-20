package com.eoe.se1.day04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {

	/**
	 * 筛除法获取200以内的所有质数 分析: 将2-200的所有整数存放一个HashMap集合中 从2开始依次将每一个元素的倍数从集合中删除
	 * 剩下的就是质数
	 */
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(); // 无get方法
		for (int i = 0; i < 200; i++) {
			set.add(i);
		}
		int k = (int) Math.sqrt(199);
		for (int i = 2; i <= k; i++) {
			for (int j = 1, t = j * i; t < 200; j++,t=i*j) { // 第一次循环,t是2的倍数
				if (set.contains(t)) { // 是否包含t
					set.remove(t); // 若有t,则移除
				}
			}
		}
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		for (Integer in :set) {
			System.out.print(in+" ");
		}

	}

}
