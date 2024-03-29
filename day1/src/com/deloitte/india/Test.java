package com.deloitte.india;

public class Test {

	public int var;
	
	private final double pi = 3.14;
	
	private final double rate ;
	
	public  static String description;
	
	static {
		System.out.println("static block 2 executed..");
	}
	
	static {
		description = "Some sample description...";
		System.out.println("static block 1 executed...");
	}
	
	public Test(double rate){
		
		this.rate = rate;
		
		System.out.println("rate = " + rate);
		
		var = 100;		
		
		System.out.println("constructor executed..");
	}
	
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public long add(int a , long b) {
		return a + b;
	}
	
	public long add(long a, int b) {
		return a + b;
	}
	
	public double area(double r) {
		return pi * (r * r);
	}
		
	public double interest(int p, int n) {
		return (p * n * rate) / 100;
	}
}
