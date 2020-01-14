package demo.hb.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "demo.hb.config" })
@PropertySource(value = { "classpath:hb.properties" })
public class AppConfig {

	@Autowired
	private Environment env;

	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan("demo.hb.config.model");
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("oracle.db.driver.class"));
		ds.setUrl(env.getRequiredProperty("oracle.db.url"));
		ds.setUsername(env.getRequiredProperty("oracle.db.username"));
		ds.setPassword(env.getRequiredProperty("oracle.db.password"));
		return ds;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", env.getRequiredProperty("hb.dialect"));
		props.put("hibernate.show_sql", env.getRequiredProperty("hb.show.sql"));
		props.put("hibernate.format_sql", env.getRequiredProperty("hb.format.sql"));
		props.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hb.hbm2ddl.auto"));
		return props;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory.getObject());
		return transactionManager;
	}
}
