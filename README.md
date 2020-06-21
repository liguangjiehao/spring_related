csdn博客地址：[liguangjiehao](https://blog.csdn.net/weixin_42763504/article/details/105758352)

#### 一.Spring概述
##### 1. spring简介
1. 简介
> Spring 是分层的 full-stack（全栈） 轻量级开源框架，以 IoC 和 AOP 为内核，提供了展现层 Spring
MVC 和业务层事务管理等众多的企业级应⽤技术，还能整合开源世界众多著名的第三⽅框架和类库，已
经成为使⽤最多的 Java EE 企业应⽤开源框架。

##### 2. spring核心结构
1. 结构
> Spring是⼀个分层⾮常清晰并且依赖关系、职责定位⾮常明确的轻量级框架，主要包括⼏个⼤模块：数据处理模块、Web模块、AOP（Aspect Oriented Programming）/Aspects模块、Core Container模块
和 Test 模块


#### 二.核心思想
##### 1.IOC
1. IOC(控制反转)是⼀个技术思想，不是⼀个技术实现
2. 描述的事情：Java开发领域对象的创建，管理的问题
3. 传统开发⽅式
> ⽐如类A依赖于类B，往往会在类A中new⼀个B的对象
4. IoC思想下开发⽅式
> 我们不⽤⾃⼰去new对象了，⽽是由IoC容器（Spring框架）去帮助我们实例化对象并且管理它，我们需要使⽤哪个对象，去问IoC容器要即可

5. 控制反转
> 控制：指的是对象创建（实例化、管理）的权利
> 反转：控制权交给外部环境了（spring框架、IoC容器）

6. 关系图例: (From : 拉勾)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200621162234765.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mjc2MzUwNA==,size_16,color_FFFFFF,t_70)
7. IOC解决的问题
> 解决对象之间的耦合问题

8. IOC和DI的区别
(1). DI: 依赖注入
(2). IOC和DI描述的是同⼀件事情，只不过⻆度不⼀样罢了
(3). 图例 (From: 拉勾)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200621164205786.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mjc2MzUwNA==,size_16,color_FFFFFF,t_70)
##### 2.AOP
1. AOP ： ⾯向切⾯编程/⾯向⽅⾯编程
2. OOP ： 三⼤特征：封装、继承和多态，是一种垂直继承体系
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020062117151787.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mjc2MzUwNA==,size_16,color_FFFFFF,t_70)
(2). OOP无法解决的问题
> OOP编程思想可以解决⼤多数的代码重复问题，但是有⼀些情况是处理不了的，⽐如下⾯的在顶级⽗类
Animal中的多个⽅法中相同位置出现了重复代码，OOP就解决不了

(3). 代码

```java
public class Animal {
	
	private String height ;
	private float weight ;

	public void eat() {
		//性能监控代码 =====> 横切逻辑代码
		long start = System.currentTimeMillis();
		
		//业务逻辑代码
		System.out.println("I can eat ....");

		//性能监控代码 =====> 横切逻辑代码
		long end = System.currentTimeMillis();
		System.out.println("执行时长" + (end - start) / 1000f + "s");
	}

}
```
(4). 横切逻辑代码图例 (From : 拉勾)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200621172407702.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mjc2MzUwNA==,size_16,color_FFFFFF,t_70)
(5). 横切逻辑代码问题
> 横切代码重复问题
> 横切逻辑代码和业务代码混杂在⼀起，代码臃肿，维护不⽅便

(6). AOP出场，AOP独辟蹊径提出横向抽取机制，将横切逻辑代码和业务逻辑代码分析
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200621172551973.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mjc2MzUwNA==,size_16,color_FFFFFF,t_70)
3. AOP解决问题
> 在不改变原有业务逻辑情况下，增强横切逻辑代码，根本上解耦合，避免横切逻辑代码重复

#### 三.⼿写实现 IoC 和 AOP
