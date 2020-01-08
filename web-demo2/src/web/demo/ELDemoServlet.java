package web.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.demo.model.Student;

/**
 * Servlet implementation class ELDemoServlet
 */
@WebServlet("/el")
public class ELDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELDemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("Vishwajeet", "Vishwajeet@gmail.com", "123", "Java"));
		studentList.add(new Student("Ishaan", "Ishaan@gmail.com", "123", "Java"));
		studentList.add(new Student("Vineeth", "Vineeth@gmail.com", "123", "Java"));
		studentList.add(new Student("Yash", "Yash@gmail.com", "123", "Java"));
		
		request.setAttribute("students", studentList);
		
		request.getRequestDispatcher("student.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
