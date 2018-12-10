package jdp2e.mvc.controller;

import java.util.List;

import jdp2e.mvc.model.*;
import jdp2e.mvc.view.*;

public class EmployeeController implements Controller
{
	private Model model;        
	private View  view;

	public EmployeeController(Model model, View view)
	{
		this.model = model;
		this.view = view;           
	}   
	@Override
	public  void displayEnrolledEmployees()
	{
		//Get data from Model
		List<Employee> enrolledEmployees = model.getEnrolledEmployeeDetailsFromModel();
		//Connect to View
		view.showEnrolledEmployees(enrolledEmployees);
	}

	//Sending a request to model to add an employee to the list.
	@Override
	public void addEmployee(Employee employee)
	{
		model.addEmployeeToModel(employee);		
	}
	//Sending a request to model to remove an employee from the list.
	@Override
	public void removeEmployee(String employeeId)
	{
		model.removeEmployeeFromModel(employeeId);
	}
}