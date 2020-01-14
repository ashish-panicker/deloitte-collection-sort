package demo3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import oracle.jdbc.driver.OracleDriver;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

	@Autowired
	private OracleDriver driver;
	
	@Autowired
	private Environment env;
	
	@PostConstruct
	private void printValues() {
		System.out.println("Username -> " + env.getProperty("oracle.db.userName") + 
				" \nPassword -> " + env.getProperty("oracle.db.password"));
		System.out.println("URL -> " + env.getProperty("oracle.db.url"));
	}

	@Bean
	public OracleDriver getOracleDriver() {
		return new OracleDriver();
	}

	@Bean
	public Connection getConnection() throws SQLException {
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection(
				env.getProperty("oracle.db.url"), 
				env.getProperty("oracle.db.userName"), 
				env.getProperty("oracle.db.password")
		);
	}
	
	@Bean
	public DbDao getDao() {
		return new DbDao();
	}

}
