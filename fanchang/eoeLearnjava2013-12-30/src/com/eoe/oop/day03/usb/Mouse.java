package com.eoe.oop.day03.usb;

public class Mouse implements USB {

	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println(USB.MOUSE + "鼠标接受用户的移动,点击操作");

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println(USB.MOUSE + "鼠标将用户的移动,点击操作发送至主机");

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "鼠标";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
