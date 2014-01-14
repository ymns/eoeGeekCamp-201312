package com.eoe.oop.day03.action;

public class Car implements Action {

	@Override
	public void run() {
		System.out.println(Action.CAR+"在行驶~~");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
