##装饰者模式

	###概念： 装饰对象可以在转发这些请求以前或以后增加一些附加功能(来自百度百科)
------------------------------------邪恶分割线----------------------------------

#####被装饰的抽象接口
package Decorator_type;<br/>

public interface Component {<br/>
	public void say();
}

------------------------------------邪恶分割线----------------------------------

#####实现接口的原始类
package Decorator_type;

public class ConcreteComponent implements Component {
	public void say() {
		System.out.println("Hello DesignerPattern！");
	}

}	

------------------------------------邪恶分割线----------------------------------

#####装饰类
package Decorator_type;

public class Decorator implements Component {
	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	public void preSay() {

	}

	public void afterSay() {

	}

	public void say() {
		preSay();
		System.out.println("-------------:" + this.getClass());//观察具体调用哪个类
		System.out.println("-------------:" + component.getClass());
		component.say();
		System.out.println("-------------:" + this.getClass());
		afterSay();
	}

}

------------------------------------邪恶分割线----------------------------------

#####装饰者A
package Decorator_type;

public class DecoratorA extends Decorator {
	private Component component;

	public DecoratorA(Component component) {
		super(component);
	}

	public void preSay() {
		System.out.println("before say");
	}

	public void afterSay() {
		System.out.println("after say");
	}

}

------------------------------------邪恶分割线----------------------------------

#####装饰者B
package Decorator_type;

public class DecoratorB extends Decorator {

	public DecoratorB(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}

	public void preSay() {
		System.out.println("before before say");
	}

	public void afterSay() {
		System.out.println("after after say");
	}
}

------------------------------------邪恶分割线----------------------------------

#####主函数
package Decorator_type;

public class Main {<br/>
	public static void main(String args[]) {<br/>
		Component c = new ConcreteComponent();
		Component d = new DecoratorA(c);
		Component e = new DecoratorB(d);
		e.say();

	}
}

------------------------------------邪恶分割线----------------------------------

####输出结果
before before say
-------------:class Decorator_type.DecoratorB<br/>
-------------:class Decorator_type.DecoratorA<br/>
before say 
-------------:class Decorator_type.DecoratorA<br/>
-------------:class Decorator_type.ConcreteComponent
Hello DesignerPattern！<br/>
-------------:class Decorator_type.DecoratorA
after say<br/>
-------------:class Decorator_type.DecoratorB
after after say

------------------------------------邪恶分割线----------------------------------

####结果分析
	目的是在ConcreteComponent中的say方法前后加入一些功能用以修饰，上述代码在调用e.say()方法时，因为Component是抽象类，
	具体方法在子类中，因为e的本质是DecoratorB,所以会调用DecoratorB的say方法，但是并
没有这个方法，所以去父类Decorator中寻找并调用，在Decorator的say方法中又调用了Component的say方法，
重复了以上的操作。故出现以上的结果。

