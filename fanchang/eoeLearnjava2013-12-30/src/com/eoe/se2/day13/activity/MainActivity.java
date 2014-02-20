package com.eoe.se2.day13.activity;

import java.util.Scanner;

import com.eoe.se2.day13.gen.R;
import com.eoe.se2.day13.view.View;

public class MainActivity extends Activity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1-创建TextView对象");
		System.out.println("2-创建EditText对象");
		System.out.println("3-创建Button对象");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case 1:
			View tvName = findViewById(R.id.tvName);
			System.out.println(tvName);
			break;
		case 2:
			View etName = findViewById(R.id.etName);
			System.out.println(etName);
			break;
		case 3:
			View btnLogin = findViewById(R.id.btnLogin);
			System.out.println(btnLogin);
			break;
		}
	}

}
