package com.eoe.pre.day04;

public class Test04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=1;i<=50;i++){
			System.out.println("main thread:"+i);
		}
		new Thread(){
			public void run() {
				for(int i=1;i<=50;i++){
					System.out.println("MyThread:"+i);
				}
			};
		}.start();
		
	}

}
