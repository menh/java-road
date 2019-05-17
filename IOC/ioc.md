###### IOC
######## 什么是IOC

IOC (Inversion Of Control) 即控制反转
控制指 控制java bean对象的声明周期
反转指 将对象的控制权交给IOC容器


####### 实现自己的IOC
1. 所有的Bean的生命周期交由IoC容器管理
2. 所有被依赖的Bean通过构造方法执行注入
3. 被依赖的Bean需要优先创建

####### spring Ioc 应用
1. 配置xml的bean配置

spring.xml
```
<bean id = "bean" class = "com.mh.springioc.Bean"> </bean>
```
2. 在代码种获取bean
```
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Bean bean = context.getBean("bean", Bean.class);
		System.out.println(bean);
	}
}
```

##### spring Ioc 实例化bean 方法

1. 通过构造方法实例化bean

2. 通过静态方法实例化bean

3. 通过实例化方式实例化bean

4. Bean 别名
