package demo1.ioc;

public class Circle implements Shape {
	
	private Color color;

	public void area() {
		System.out.println("Area = 3.14 * (radius * radius)");
	}

	public void draw() {
		System.out.println("Cricle with " + color.getPaint() + " paint.");
	}

}
