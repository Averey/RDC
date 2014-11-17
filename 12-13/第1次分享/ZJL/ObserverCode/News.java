import java.util.ArrayList;


public class News implements Subject{
	private ArrayList<Observer> observers;
	private String message;
	
	public News(){
		observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o:observers){
			o.update(message);
		}
		
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public static void main(String[] args) {
		News n = new News();
		Reader r1 = new Reader("1");
		Reader r2 = new Reader("2");
		Reader r3 = new Reader("3");
		
		n.addObserver(r3);
		n.addObserver(r2);
		n.addObserver(r1);
		
		n.setMessage("hi，欢迎订阅新闻");
		n.notifyObservers();
		
		System.out.println("一天后。。。");
		n.setMessage("有新新闻啦");
		n.notifyObservers();
		
		n.removeObserver(r2);
		System.out.println("2天后(r2已退定新闻)。。。");
		n.setMessage("第二天的新闻");
		n.notifyObservers();
	}
}
