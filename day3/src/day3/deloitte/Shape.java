package day3.deloitte;

import java.io.Serializable;

public interface Shape extends Serializable{
	
	void area();
	
	void draw();
	
	default void info() {
		System.out.println("The shape interface.");
	}

}
