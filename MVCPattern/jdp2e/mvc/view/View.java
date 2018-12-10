package jdp2e.mvc.view;
import java.util.List;
import jdp2e.mvc.model.Employee;

public interface View 
{
	void showEnrolledEmployees(List<Employee> enrolledEmployees);
}
