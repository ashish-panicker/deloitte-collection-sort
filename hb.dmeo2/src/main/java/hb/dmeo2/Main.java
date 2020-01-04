package hb.dmeo2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import hb.dmeo2.model.EntityDao;
import hb.dmeo2.model.Student;
import hb.dmeo2.model.Teacher;

public class Main {
	
	public static void main(String[] args) {
		
		Teacher t1 = new Teacher(101,"Prem", "prem@gmail.com", "Informatica");
		Teacher t2 = new Teacher(100,"Ashish", "ashish@gmail.com", "Java");
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(3, "Chinmay", "Chinmay@gmail.com"));
		students.add(new Student(4, "Rohan", "Rohan@gmail.com"));
		
		t1.setStudents(students);
		
		EntityDao dao = new EntityDao();
		
		try {
			dao.createTeacher(t1);
		}catch(Exception h) {
			h.printStackTrace();
		}finally {
			EntityDao.shutdown();
		}
		
		
		
	}
	

}
