package web.demo.hb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.demo.hb.model.StudentDao;
import web.demo.hb.model.Student;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String phone = request.getParameter("phone").trim();
		String batch = request.getParameter("batch").trim();
		
		Student s = new Student(name, email, phone, batch);
		StudentDao dao = new StudentDao();
		dao.create(s);
		List<Student> students = dao.findAll();
		
		request.setAttribute("students", students);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
