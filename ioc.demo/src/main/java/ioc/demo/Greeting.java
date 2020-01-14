package ioc.demo;

public class Greeting {
	
	private String name;
	
	public void greet() {
		System.out.println("Welcome from Spring " + name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
