package jdp2e.mvc.model;

import java.util.List;

//Model interface
public interface Model
{

	List<Employee> getEnrolledEmployeeDetailsFromModel();
	void addEmployeeToModel(Employee employeee);
	void removeEmployeeFromModel(String employeeId);
}