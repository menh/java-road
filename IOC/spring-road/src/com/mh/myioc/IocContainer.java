package com.mh.myioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ʵ����bean
 * ����bean
 * �ṩbean
 * ÿһ��bean����Ψһ��id��֮��Ӧ
 * @author ASUS
 *
 */
public class IocContainer {

	private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();
	
	/***
	 * ����beanId ��ȡ��Ӧ��bean
	 * @param beanId
	 * @return bean
	 */
	public Object getBean(String beanId) {
		return beans.get(beanId);
	}
	
	/***
	 * ί��IOC����һ��bean
	 * @param clazz Ҫ����bean��class
	 * @param beanId
	 * @param paramBeanIds Ҫ������bean��class�Ĺ��췽������Ҫ�Ĳ�����beanId
	 */
	public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
		
		//1. ��װ���췽������Ҫ�Ĳ���ֵ
		Object[] paramValues = new Object[paramBeanIds.length];
		for(int paramValues_i = 0; paramValues_i < paramValues.length; paramValues_i++) {
			paramValues[paramValues_i] = beans.get(paramBeanIds[paramValues_i]);
		}
		
		//2. ���ù��췽��ʵ����bean
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
			throw new RuntimeException("�Ҳ������ʵĹ��췽��ȥʵ����bean");
		}
		beans.put(beanId, bean);
	}
	
}
