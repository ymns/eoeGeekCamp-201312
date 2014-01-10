package com.eoe.oop.day01;

import java.util.Arrays;

public class Test02 {

	/**
	 * 测试Student类
	 * @param args
	 */
	public static void main(String[] args) {
		//第一个学员
				Student student1 = new Student("梁文峰",25,1.7,"豪放的",'男',
						"eoe极客学院","Android1205班");
				student1.say();
				int[] a1={10,5};
				System.out.println(Arrays.toString(a1));
				student1.swap(a1,0,1);
				System.out.println("变");
				System.out.println(Arrays.toString(a1));
				student1.feeling();
				
				
				//第二个学员
				Student student2 = new Student();
				student2.name="高珊";
				student2.sex='女';
				student2.height=1.69;
				student2.age=24;
				student2.type="活泼的";
				student2.inSchool="eoe极客学院";
				student2.inClass="Android1205班";
				student2.say();
				int[] a2={100,1000};
				System.out.println(Arrays.toString(a2));
				student2.swap(a2,0,1);
				System.out.println("变");
				System.out.println(Arrays.toString(a2));
				student2.feeling();

	}

}
