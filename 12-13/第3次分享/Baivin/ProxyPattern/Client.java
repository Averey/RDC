package Proxy_type;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealObject o = new RealObject();
		AbstractObject obj = new ProxyObject(o);
		obj.operation();
	}

}