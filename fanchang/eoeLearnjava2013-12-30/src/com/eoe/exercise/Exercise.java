package com.eoe.exercise;

import java.util.Arrays;
import java.util.Iterator;

public class Exercise<T> implements Iterable<T> {

	private T[] values;
	int index;

	public Exercise() {
		values = (T[]) new Object[0];// 支持任意类型
		index = 0;
	}

	public void add(T value) {
		values = Arrays.copyOf(values, values.length + 1);
		values[values.length - 1] = value;
	}

	public T get(int index) {
		if (index < values.length) {
			return values[index];
		}
		return null;
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return index < values.length;
			}

			@Override
			public T next() {
				return Exercise.this.values[index];
			}

			@Override
			public void remove() {

			}

		};
	}
	
	
}
