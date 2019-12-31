package day3.deloitte;

public class Square implements Shape{
	
	@Override
	public void area() {
		System.out.println(" a * a");
	}

	@Override
	public void draw() {
		System.out.println("square");
	}

}
