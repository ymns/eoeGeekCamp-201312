package com.eoe.pre.day03.action;

public class Test08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Action[] actions=new Action[4];
		actions[0]=new Car();
		actions[1]=new Computer();
		actions[2]=new Company();
		actions[3]=new Player();
		for(Action action:actions){
			action.run();
		}
	}

}
