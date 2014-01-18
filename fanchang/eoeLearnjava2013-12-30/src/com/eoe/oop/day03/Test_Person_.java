package com.eoe.oop.day03;

import com.eoe.oop.day03.entity.Person_;
import com.eoe.oop.day03.entity.Student_;

public class Test_Person_ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person_[] people = new Person_[4];
		people[0] = new Student_("李明", '男', 25, 1.55, "豪放的", "极客学院", "1205");
		people[1] = new Student_("阿斯蒂芬", '男', 25, 1.55, "暴躁的", "极客学院", "1205");
		people[2] = new Student_("霸气", '男', 25, 1.55, "温柔的", "极客学院", "1205");
		people[3] = new Student_("撒旦", '男', 25, 1.55, "调皮的", "极客学院", "1205");
		for (int i = 0; i < people.length; i++) {
			people[i].say();
			people[i].doing();
			System.out.println();
		}
	}

}
