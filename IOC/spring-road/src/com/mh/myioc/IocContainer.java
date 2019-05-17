package com.mh.myioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实例化bean
 * 保存bean
 * 提供bean
 * 每一个bean产生唯一的id与之对应
 * @author ASUS
 *
 */
public class IocContainer {

	private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();
	
	/***
	 * 根据beanId 获取对应的bean
	 * @param beanId
	 * @return bean
	 */
	public Object getBean(String beanId) {
		return beans.get(beanId);
	}
	
	/***
	 * 委托IOC创建一个bean
	 * @param clazz 要创建bean的class
	 * @param beanId
	 * @param paramBeanIds 要创建的bean的class的构造方法所需要的参数的beanId
	 */
	public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
		
		//1. 组装构造方法所需要的参数值
		Object[] paramValues = new Object[paramBeanIds.length];
		for(int paramValues_i = 0; paramValues_i < paramValues.length; paramValues_i++) {
			paramValues[paramValues_i] = beans.get(paramBeanIds[paramValues_i]);
		}
		
		//2. 调用构造方法实例化bean
		Object bean = null;
		for(Constructor<?> constructor : clazz.getConstructors()){
			try {
				bean = constructor.newInstance(paramValues);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(bean == null) {
			throw new RuntimeException("找不到合适的构造方法去实例化bean");
		}
		beans.put(beanId, bean);
	}
	
}
