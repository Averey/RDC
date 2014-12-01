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
