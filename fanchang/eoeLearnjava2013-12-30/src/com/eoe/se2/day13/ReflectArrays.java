package com.eoe.se2.day13;

import java.lang.reflect.Array;

public class ReflectArrays {

	/**
	 * 通过反射获取数组类型并创建数组。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names = new String[3];
		createArray(names, names.length, "张飞");
		Integer[] scores = new Integer[3];
		createArray(scores, scores.length, 25);
	}

	private static <T> void createArray(T[] ary, int length, T value) {
		// 获取ary数组的类型
		Class<?> type = ary.getClass().getComponentType();
		// 在堆中创建新的数组
		T[] array = (T[]) Array.newInstance(type, length);
		Array.set(array, 0, value);
		System.out.println(Array.get(array, 0));
	}

}
