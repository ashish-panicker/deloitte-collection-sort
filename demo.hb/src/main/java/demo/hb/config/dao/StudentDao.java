package demo.hb.config.dao;

import java.util.List;

import demo.hb.config.model.Student;

public interface StudentDao {
	
	public List<Student> findAll();
	
	public void create(Student s);

}
