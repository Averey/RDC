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
