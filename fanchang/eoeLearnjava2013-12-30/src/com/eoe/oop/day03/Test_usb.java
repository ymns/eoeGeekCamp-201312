package com.eoe.oop.day03;

import com.eoe.oop.day03.usb.Keyboard;
import com.eoe.oop.day03.usb.Mouse;
import com.eoe.oop.day03.usb.Printer;
import com.eoe.oop.day03.usb.USB;
import com.eoe.oop.day03.usb.Udisk;

public class Test_usb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		USB[] usb = new USB[4];
		usb[0] = new Udisk();
		usb[1] = new Mouse();
		usb[2] = new Keyboard();
		usb[3] = new Printer();
		for (int i = 0; i < usb.length; i++) {
			usb[i].read();
			usb[i].write();

		}

	}

}
