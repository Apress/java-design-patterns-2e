package jdp2e.mvc.demo;
import jdp2e.mvc.model.*;
import jdp2e.mvc.view.*;
import jdp2e.mvc.controller.*;

public class MVCArchitectureExample {

	public static void main(String[] args) {
		System.out.println("***MVC architecture Demo***\n");
		//Model
		Model model  = new EmployeeModel();
		
		//View
		View view = new ConsoleView();
		
		//Controller
		Controller controller = new EmployeeController(model, view);
		controller.displayEnrolledEmployees();

		//Add an employee
		controller.addEmployee(new Employee("Kevin","E4"));
		controller.displayEnrolledEmployees();

		//Remove an existing employee using the employee id.
		controller.removeEmployee("E2");
		controller.displayEnrolledEmployees();

		//Cannot remove an  employee who does not belong to the list.
		controller.removeEmployee("E5");
		controller.displayEnrolledEmployees();
		
		//Avoiding duplicate entry
		controller.addEmployee(new Employee("Kevin","E4"));
		
		//This segment is addeed to discuss a question in "Q&A Session"
		view = new MobileView();
		controller = new EmployeeController(model, view);
		controller.displayEnrolledEmployees();
	}
}
