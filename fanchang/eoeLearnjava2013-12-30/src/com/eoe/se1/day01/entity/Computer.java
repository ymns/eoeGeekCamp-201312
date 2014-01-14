package com.eoe.se1.day01.entity;

import com.eoe.oop.day03.usb.USB;

public class Computer {
	public USB[] usbs=new USB[4];
	private Memory memory;
	private Cpu cpu;
	private Disk disk;
	
	public Computer() {
		memory=new Memory();
		cpu=new Cpu();
		disk=new Disk();
	}
	public void start(){
		memory.read();
		memory.write();
		cpu.read();
		cpu.write();
		disk.read();
		disk.write();
	}
	//运行接口外设
	public void run(){
		for (USB usb:usbs) {    //usbs数组每一个元素循环引用
			if (usb!=null) {
				usb.read();
				usb.write();
			}
		}
	}
	//代表计算机内存的内部类
	public class Memory implements USB{
		@Override
		public void read() {
			System.out.println("内存读取外设的数据");
			
		}
		@Override
		public void write() {
			System.out.println("将内存中的数据保存至外部磁盘");
			
		}
	}
	//代表计算机cpu的内部类
	public class Cpu implements USB{
		@Override
		public void read() {
			System.out.println("cpu读取指令");
			
		}@Override
		public void write() {
			System.out.println("cpu发送指令");

		}
	}
	//代表计算机disk的内部类
	public class Disk implements USB{
		@Override
		public void read() {
			System.out.println("硬盘读取传来的数据");
			
		}@Override
		public void write() {
			System.out.println("硬盘保存传来的数据");
			
		}
	}
		
}
