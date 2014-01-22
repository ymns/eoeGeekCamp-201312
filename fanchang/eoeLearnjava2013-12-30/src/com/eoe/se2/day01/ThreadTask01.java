package com.eoe.se2.day01;

import java.util.ArrayList;
import java.util.Scanner;


public class ThreadTask01 {

	/**
	 * 实现一个线程输入数据,另一个线程取出数据的异步操作,并确保数据的正确性
	 * @param args
	 */
	static ArrayList<String>  task=new ArrayList<String>();
	public static void main(String[] args) {
		final Thread t1 =new Thread("t1"){
			String s="";
			@Override
			public void run() {
				while (true) {
					while (task.size()>0) {
						for (int i = 0; i < 100000; i++) {
							s+="a";
						}
						s=task.remove(0);
						if ("q".equals(s)) {
							break;
						}
						System.out.println(this.getName()+":"+s);
					}
					if("q".equals(s)){
						System.out.println("game over!");
						break;
					}
					synchronized (this) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.start();
		Thread t2 =new Thread("t2"){
			@Override
			public void run() {
				while (true) {					
					System.out.println("请输入:");
					String text=new Scanner(System.in).next();
					System.out.println(this.getName()+":"+text);
					task.add(text);
					synchronized (t1) {
						t1.notify();
					}
				}
			}
		};
		t2.setDaemon(true);
		t2.start();
		}				
}
