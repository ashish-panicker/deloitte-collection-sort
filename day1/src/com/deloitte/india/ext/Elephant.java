package com.deloitte.india.ext;

public class Elephant extends Animal{
	
	public Elephant(String classification) {
		super(classification);
		System.out.println("Elephant class constructor executed...");
	}
	
	@Override
	protected void foodHabit() {
		System.out.println("Elephant is a herbivorous animal..");
	}
	
	void someMethod() {
		System.out.println("Some method from elephant class...");
	}

}
