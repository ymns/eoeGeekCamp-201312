package com.eoe.se2.day01;

public class ThreadIsPrime {

	/**
	 * 【示例-12】join()实现线程的同步示例2。 join()用于实现两个线程间同步，实现查找2～200之间所有质数。
	 * (1)定义线程类IsPrime用于判断一个整数是否是质数， 是则isPrime的值为true，不是则值为false。
	 * (2)定义线程类FindPrime线程，调用isPrime线程查找2～200之间的所有质数。
	 * (3)定义静态变量i用于存放被查找的数；isPrime表示变量i的当前值是否使质数。
	 * 为确保线程的同步，将线程isPrime设置为线程FindPrime的子线程。
	 * 
	 * @param args
	 */
	static boolean isPrime;

	public static void main(String[] args) {
		FindPrime findPrime=new FindPrime();
		findPrime.start();
	}
	static class FindPrime extends Thread{
		@Override
		public void run() {
			for (int i = 2; i < 200; i++) {
				isPrime a=new isPrime(i);
				a.start();
				try {
					a.join();//  先执行这个线程
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (isPrime) {
					System.out.println(i);
				}
			}
			
		}
	}
	//检测n是否为质数,结果保存在isPrime变量中
	static class isPrime extends Thread {
		int n;
		public isPrime(int n) {
			this.n=n;
		}
		@Override
		public void run() {
			isPrime=true;
			int k=(int) Math.sqrt(n);
			for (int i = 2; i <= k&&isPrime; i++) {
				isPrime=n%2!=0;
			}
		}
	}

}
