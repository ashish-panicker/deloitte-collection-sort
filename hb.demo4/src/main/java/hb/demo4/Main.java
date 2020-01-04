package hb.demo4;

import java.util.List;

import hb.demo4.model.Employee;
import hb.demo4.model.EmployeeDao;

public class Main {

	public static void main(String[] args) {
		
		EmployeeDao empDao = new EmployeeDao();
		
		List<Employee> employees =  empDao.findEmployeeByDepartment(50);
		
		for (Employee emp : employees) {
			System.out.println(emp);
		}

		EmployeeDao.shutdown();
	}

}
