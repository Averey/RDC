###代理模式
#####代理模式的结构
　　所谓代理，就是一个人或者机构代表另一个人或者机构采取行动。在一些情况下，一个客户不想或者不能够直接引用一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。
　　
　　在代理模式中的角色：

　　●　　抽象对象角色：声明了目标对象和代理对象的共同接口，这样一来在任何可以使用目标对象的地方都可以使用代理对象。

　　●　　目标对象角色：定义了代理对象所代表的目标对象。

　　●　　代理对象角色：代理对象内部含有目标对象的引用，从而可以在任何时候操作目标对象；代理对象提供一个与目标对象相同的接口，以便可以在任何时候替代目标对象。代理对象通常在客户端调用传递给目标对象之前或之后，执行某个操作，而不是单纯地将调用传递给目标对象。



######抽象对象角色
	
	public abstract class AbstractObject {
	    //操作
	    public abstract void operation();
	}
	
######目标对象角色		
	public abstract class AbstractObject {
	    //操作
	    public abstract void operation();
	}
	
######代理对象角色	

	public abstract class AbstractObject {
    //操作
    public abstract void operation();
	}
	
######客户端
	public class Client {

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        AbstractObject obj = new ProxyObject();
	        obj.operation();
	    }
	}
	