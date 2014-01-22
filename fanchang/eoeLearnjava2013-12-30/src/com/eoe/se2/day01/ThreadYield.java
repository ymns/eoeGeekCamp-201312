package com.eoe.se2.day01;



public class ThreadYield {

	/**yield()
	 * 当前线程让出处理器,进入Runnable状态等待
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread zhangFei = new MyThread("张飞");
		MyThread liMing=new MyThread("李明");
		MyThread liuYiFei=new MyThread("刘亦菲");
		zhangFei.start();
		liuYiFei.start();
		liMing.start();

	}
	static class MyThread extends Thread{
		public MyThread(String name) {
			setName(name);
		}
		@Override
		public void run() {
			super.run();
			for (int i = 0; i < 10; i++) {
				System.out.println(this.getName()+":"+i);
				yield();
			}
		}
	}

}
