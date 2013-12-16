package com.eoe.pre.day04;

public class Test06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Song song=new Song();//创建任务对象
		Thread wangfei=new Thread(song, "王菲");
		Thread zhangfei=new Thread(song, "张飞");
		wangfei.start();
		try {
			Thread.sleep(800);
			zhangfei.start(); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//创建任务类
	static class Song implements Runnable{
		String[] songs={
			"我是一支小小小鸟",
			"想要飞也飞不高",
			"我寻寻觅觅，寻寻觅觅一个温暖的怀抱",
			"这样的要求会不会太高"
		};
		int index=0;//指向当前数组元素
		@Override
		public void run() {
			while(true){
				System.out.println(
					Thread.currentThread().getName()+":"+
					songs[index++%songs.length]);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//休眠1000毫秒
//				if(index<3){
//					index++;
//				}else{
//					index=0;
//				}
			}
		}
	}
}
