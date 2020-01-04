package hb.demo4.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class EmployeeDao {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public List<Employee> findAll(){
		List<Employee> employees = null;
		String query = "select e from Employee e";
		try(Session session = getSessionFactory().openSession()){
			Query<Employee> empFindAllQry =  session.createQuery(query, Employee.class);
			employees = empFindAllQry.getResultList();
		}
		return employees;
	}
	
	public List<Employee> findEmployeeByDepartment(int deptId){
		List<Employee> employees = null;
		String query = "select e from Employee e "
				+ " where e.departmentId = :deptId";
		try(Session session = getSessionFactory().openSession()){
			Query<Employee> findByDept =  session.createQuery(query, Employee.class);
			findByDept.setParameter("deptId", deptId);
			employees = findByDept.getResultList();
		}
		return employees;
	}
	
	
	public Employee findOne(long id) {
		return null;
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
