package web.demo.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListner implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application startup successful.");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application shutdown successful.");
	}

}
