
public class Reader implements Observer{
	private String name;
	
	public Reader(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public void update(String message) {
		System.out.println(name+"收到订阅的新闻更新："+message);
	}
	
}
