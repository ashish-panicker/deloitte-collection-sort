package com.deloitte.india.ext;

public class Lion extends Cat{
	
	public Lion() {
		System.out.println("Lion Class constructor executed...");
		System.out.println("Printing classification from Lion class: " + classification);
	}
	
	@Override
	protected void foodHabit() {
		System.out.println("Lion is a carnivourous animal...");
	}

}
