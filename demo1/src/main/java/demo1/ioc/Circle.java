package demo1.ioc;

import org.springframework.beans.factory.annotation.Autowired;

public class Circle implements Shape {
	
	@Autowired
	private Color color;

	public Circle() {
		System.out.println("Circle class constructor.");
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void area() {
		System.out.println("Area = 3.14 * (radius * radius)");
	}

	public void draw() {
		System.out.println("Cricle with " + color.getPaint() + " paint.");
	}

	public void init() {
		System.out.println("Cricle class init method.");
	}

	public void destroy() {
		System.out.println("Cricle class destroy method.");
	}
}
