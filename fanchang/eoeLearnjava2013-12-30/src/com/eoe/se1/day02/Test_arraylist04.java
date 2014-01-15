package com.eoe.se1.day02;

import java.util.HashMap;
import java.util.Scanner;

import com.eoe.oop.day03.usb.Keyboard;
import com.eoe.oop.day03.usb.Mouse;
import com.eoe.oop.day03.usb.Printer;
import com.eoe.oop.day03.usb.USB;
import com.eoe.oop.day03.usb.Udisk;

public class Test_arraylist04 {

	/**
	 * @param args
	 */
	// 声明一个HashMap类的usbs变量
	static HashMap<String, USB> usbs;

	public static void main(String[] args) {
		initUsb();
		System.out.println("1-添加外设");
		System.out.println("2-卸载外设");
		System.out.println("3-检测鼠标是否存在");
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("添加" + usbs.get("udisk"));
			System.out.println("添加" + usbs.get("keyboard"));
			System.out.println("添加" + usbs.get("printer"));
			System.out.println("添加" + usbs.get("mouse"));
			break;
		case 2:
			System.out.println("卸载" + usbs.get("printer"));

			break;
		case 3:
			if (usbs.containsKey("udsk")) {
				USB usb = usbs.remove("udisk");
			}
			break;
		default:
			break;
		}
	}

	private static void initUsb() {
		usbs = new HashMap<String, USB>();
		Udisk udisk = new Udisk();
		usbs.put("udisk", udisk);
		Keyboard keyboard = new Keyboard();
		usbs.put("keyboard", keyboard);
		Mouse mouse = new Mouse();
		usbs.put("mouse", mouse);
		Printer printer = new Printer();
		usbs.put("printer", printer);

	}

}
