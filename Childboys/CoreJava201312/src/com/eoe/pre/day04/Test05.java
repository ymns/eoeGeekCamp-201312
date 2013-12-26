package com.eoe.pre.day04;

public class Test05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建线程执行的任务对象
		DonwloadTask task=new DonwloadTask();
		Thread t=new Thread(task, "下载线程");
		t.start();

	}
	static class DonwloadTask implements Runnable{

		@Override
		public void run() {
			for(int i=1;i<=50;i++){
				System.out.println("MyThread:"+i);
			}
		}
		
	}
}
