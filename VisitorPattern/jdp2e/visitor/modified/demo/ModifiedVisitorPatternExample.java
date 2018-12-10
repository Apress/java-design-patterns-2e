package jdp2e.visitor.modified.demo;
import java.util.ArrayList;
import java.util.List;

interface Employee
{
	void printStructures();
	//The following method has a Visitor argument.
	void acceptVisitor(Visitor visitor);        
}
//Employees who have Subordinates
class CompositeEmployee implements Employee
{
	private String name;
	private String dept;
	//New field for this example.
	//It is tagged with "final", so visitor cannot modify it.
	private final int  yearsOfExperience;
	//The container for child objects
	private List<Employee> controls;
	// constructor
	public CompositeEmployee(String name,String dept, int experience)
	{
		this.name = name;
		this.dept = dept;
		this.yearsOfExperience = experience;		
		controls = new ArrayList<Employee>();
	}
	public void addEmployee(Employee e)
	{
		controls.add(e);
	}
	public void removeEmployee(Employee e)
	{
		controls.remove(e);
	}
	// Gets the name
	public String getName()
	{
		return name;
	}
	// Gets the department name

	public String getDept() 
	{
		return dept;
	}	

	// Gets the yrs. of experience
	public int getExperience()
	{
		return yearsOfExperience; 

	}
	public List<Employee> getControls()
	{
		return this.controls; 
	}
	@Override
	public void printStructures()
	{
		System.out.println("\t" + getName() + " works in  " + getDept() + " Experience :" + getExperience() + " years");
		for(Employee e: controls)
		{
			e.printStructures();
		}

	}
	@Override
	public void acceptVisitor(Visitor visitor)
	{
		visitor.visitTheElement(this);            
	}      
}
class SimpleEmployee implements Employee
{
	private String name;
	private String dept;
	//New field for this example
	private int yearsOfExperience;        
	// constructor
	public SimpleEmployee(String name, String dept, int experience)
	{
		this.name = name;
		this.dept = dept;
		this.yearsOfExperience = experience;
	}	
	// Gets the name
	public String getName()
	{
		return name;           
	}
	// Gets the department name
	public String getDept()
	{		 
		return this.dept; 

	}
	// Gets the yrs. of experience
	public int getExperience()
	{
		return yearsOfExperience;
	}
	@Override
	public void printStructures()
	{
		System.out.println("\t\t" + getName() + " works in  " + getDept() + " Experience :" + getExperience() + " years");
	}
	@Override
	public void acceptVisitor(Visitor visitor)
	{
		visitor.visitTheElement(this);
	}
}

interface Visitor
{
	void visitTheElement(CompositeEmployee employees);
	void visitTheElement(SimpleEmployee employee);        
}
class ConcreteVisitor implements Visitor
{
	@Override
	public void visitTheElement(CompositeEmployee employee)
	{
		//We'll promote them if experience is greater than 15 years
		boolean eligibleForPromotion = employee.getExperience() > 15 ? true : false;
		System.out.println("\t\t" + employee.getName() + " from  " + employee.getDept() + " is eligible for promotion? " + eligibleForPromotion);
	}
	@Override
	public void visitTheElement(SimpleEmployee employee)
	{ 
		//We'll promote them if experience is greater than 12 years
		boolean eligibleForPromotion = employee.getExperience() > 12 ? true : false;
		System.out.println("\t\t" + employee.getName() + " from  " + employee.getDept() + " is eligible for promotion? " + eligibleForPromotion);
	}


}

public class ModifiedVisitorPatternExample {

	public static void main(String[] args) {
		System.out.println("***Visitor Pattern combined with Composite Pattern Demo***\n");
		/*2 teachers other than HOD works in
		 Mathematics department*/
		SimpleEmployee mathTeacher1 = new SimpleEmployee("Math Teacher-1","Maths",13);
		SimpleEmployee mathTeacher2 = new SimpleEmployee("Math Teacher-2","Maths",6);

		/* 3 teachers other than HOD works in 
		  Computer Sc. department */
		SimpleEmployee cseTeacher1 = new SimpleEmployee("CSE Teacher-1","Computer Sc.",10);
		SimpleEmployee cseTeacher2 = new SimpleEmployee("CSE Teacher-2", "Computer Sc.",13);
		SimpleEmployee cseTeacher3 = new SimpleEmployee("CSE Teacher-3", "Computer Sc.",7);  

		//The College has 2 Head of Departments-One from Mathematics, One from Computer Sc.
		CompositeEmployee hodMaths = new CompositeEmployee("Mrs.S.Das(HOD-Maths)","Maths",14);
		CompositeEmployee hodCompSc = new CompositeEmployee("Mr. V.Sarcar(HOD-CSE)", "Computer Sc.",16);

		//Principal of the college
		CompositeEmployee principal = new CompositeEmployee("Dr.S.Som(Principal)","Planning-Supervising-Managing",20);

		//Teachers of Mathematics directly reports to HOD-Maths
		hodMaths.addEmployee(mathTeacher1);
		hodMaths.addEmployee(mathTeacher2);

		/*Teachers of Computer Sc. directly reports to HOD-CSE */

		hodCompSc.addEmployee(cseTeacher1);
		hodCompSc.addEmployee(cseTeacher2);
		hodCompSc.addEmployee(cseTeacher3);


		/*Principal is on top of college.HOD -Maths and Comp. Sc directly reports to him */
		principal.addEmployee(hodMaths);
		principal.addEmployee(hodCompSc);

		
		System.out.println("\n Testing the overall structure");
		//Prints the complete structure
		principal.printStructures();


		System.out.println("\n***Visitor starts visiting our composite structure***\n");
		System.out.println("---The minimum criteria for promotion is as follows ---");
		System.out.println("--Junior Teachers-12 years and Senior teachers-15 years.--\n");
		Visitor myVisitor = new ConcreteVisitor();
		/*
		 * At first, We are building a container for employees who will be considered for promotion.
		 *Principal is holding the highest position.So, he is not considered for promotion.       
		 */
		List<Employee> employeeContainer= new ArrayList<Employee>();
		//For employees who directly reports to Principal
		for (Employee e : principal.getControls())
		{
			employeeContainer.add(e);
		}
		//For employees who directly reports to HOD-Maths
		for (Employee e : hodMaths.getControls())
		{
			employeeContainer.add(e);
		}
		//For employees who directly reports to HOD-Comp.Sc
		for (Employee e : hodCompSc.getControls())
		{
			employeeContainer.add(e);
		}
		//Now visitor can traverse through the container.
		for (Employee e :employeeContainer)
		{			
			e.acceptVisitor(myVisitor);
		}
	}
}
