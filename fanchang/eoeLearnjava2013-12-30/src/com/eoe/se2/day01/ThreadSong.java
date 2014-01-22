package com.eoe.se2.day01;

public class ThreadSong {

	/**
	 * 让线程有序的执行
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Singer singer = new Singer();
		Thread zhangFei = new Thread(singer, "张飞");
		Thread liMing = new Thread(singer, "李明");
		zhangFei.start();
		Thread.sleep(900);
		liMing.start();

	}

	static class Singer implements Runnable {
		String[] song = { "我是一只小小小小鸟", "想要飞也飞不高~~", "寻寻觅觅寻寻觅觅一个温暖的怀抱",
				"这样的要求会不会太高~" };
		int index = 0;

		@Override
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName() + ":"
						+ song[index++ % 4]);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
