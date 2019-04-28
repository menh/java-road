###### IOC
IOC (Inversion Of Control) 即控制反转
控制指 控制javabean对象的声明周期
反转指 将对象的控制权交给IOC

1. 所有的Bean的生命周期交由IoC容器管理
2. 所有被依赖的Bean通过构造方法执行注入
3. 被依赖的Bean需要优先创建
