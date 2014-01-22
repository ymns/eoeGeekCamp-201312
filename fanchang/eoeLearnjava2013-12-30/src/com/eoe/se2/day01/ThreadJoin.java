package com.eoe.se2.day01;

public class ThreadJoin {

	/**
	 * join的使用
	 * 
	 * @param args
	 */
	static int result = 0;

	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					result++;
				}
			}
		};
		t.start();
		// System.out.println(result); //结果是0,
		try {
			t.join(); // (子)t线程执行完后才叫由主线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}

}
