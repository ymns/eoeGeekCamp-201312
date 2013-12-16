package com.eoe.pre.day04;

public class Test03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread myThread=new MyThread();
		myThread.start();
		for(int i=1;i<=10;i++){
			System.out.println("main thread:"+i);
		}
	}
	//自定义了一个线程类
	static class MyThread extends Thread{
		@Override
		public void run() {
			for(int i=1;i<=10;i++){
				System.out.println("MyThread:"+i);
			}
		}
	}
}
