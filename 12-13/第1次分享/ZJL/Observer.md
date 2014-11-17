##观察者模式
> 定义：观察者模式:定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新  

####个人总结：  
1. **对观察者模式的理解：** 利用接口和多态的好处来实现一个观察者（Observer）和一个被观察者（Subject或Observerable）实现松耦合。  
主要思路，在被观察者里**维持一个数据结构（一般为列表）来记录注册的观察者**。在状态改变并需要通知观察者们时，（一般定义名为notifyObserver方法）循环保存了观察者们的数据结构并调用它们的**统一方法**（在Observer接口定义的方法,统一方法名方便调用，此为关键）来通知它们。  

2. 使用范围：使用于大多数有一对多关系的场景。比如，天气预报通知，报纸订阅，QQ群消息模型；javaBeans，Swing也实现了观察者模式。

##代码例子
> 此例子用观察者模式来实现新闻的订阅  

创建一个subject接口
  
    public interface Subject {
		public void addObserver(Observer o);
		public void removeObserver(Observer o);
		public void notifyObservers();
	}
	
创建一个Observer接口  
    
    public interface Observer {
		public void update(String message);
    }  
   
 创建读者  
     
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

 
创建一个具体的News(包含测试代码)  
    
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

	
运行news的测试数据得：  

> 3收到订阅的新闻更新：hi，欢迎订阅新闻
	2收到订阅的新闻更新：hi，欢迎订阅新闻
	1收到订阅的新闻更新：hi，欢迎订阅新闻
	一天后。。。
	3收到订阅的新闻更新：有新新闻啦
	2收到订阅的新闻更新：有新新闻啦
	1收到订阅的新闻更新：有新新闻啦
	2天后(r2已退定新闻)。。。
	3收到订阅的新闻更新：第二天的新闻
	1收到订阅的新闻更新：第二天的新闻

	- - - - -
备注：时间原因只实现了观察者模式的push的推送模式还有一种pull模式没实现，下星期不上～～