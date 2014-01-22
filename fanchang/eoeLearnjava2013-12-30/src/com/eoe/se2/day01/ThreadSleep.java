package com.eoe.se2.day01;

public class ThreadSleep {
	public static void main(String[] args) {
		MyThread t = new MyThread("梁文峰");
		t.start();
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + "zZZ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class MyThread extends Thread {
		public MyThread() {
			// TODO Auto-generated constructor stub
		}

		public MyThread(String name) {
			this.setName(name);
		}

		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				System.out.println(this.getName() + "zZZ");
				try {
					Thread.sleep(500);// checked类型的异常
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
