package jdp2e.interpreter.modified.demo;

import java.util.ArrayList;
import java.util.List;

interface Employee 
{	
	public boolean interpret(Context context);
}
class IndividualEmployee implements Employee
{
	private int yearOfExperience;

	private String currentGrade;	

	public IndividualEmployee(int experience, String grade){
		this.yearOfExperience=experience;
		this.currentGrade=grade;
	}
	@Override
	public boolean interpret(Context context) 
	{

		if(this.yearOfExperience>=context.getYearofExperience() && context.getPermissibleGrades().contains(this.currentGrade))
		{
			return true;
		}
		return false;
	}
}
class OrExpression implements Employee 
{

	private Employee  emp1;
	private Employee  emp2;

	public OrExpression(Employee emp1, Employee emp2) 
	{ 
		this.emp1 = emp1;
		this.emp2 = emp2;
	}

	@Override
	public boolean interpret(Context context)
	{		
		return emp1.interpret(context) || emp2.interpret(context);
	}
}
class AndExpression implements Employee 
{

	private Employee  emp1;
	private Employee  emp2;

	public AndExpression(Employee emp1, Employee emp2) 
	{ 
		this.emp1 = emp1;
		this.emp2 = emp2;
	}

	@Override
	public boolean interpret(Context context)
	{		
		return emp1.interpret(context) && emp2.interpret(context);
	}
}
class NotExpression implements Employee 
{	 
	private Employee  emp;	   

	public NotExpression(Employee  expr) 
	{ 
		this.emp = expr;	      
	}

	@Override
	public boolean interpret(Context context)
	{		
		return !emp.interpret(context);
	}
}
class Context
{	
	private int yearofExperience;	
	private List<String> permissibleGrades;
	public Context(int experience,String... allowedGrades)
	{
		this.yearofExperience=experience;
		this.permissibleGrades=new ArrayList<>();
		for( String grade:allowedGrades)
		{
			permissibleGrades.add(grade);
		}
	}
	public int getYearofExperience() 
	{
		return yearofExperience;
	}
	public List<String> getPermissibleGrades() 
	{
		return permissibleGrades;
	}
}
class EmployeeBuilder
{

	// Building the tree
	//Complex Rule-1: emp1 and (emp2 or (emp3 or emp4))

	public Employee buildTree(Employee emp1, Employee emp2,Employee emp3,Employee emp4) 
	{
		//emp3 or emp4
		Employee firstPhase=new OrExpression(emp3,emp4);
		//emp2 or (emp3 or emp4)
		Employee secondPhase=new OrExpression(emp2,firstPhase);
		//emp1 and (emp2 or (emp3 or emp4))
		Employee finalPhase=new AndExpression(emp1,secondPhase);
		return finalPhase;

	}
	//Complex Rule-2: emp1 or (emp2 and (not emp3 ))
	public Employee buildTreeBasedOnRule2(Employee emp1, Employee emp2,Employee emp3) 
	{
		//Not emp3
		Employee firstPhase=new NotExpression(emp3);
		//emp2 or (not emp3)
		Employee secondPhase=new AndExpression(emp2,firstPhase);
		//emp1 and (emp2 or (not emp3 ))
		Employee finalPhase=new OrExpression(emp1,secondPhase);
		return finalPhase;

	}

}
public class ModifiedInterpreterPatternExample {

	public static void main(String[] args) {
		System.out.println("***Modified Interpreter Pattern Demo***\n");

		//Minimum Criteria for promoton is:
		//The year of experience is minimum 10 yrs. and 
		//Employee grade should be either G2 or G3
		Context context=new Context(10,"G2","G3");
		//Different employees with grades
		Employee emp1 = new IndividualEmployee(5,"G1");
		Employee emp2 = new IndividualEmployee(10,"G2");
		Employee emp3 = new IndividualEmployee(15,"G3");
		Employee emp4 = new IndividualEmployee(20,"G4");

		EmployeeBuilder builder=new EmployeeBuilder();		

		//Validating the 1st complex rule
		System.out.println("Is emp1 and any of emp2,emp3, emp4 is eligible for promotion?" +builder.buildTree(emp1,emp2, emp3,emp4).interpret(context));
		System.out.println("Is emp2 and any of emp1,emp3, emp4 is eligible for promotion?" +builder.buildTree(emp2,emp1, emp3,emp4).interpret(context));
		System.out.println("Is emp3 and any of emp1,emp2, emp4 is eligible for promotion?" +builder.buildTree(emp3,emp1, emp2,emp4).interpret(context));
		System.out.println("Is emp4 and any of emp1,emp2, emp3 is eligible for promotion?" +builder.buildTree(emp4,emp1, emp2,emp3).interpret(context));

		System.out.println("");
		//Validating the 2nd complex rule
		System.out.println("Is emp1 or (emp2 but not emp3) is eligible for promotion?" +builder.buildTreeBasedOnRule2(emp1, emp2, emp3).interpret(context));
		System.out.println("Is emp2 or (emp3 but not emp4) is eligible for promotion?" +builder.buildTreeBasedOnRule2(emp2, emp3, emp4).interpret(context));
	}
}


