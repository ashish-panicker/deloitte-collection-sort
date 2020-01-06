package web.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 */
//@WebServlet(urlPatterns = { "/greeting", "/welcome","/multiply" })
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GreetingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//greet the user.
		
//		String userName = request.getParameter("userName");
//		
//		response.setContentType("text/html");
//		PrintWriter out =  response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Greeting Page</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>" + "Welcome ".concat(userName) + "</h1>");
//		out.println("</body>");
//		out.println("</html>");
//		out.flush();
//		out.close();
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String res = "";
		for (int i = 1; i <= num2; i++) {
			res = res + " " + num1 + " x " + i + " = " +  ( num1 * 1 ) + " <br>"; 
		}
		PrintWriter out =  response.getWriter();
		out.println(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String res = "";
		for (int i = 1; i <= num2; i++) {
			res = res + " " + num1 + " x " + i + " = " +  ( num1 * 1 ) + " <br>"; 
		}
		PrintWriter out =  response.getWriter();
		out.println(res);
	}

}

