package com.mh;

public class Zhangsan extends HumenWithCar{
	public Zhangsan(Car car) {
		super(car);
	}
	

	@Override
	public void goHome() {
		car.start();
		car.turnLeft();
	}

}
