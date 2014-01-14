package com.eoe.oop.day03;

import com.eoe.oop.day03.entity.Student;
import com.eoe.oop.day03.entity.Person;
import com.eoe.oop.day03.entity.Teacher;

public class Test_people {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1=new Person();
		p1.setName("刘亦菲");
		p1.setAge(300);
		p1.setSex('b');
		p1.setHeight(3.1);
		p1.setType("温柔的");
		p1.say();
		p1.feeling("我找到好工作了","哈哈!");
		
		Student s1=new Student("王菲",'女',21,1.75,"温柔的","极客学院","1205");
		s1.say();
		s1.doing();
		
		Teacher t1=new Teacher("张飞",'男',28,1.99,"暴躁的","极客学院","讲师");
		t1.say();
		t1.doing();
		
	}

}
