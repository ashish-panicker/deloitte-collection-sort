package demo.hb.config.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.hb.config.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	private void init() {
		System.out.println("Student Data access object class created.");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("Student Data access object class is about to be destroyed.");
	}
	
	@Override
	public List<Student> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Student s", Student.class)
				.getResultList();
	}

	@Override
	public void create(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
	}

}
