package jdbc1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class Main {
	
	class OrderItem{
		int id;
		int orderId;
		int quantity;
		String name;
		Date orderDate;
		
		public OrderItem(int id, int orderId, int quantity, String name, Date orderDate) {
			this.id = id;
			this.orderId = orderId;
			this.quantity = quantity;
			this.name = name;
			this.orderDate = orderDate;
		}
		
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Main m = (Main)  Class.forName("jdbc1.Main").newInstance();
		m.placeOrder();
	}

	static void emp2() {
		Connection conn = null;
		System.out.println("sjedh");
		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.140:1521:XE", "hr", "hr");
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("update emp2 set ename=? where ecode=?");// it's not working

			// OraclePreparedStatement ps = (OraclePreparedStatement)
			// conn.prepareStatement("update emp set ename=? where ecode=?");
			System.out.println("ssssssssssssssss");

			ps.setString(1, "ashish s");
			ps.setString(2, "123");
			// ps.setFixedCHAR(1, "oo");
			// ps.setFixedCHAR(2, "103");
			int x = ps.executeUpdate();
			System.out.println("" + x);
			conn.commit();
			conn.close();

			/*
			 * Statement sm=conn.createStatement();//it's working int
			 * x=sm.executeUpdate("update emp set ename='ee' where ecode='101'"); int
			 * x=ps.executeUpdate(); System.out.println(""+x); conn.commit(); conn.close();
			 */
			System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void placeOrder() {
		
		Connection conn = null;
		
		List<OrderItem> orderItems = new ArrayList<>();

		String userName = "hr";
		String password = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String query = "insert into table values ( '" + userName +"') ";
		
		try {
			conn = DriverManager.getConnection(url, userName, password);
			conn.setAutoCommit(false);
			
			String orderSql = "insert into orders values ( ?, ?)";
			String orderItemSql = "insert into order_items values ( ?, ?, ?, ?, ? )";
			
			PreparedStatement orderStmt = conn.prepareStatement(orderSql);
			PreparedStatement orderItemStmt = conn.prepareStatement(orderItemSql);
			
			orderStmt.setInt(1, 100);
			orderStmt.setDate(2, new Date(new java.util.Date().getTime()));
			
			orderItems.add(new OrderItem(1, 100, 2, "A Tale of Two Cities", new Date(new java.util.Date().getTime())));
			orderItems.add(new OrderItem(2, 100, 1, "Animal Farm", new Date(new java.util.Date().getTime())));
			orderItems.add(new OrderItem(3, 100, 4, "Life Is What You Make It", new Date(new java.util.Date().getTime())));
			
			for (OrderItem item : orderItems) {
				
				orderItemStmt.setInt(1, item.id);
				orderItemStmt.setInt(2, item.orderId);
				orderItemStmt.setInt(3, item.quantity);
				orderItemStmt.setString(4,item.name);
				orderItemStmt.setDate(5, item.orderDate);
				
				orderItemStmt.addBatch();
			}
			
			int result = orderStmt.executeUpdate();
			
			System.out.println(result + " order(s) inserted.");
			 
			if(result > 0) {
				 int [] batchRes = orderItemStmt.executeBatch();
				for (int i : batchRes) {
					System.out.println(i + " order item(s) inserted.");
				}
				//throw new SQLException("An error occurred after inserting order.");
			}
			conn.commit();
			
		} catch (SQLException e) {
			try {
				System.err.println("Error occurred. Rolling back transaction.");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void createBook() {
		Driver d = null;
		Connection conn = null;

		String userName = "hr";
		String password = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
//			d = new OracleDriver();
//			DriverManager.registerDriver(d);

//			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, userName, password);
			conn.setAutoCommit(false);

			String query = "insert into books values (?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setInt(1, 3);
			stmt.setString(2, "The old man ");
			stmt.setString(3, "Ernest H");
			stmt.setInt(4, 112);

			int result = stmt.executeUpdate();

			System.err.println(result + " row(s) got inserted.");
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	static void getEmployeeByDepartment() {
		Driver d = null;
		Connection conn = null;
		try {
			// Step 1 - load and register the driver
			System.out.println("Loading the driver...");
			d = new OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Loading the driver complete...");
			// Step 2 - establish connection with the database

			System.out.println("Creating the connection...");
			String userName = "hr";
			String password = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("connection to oracle database open...");

			String query = "select employee_id,first_name, last_name from employees " + " where department_id = ?  ";

			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setLong(1, 10);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				System.err.print("Id := " + rs.getInt(1));
				System.err.print(" Name := " + rs.getString("first_name") + " " + rs.getString("last_name") + "\n");
			}

		} catch (SQLException e) {
			System.err.println("Error in executing the program...");
			e.printStackTrace();
		} finally {
			System.out.println("Closing the database connection...");
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Error while closing the connection...");
				e.printStackTrace();
			}
		}
	}

}
