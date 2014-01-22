package com.eoe.se2.day01;

public class MyThread01 {

	/**
	 * 设置优先级
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread zhangFei = new MyThread("张飞");
		MyThread liMing = new MyThread("李明");
		MyThread liuYiFei = new MyThread("刘亦菲");
		zhangFei.setPriority(Thread.MAX_PRIORITY); // 设置最高优先级
		liMing.setPriority(Thread.NORM_PRIORITY);
		liuYiFei.setPriority(Thread.MIN_PRIORITY);
		zhangFei.start();
		liMing.start();
		liuYiFei.start();
	}

	public static class MyThread extends Thread {
		public MyThread(String name) {
			this.setName(name);
		}

		@Override
		public void run() {
			super.run();
			for (int i = 0; i < 10; i++) {
				System.out.println(this.getName() + ":" + i);
			}
		}
	}

}
