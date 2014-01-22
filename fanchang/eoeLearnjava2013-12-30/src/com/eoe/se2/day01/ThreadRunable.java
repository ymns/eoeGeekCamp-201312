package com.eoe.se2.day01;

public class ThreadRunable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunableImp target = new RunableImp();
		Thread zhangFei = new Thread(target, "张飞");
		Thread liMing = new Thread(target, "李明");
		Thread liuYiFei = new Thread(new Runnable() { // Runable接口的实现类对象
					// 匿名内部类
					@Override
					public void run() {
						for (int i = 0; i < 10; i++) {
							System.out.println(Thread.currentThread() + ":" + i);
						}

					}
				}, "刘亦菲");
		zhangFei.start();
		liMing.start();
		liuYiFei.start();
	}

	static class RunableImp implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + ":" + i);
			}
		}

	}

}
