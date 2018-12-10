package jdp2e.mvc.controller;

import jdp2e.mvc.model.Employee;

//Controller
public interface Controller
{
	void displayEnrolledEmployees();
	void addEmployee(Employee employee);
	void removeEmployee(String employeeId);
}
