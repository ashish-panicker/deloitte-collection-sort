package day3.deloitte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataManager {
	
	private List<Teacher> teachers;
	
	public DataManager() {
		teachers = new ArrayList<>();
	}
	
	public void add(Teacher t) {
		teachers.add(t);
	}
	
	public void print() {
		for (Teacher t : teachers) {
			System.out.println(t);
		}
	}
	
	public void defaultSort() {
		Collections.sort(teachers);
	}

}
