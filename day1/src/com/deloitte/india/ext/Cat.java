package com.deloitte.india.ext;

public class Cat extends Animal{
	
	public Cat() {
		System.out.println("Cat Class constructor executed...");
		System.out.println("Printing classification from Cat class: " + classification);
	}

	@Override
	protected void foodHabit() {
		// TODO Auto-generated method stub
		
	}

}
