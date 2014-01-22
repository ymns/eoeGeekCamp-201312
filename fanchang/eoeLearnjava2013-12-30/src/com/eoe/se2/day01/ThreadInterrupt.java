package com.eoe.se2.day01;

public class ThreadInterrupt {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					Thread.sleep(1000 * 10);
					System.out.println("俺睡醒了哦");
				} catch (InterruptedException e) {
					System.out.println("谁吵醒了我 ");
				}
			}
		};
		t1.start();
		// 主线程
		Thread.sleep(1000);// 抛出去
		t1.interrupt();// 唤醒t1
	}

}
