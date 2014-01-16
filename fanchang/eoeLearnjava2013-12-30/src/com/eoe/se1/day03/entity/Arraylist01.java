package com.eoe.se1.day03.entity;

import java.util.Arrays;

public class Arraylist01<T> {

	T[] values;

	public Arraylist01() {
		values = (T[]) new Object[0];
	}

	// 添加一个元素
	public void add(T vaule) {                 //数组扩容
		values = Arrays.copyOf(values, values.length + 1);
		values[values.length - 1] = vaule;
	}

	// 返回引索
	public T get(int index) {
		if (index < values.length) {    //索引是否小于长度
			return values[index];
		}
		return null;
	}
	//返回长度
	public int size(){
		return values.length;
	}

}
