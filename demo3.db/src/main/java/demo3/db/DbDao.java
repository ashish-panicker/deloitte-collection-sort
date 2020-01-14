package demo3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

public class DbDao {
	
	private String selectQuery ="select * from web_students";
	
	@Autowired
	private Connection conn;
	
	public void getAllStudents() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(selectQuery);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.print(" Name: " + rs.getString("NAME"));
			System.out.print(" Email: " + rs.getString("EMAIL"));
			System.out.print(" Batch: " + rs.getString("BATCH"));
			System.out.print(" Phone: " + rs.getString("PHONE" ));
			System.out.println();
		}
	}

}
