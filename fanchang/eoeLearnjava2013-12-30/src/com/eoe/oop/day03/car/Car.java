package com.eoe.oop.day03.car;

public class Car implements Motion, Product {
	private String name;     //声明车名
	private double price;		//声明价格
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}

	public void setPrice(double price){
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	
	public Car() {
		super();
	}
	public Car(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public void run(){
		System.out.println(this.name+"正在行驶~~");
	}


	@Override
	public void stop() {
		System.out.println(this.name+"刹车");
		
	}
}
