###### IOC
######## ʲô��IOC

IOC (Inversion Of Control) �����Ʒ�ת
����ָ ����java bean�������������
��תָ ������Ŀ���Ȩ����IOC����


####### ʵ���Լ���IOC
1. ���е�Bean���������ڽ���IoC��������
2. ���б�������Beanͨ�����췽��ִ��ע��
3. ��������Bean��Ҫ���ȴ���

####### spring Ioc Ӧ��
1. ����xml��bean����

spring.xml
```
<bean id = "bean" class = "com.mh.springioc.Bean"> </bean>
```
2. �ڴ����ֻ�ȡbean
```
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Bean bean = context.getBean("bean", Bean.class);
		System.out.println(bean);
	}
}
```

##### spring Ioc ʵ����bean ����

1. ͨ�����췽��ʵ����bean

2. ͨ����̬����ʵ����bean

3. ͨ��ʵ������ʽʵ����bean

4. Bean ����
