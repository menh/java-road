package com.mh.myioc;

public class Test {

	private IocContainer iocContainer = new IocContainer();
	
	public void before() {
		iocContainer.setBean(Aodi.class, "aodi");
		iocContainer.setBean(Bieke.class, "bieke");
		iocContainer.setBean(Zhangsan.class, "zhangsan", "aodi");
	}
	
	public void test() {
		Human zhangsan = (Human) iocContainer.getBean("zhangsan");
		zhangsan.goHome();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.before();
		test.test();
	}
}
