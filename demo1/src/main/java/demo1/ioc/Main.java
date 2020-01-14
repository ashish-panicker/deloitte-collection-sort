package demo1.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
//		Color red = ctx.getBean("color", Color.class);
//		red.setPaint("red");
		
		Circle circle = ctx.getBean("circle", Circle.class);
//		circle.setColor(red);
		circle.draw();
		
	}
}
