package web.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet(urlPatterns = "/update", initParams = {
		@WebInitParam(name = "batches", value = "Java ,Python , Informatica ,Testing, "
				+ "Big Data ,Machine Learning") })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");

		String sql = "select *  from web_students where email = ?";

		ServletContext ctx = getServletContext();

		String url = ctx.getInitParameter("url");
		String userName = ctx.getInitParameter("userName");
		String password = ctx.getInitParameter("password");

		ServletConfig config = getServletConfig();
		String options = config.getInitParameter("batches");
		String[] optionArr = options.split(",");

		try {
			DriverManager.registerDriver(new OracleDriver());
			try (Connection conn = DriverManager.getConnection(url, userName, password)) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, email.trim());
				ResultSet rs = stmt.executeQuery();
				PrintWriter out = response.getWriter();
				out.println("<!doctype html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Update Page</title>");
				out.println("</head>");
				out.println("<body>");

				if (rs.next()) {
					out.println("<form method='post' action='update'>");

					out.println(
							"Email: <input type='hidden' name='oldEmail' value='" + email + "' /> ");
					
					out.println(
							"Name: <input type='text' name='name' value='" + rs.getString(1) + "' required/> <br>");
					out.println(
							"Email: <input type='email' name='email' value='" + rs.getString(2) + "' required/> <br>");
					out.println(
							"Phone: <input type='text' name='phone' value='" + rs.getString(3) + "' required/> <br>");

					out.println("Batch type: <select name='option'>");

					for (String str : optionArr) {
						out.println("<option value='" + str.trim() + "'>" + str.trim() + "</option>");
					}
					out.println("</select><br>");
					out.println("<button type='submit'>Update</button>");
					out.println("</form>");

				}

				out.println("</body>");
				out.println("</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String oldEmail = request.getParameter("oldEmail");
		String sql = "update  web_students "
				+ "set name = ?, email = ?, phone = ?, batch = ? where email = ?";

		ServletContext ctx = getServletContext();

		String url = ctx.getInitParameter("url");
		String userName = ctx.getInitParameter("userName");
		String password = ctx.getInitParameter("password");

		ServletConfig config = getServletConfig();
		String options = config.getInitParameter("batches");
		String[] optionArr = options.split(",");
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			try (Connection conn = DriverManager.getConnection(url, userName, password)) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String option = request.getParameter("option");
				
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, phone);
				stmt.setString(4, option);
				stmt.setString(5, oldEmail);
				
				int res = stmt.executeUpdate();
				
				request.getRequestDispatcher("viewall").forward(request, response);

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
