package com.deloitte.india.ext;

public abstract class Animal {
	
	protected String classification ;
	
	public Animal() {
		System.out.println("Animal Class constructor #1 executed...");
	}
	
	public Animal(String classification) {
		this();
		this.classification = classification;
		System.out.println("Animal Class constructor #2 executed...");
	}
	protected abstract void foodHabit();

}
