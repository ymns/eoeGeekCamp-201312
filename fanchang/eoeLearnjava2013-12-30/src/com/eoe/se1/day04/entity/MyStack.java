package com.eoe.se1.day04.entity;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;

public class MyStack<E> extends AbstractList<E> {
	/**
	 * 模拟堆的结构
	 * 
	 * @param args
	 */
	// 创建一个存放数据的数组
	private E[] values;
	int index=0;
	// 定义一个无参构造放法
	public MyStack() {
		values=(E[]) new Object[0];
	}

	// 入栈方法
	public void push(E value) {
		// 先扩容
		values = Arrays.copyOf(values, values.length+1);
		values[values.length-1]=value;
	}

	// 出栈方法
	public E pop(){
		E t=values[values.length-1];
		values=Arrays.copyOf(values, values.length-1);
		return t;
	}

	@Override
	public E get(int index) {
		if (index<values.length) {			
			return values[index];
		}
		return null;
	}

	@Override
	public int size() {
		return values.length;
	}

}
