package com.deloitte.india.ext;

import com.deloitte.india.Test;

public class Main {

	public static void main(String[] args) {

		/*
		 * System.out.println("Welcome from STS.");
		 * 
		 * Test t = new Test(4.356); Test t2 = new Test(3.22);
		 * 
		 * System.out.println("Value = " + t.var); System.out.println(Test.description);
		 */
		
//		Lion l = new Lion();
//		l.foodHabit();
		
		Elephant e = new Elephant("Herbivoure");
		e.foodHabit();
		e.someMethod();
	}

}
