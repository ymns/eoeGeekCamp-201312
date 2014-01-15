package com.eoe.oop.day03.usb;

public interface USB {
	public static final String UDISK = "U盘";
	public static final String MOUSE = "鼠标";
	public static final String KEYBOARD = "键盘";
	public static final String PRINTER = "打印机";

	void read(); // 读

	void write(); // 写

}
