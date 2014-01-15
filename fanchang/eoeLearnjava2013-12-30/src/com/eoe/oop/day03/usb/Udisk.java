package com.eoe.oop.day03.usb;

public class Udisk implements USB {

	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println(USB.UDISK + "读取主机发送的数据");

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println(USB.UDISK + "向主机发送数据");

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "u盘";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
