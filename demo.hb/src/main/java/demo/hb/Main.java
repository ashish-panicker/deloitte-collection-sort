package demo.hb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.hb.config.AppConfig;
import demo.hb.config.model.Student;
import demo.hb.config.service.StudentService;

public class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class)) {
			 
			StudentService service = ctx.getBean(StudentService.class);
			List<Student> students = service.findAll();
			
			for (Student student : students) {
				System.out.println(student);
			}
		}
		
	}

}
