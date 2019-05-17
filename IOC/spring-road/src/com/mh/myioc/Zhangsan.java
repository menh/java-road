package com.mh.myioc;

public class Zhangsan extends HumanWithCar{
	public Zhangsan(Car car) {
		super(car);
	}
	

	@Override
	public void goHome() {
		car.start();
		car.turnLeft();
	}

}
