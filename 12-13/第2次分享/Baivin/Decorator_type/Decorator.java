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
		component.say();
		afterSay();
	}

}
