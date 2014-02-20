package com.eoe.se2.day13.activity;

import java.util.Scanner;

import com.eoe.se2.day13.view.Button;
import com.eoe.se2.day13.view.EditText;
import com.eoe.se2.day13.view.LinearLayout;
import com.eoe.se2.day13.view.TextView;

public class ReflectFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1-LinearLayout");
		System.out.println("2-TextView");
		System.out.println("3-EditText");
		System.out.println("4-Button");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case 1:
			LinearLayout layout = Factory.getInstance("LinearLayout");
			System.out.println(layout);
			break;
		case 2:
			TextView tv = Factory.getInstance("TextView");
			System.out.println(tv);
			break;
		case 3:
			EditText et = Factory.getInstance("EditText");
			System.err.println(et);
			break;
		case 4:
			Button button = Factory.getInstance("Button");
			System.out.println(button);
			break;
		}
	}

}
