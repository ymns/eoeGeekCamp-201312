package com.eoe.pre.day03.action;

public class Computer implements Action {

	@Override
	public void run() {
		System.out.println(Action.COMPUTER+"正在运行程序...");
	}

}
