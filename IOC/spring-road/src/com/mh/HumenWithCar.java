package com.mh;

public abstract class HumenWithCar implements Humen{
	protected Car car;
	
	public HumenWithCar(Car car) {
		this.car = car;
	}
	@Override
	public abstract void goHome();

}
