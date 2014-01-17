package com.eoe.se1.day04.entity;

import java.util.Arrays;
import java.util.Iterator;

public class Arraylist_<T> implements Iterable<T> {

	private T[] values;
	private int index;

	public Arraylist_() {
		values = (T[]) new Object[0];
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

	public int size() {
		return values.length;
	}

	@Override
	public Iterator<T> iterator() {
		index=0;
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return index < values.length;
			}

			@Override
			public T next() {
				if (index<values.length) {
					return values[index++];
				}
				return null;
			}

			@Override
			public void remove() {	
				values = Arrays.copyOf(values, index);
			}
		};

	}

}
