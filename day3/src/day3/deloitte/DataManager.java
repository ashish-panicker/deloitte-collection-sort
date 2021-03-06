package day3.deloitte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	public void nameSort() {
		Collections.sort(teachers, new NameSort());
	}
	
	public void emailSort() {
		Collections.sort(teachers,new Comparator<Teacher>() {
			public int compare(Teacher o1, Teacher o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			}
		} );
	}
	
	class NameSort implements Comparator<Teacher>{

		@Override
		public int compare(Teacher o1, Teacher o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}

}
