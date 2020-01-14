package demo.hb.config.service;

import java.util.List;

import demo.hb.config.model.Student;

public interface StudentService {

	public List<Student> findAll();

	public void create(Student s);

}
