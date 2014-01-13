package com.eoe.oop.day03;

import com.eoe.oop.day03.action.Action;
import com.eoe.oop.day03.action.Car;
import com.eoe.oop.day03.action.Company;
import com.eoe.oop.day03.action.Computer;
import com.eoe.oop.day03.action.Player;

public class Test_action {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Action[] action=new Action[4];
		action[0]=new Car();
		action[1]=new Company();
		action[2]=new Computer();
		action[3]=new Player();
		for (int i = 0; i < action.length; i++) {
			action[i].run();
		}

	}

}
