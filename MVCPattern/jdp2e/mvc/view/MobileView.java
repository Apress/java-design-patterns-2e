package jdp2e.mvc.view;
import java.util.List;
import jdp2e.mvc.model.Employee;

//This class is added to discuss a question in "Q&A Session"

//MobileView class

public class MobileView implements View
{
	@Override
	public void showEnrolledEmployees(List<Employee> enrolledEmployees)
	{
		System.out.println("\n ***This is a mobile view of currently enrolled employees.*** ");
		System.out.println("Employee Id"+ "\t"+ " Employee Name");
		System.out.println("______________________");
		for( Employee employee : enrolledEmployees)
		{
			System.out.println(employee.getEmpId() + "\t"+ employee.getEmpName());
		}
		System.out.println("---------------------");
	}
}