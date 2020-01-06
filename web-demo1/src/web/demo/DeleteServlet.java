package web.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		
		String sql = "delete from web_students where email = ?";
		
		ServletContext ctx = getServletContext();

		String url = ctx.getInitParameter("url");
		String userName = ctx.getInitParameter("userName");
		String password = ctx.getInitParameter("password");
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			try (Connection conn = DriverManager.getConnection(url, userName, password)) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,email.trim());
				int res = stmt.executeUpdate();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h2>" + res + " row(s) got deleted.</h2> ");
				out.println("<a href='viewall'>Show All Data</a>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
