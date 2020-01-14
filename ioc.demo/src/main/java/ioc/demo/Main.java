package ioc.demo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {

	public static void main(String[] args) {
//		XmlBeanFactory factory = 
//				new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
//		Greeting g =  factory.getBean("greeting",Greeting.class);
//		g.greet();
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Greeting g =  ctx.getBean("greeting", Greeting.class);
		g.setName("Ashish");
		g.greet();
	}

}
