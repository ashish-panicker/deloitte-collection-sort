package web.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/viewall")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
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

		String sql = "select * from  web_students ";

		ServletContext ctx = getServletContext();

		String url = ctx.getInitParameter("url");
		String userName = ctx.getInitParameter("userName");
		String password = ctx.getInitParameter("password");

		try {
			DriverManager.registerDriver(new OracleDriver());
			try (Connection conn = DriverManager.getConnection(url, userName, password)) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				PrintWriter out = response.getWriter();
				out.println("<!doctype html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>View Page</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<table>");
				out.println("<thead><tr> " + "<th> Name</th> <th>Email</th> <th>Phone</th> <th>Batch</th> "
						+ "</tr></thead>" + "<tbody>");
				while (rs.next()) {
					out.println("<tr>");

					out.println("<td>");
					out.println(rs.getString(1));
					out.println("</td>");

					String email = rs.getString(2);

					out.println("<td>");
					out.println(email);
					out.println("</td>");

					out.println("<td>");
					out.println(rs.getString(3));
					out.println("</td>");

					out.println("<td>");
					out.println(rs.getString(4));
					out.println("</td>");

					out.println("<td>");
					out.println("<form action='delete' method='get'>");
					out.print("<input type='hidden' name = 'email' value='" + email.trim() + "'/>");
					out.println("<button type='submit'>Delete</button>");
					out.println("</form>");
					out.println("</td>");
					
					out.println("<td>");
					out.println("<form action='update' method='get'>");
					out.print("<input type='hidden' name = 'email' value='" + email.trim() + "'/>");
					out.println("<button type='submit'>Edit</button>");
					out.println("</form>");
					out.println("</td>");

					out.println("</tr>");
				}
				out.println("</tbody>" + "</table>");
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

		doGet(request, response);
	}
}
