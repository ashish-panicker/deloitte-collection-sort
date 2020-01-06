package web.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = { "/register" }, initParams = {
		@WebInitParam(name = "batches", value = "Java ,Python , Informatica ,Testing, "
				+ "Big Data ,Machine Learning") })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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

		String options = "";
		ServletConfig config = getServletConfig();
		options = config.getInitParameter("batches");
		String[] optionArr = options.split(",");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Register Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='register'>");

		out.println("Name: <input type='text' name='name' required/> <br>");
		out.println("Email: <input type='email' name='email' required/> <br>");
		out.println("Phone: <input type='text' name='phone' required/> <br>");

		out.println("Batch type: <select name='option'>");

		for (String str : optionArr) {
			out.println("<option value='" + str.trim() + "'>" + str.trim() + "</option>");
		}
		out.println("</select><br>");
		out.println("<button type='submit'>Register</button>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String option = request.getParameter("option");

		String sql = "insert into web_students values (?, ?, ?, ?)";

		ServletContext ctx = getServletContext();

		String url = ctx.getInitParameter("url");
		String userName = ctx.getInitParameter("userName");
		String password = ctx.getInitParameter("password");
		

		try {
			DriverManager.registerDriver(new OracleDriver());
			try (Connection conn = DriverManager.getConnection(url, userName, password)) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, phone);
				stmt.setString(4, option);
				int res = stmt.executeUpdate();

//				response.setContentType("text/html");
//				PrintWriter out = response.getWriter();
//				out.println("<h2>" + res + " row(s) got inserted.</h2> ");
//				out.println("<a href='viewall'>Show All Data</a>");
				
				request.getRequestDispatcher("viewall").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
