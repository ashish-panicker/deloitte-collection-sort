package day3.deloitte;

import java.io.Serializable;

public class Circle implements Shape{

	@Override
	public void area() {
		System.out.println("pi * r * r");
	}

	@Override
	public void draw() {
		System.out.println("circle..");
	}

	@Override
	public void info() {
		System.out.println("The circle interface.");
	}
}
