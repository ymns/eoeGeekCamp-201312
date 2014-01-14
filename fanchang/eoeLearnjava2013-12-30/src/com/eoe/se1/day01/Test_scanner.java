package com.eoe.se1.day01;

import com.eoe.oop.day03.usb.USB;
import com.eoe.se1.day01.entity.Computer;

public class Test_scanner {

	/**
	 * 匿名内部类中若使用外部方法的局部变量,则该
	 * 局部变量必须改成常量
	 * @param args
	 */
	static Computer computer=new Computer();
	
	public static void main(String[] args) {
		Test_scanner t=new Test_scanner();
		t.createScanner();
		computer.usbs[0].read();
		computer.usbs[0].write();
	}
	void createScanner(){
		final String scannerName="扫描仪";		
		USB scanner=new USB() {
			@Override
			public void write() {
				//scannerName="打印机";
				System.out.println(scannerName+"将扫描的数据发送至主机");
			}
			
			@Override
			public void read() {
				System.out.println(scannerName+"正在扫描纸质文件");
			}
		};
		computer.usbs[0]=scanner;
	}
	
}

