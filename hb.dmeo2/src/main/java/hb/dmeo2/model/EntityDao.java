package hb.dmeo2.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EntityDao {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public void createStudent(Student s) {

		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(s);
			session.getTransaction().commit();
		}

	}

	public void createTeacher(Teacher t) {
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
		}
	}

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
}
