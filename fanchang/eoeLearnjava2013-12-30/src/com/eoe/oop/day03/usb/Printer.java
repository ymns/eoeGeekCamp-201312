package com.eoe.oop.day03.usb;

public class Printer implements USB {

	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println(USB.PRINTER+"获取主机发送的打印内容");

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println(USB.PRINTER+"在打印纸上打印");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
