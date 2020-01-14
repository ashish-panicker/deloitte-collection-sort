package demo3.db;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class)) {
			DbDao dao = ctx.getBean(DbDao.class);
			try {
				dao.getAllStudents();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
