package com.eoe.oop.day03.usb;

public class Keyboard implements USB {

	@Override
	public void read() {
		System.out.println(USB.KEYBOARD + "接受用户的输入数据");
	}

	@Override
	public void write() {
		System.out.println(USB.KEYBOARD + "键盘接受用户的输入数据");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "键盘";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
