package com.eoe.oop.day03.entity;

public class Polymorphic {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		//定义一个数组,Person类
		Person[] people=new Person[4];
		people[0]=new Student("张小飞",'男',23,1.78,"狂放的",
				"eoe极客训练营","1205"); 
		people[1]=new Teacher("王菲",'女',28,1.68,"温柔的",
				"eoe极客训练营","1205");
		people[2]=new Student("李伟",'男',17,1.98,"疯狂的",
				"eoe极客训练营","1205");
		people[3]=new Teacher("粱文疯",'男',55,1.68,"狂妄的",
				"eoe极客训练营","1205");
		for (int i = 0; i < people.length; i++) {
			people[i].say();
			people[i].doing();

		}
	}

}
