package hb.demo1;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import hb.demo1.model.Book;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		//populate();
		
		List<Book> books = read();
		
		for (Book book : books) {
			System.out.println(book);
		}
		
		shutdown();

	}
	
	public static void populate() {
		create(101, "Halo Envoy", "Eric Nylund", 999);
		create(102, "Halo Envoy", "Eric Nylund", 998);
		create(102, "Halo Smoke And Shadow", "Kelly Gay", 997);
		create(103, "Halo Renegades", "Kelly Gay", 996);
		create(104, "Halo Last Light", "Troy Dennigs", 995);
		create(105, "Halo Silent Storm", "Troy Dennigs", 994);
	}
	
	public static List<Book> read(){
		List<Book> books = null;
		try (Session session = getSessionFactory().openSession()) {
			books = session.createQuery("select b from Book b", Book.class).list();
		}
		return books;
	}

	public static void create(int id, String title, String author, int isbn) {
		Transaction transaction = null;
		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Book b = new Book(id, title, author, isbn);
			session.save(b);
			transaction.commit();
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
