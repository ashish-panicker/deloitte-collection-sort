package web.demo.hb.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StudentDao {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	
	public void create(Student s) {
		try(Session session = getSessionFactory().openSession()){
			
			session.getTransaction().begin();
			session.save(s);
			session.getTransaction().commit();
		}
	}
	
	public Student delete(String email) {
		Student s = null;
		try(Session session = getSessionFactory().openSession()){
			s = findOne(email);
			session.getTransaction().begin();
			session.delete(s);
			session.getTransaction().commit();
		}
		return s;
	}
	
	public Student update(Student s) {
		try(Session session = getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.update(s);
			session.getTransaction().commit();
		}
		return s;
	}
	
	public Student findOne(String email) {
		Student s = null;
		try(Session session = getSessionFactory().openSession()){
			s = session.get(Student.class, email);
		}
		return s;
	}
	
	public List<Student> findAll(){
		String query = "from Student s";
		List<Student> students = null;
		try(Session session = getSessionFactory().openSession()){
			students = session.createQuery(query, Student.class).getResultList();
		}
		return students;
	}

}
