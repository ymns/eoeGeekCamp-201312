package com.eoe.pre.day03.entity;

import com.eoe.pre.day03.Person;

public class Test06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Person p=new Student("张小飞", '男', 23, 1.89, "快乐的", "eoe", "1312班");
//		p.say();
//		Person p2=new Teacher("张大飞", '男', 33, 1.89, "快乐的", "eoe", "讲师");
//		p2.say();
		//代码的简洁性、一致性，功能的多样性。
		Person_[] people=new Person_[4];
		people[0]=new Student_("张小飞", '男', 23, 1.89, "快乐的", "eoe", "1312班");
		people[1]=new Teacher_("张大飞", '男', 33, 1.89, "快乐的", "eoe", "讲师");
		people[2]=new Student_("王小飞", '男', 23, 1.89, "快乐的", "eoe", "1312班");
		people[3]=new Teacher_("王大飞", '男', 33, 1.89, "快乐的", "eoe", "班主任");
		for(Person_ person:people){
			person.say();
		}
	}

}
