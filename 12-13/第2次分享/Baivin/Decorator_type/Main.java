package Decorator_type;

public class Main {
	public static void main(String[] args) {
		Component c = new ConcreteComponent();
		Component d = new DecoratorA(c);
		Component e = new DecoratorB(d);
		e.say();
	}
}
