package com.eoe.oop.day03;


import com.eoe.oop.day03.action.Action;
import com.eoe.oop.day03.car.Car;
import com.eoe.oop.day03.car.Motion;

public class Test_car {

	/**
	 * 测试car
	 * @param args
	 */
	public static void main(String[] args) {
		Car c1=new Car("宝马",500000);
		System.out.println("价格:"+c1.getPrice());
		c1.run();
		c1.stop();
		Car c2=new Car("奔驰",250000);
		System.out.println("价格:"+c2.getPrice());
		c2.run();
		c2.stop();
		Motion motion=new Car("法拉利",8000000);
		motion.run();
		motion.stop();
		if (motion instanceof Car) {
			System.out.println("价格:"+((Car)motion).getPrice());
		}
		Action action=new Car("现代",130000);
		action.run();
		if (action instanceof Car) {   //需要进行强转
			((Car)action).stop();
			System.out.println("价格:"+((Car)action).getPrice());
		}				
	}

}
