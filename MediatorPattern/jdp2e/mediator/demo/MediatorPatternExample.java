package jdp2e.mediator.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

interface Mediator
{
	void register(Employee employee);
	void sendMessage(Employee employee, String msg) throws InterruptedException;        
}
// ConcreteMediator
class ConcreteMediator implements Mediator
{
	List<Employee> participants = new ArrayList<Employee>();
	@Override
	public void register(Employee employee)
	{
		participants.add(employee);
	}       
	public void displayRegisteredEmployees()
	{
		System.out.println("At present,registered employees are:");
		for (Employee employee: participants)
		{

			System.out.println(employee.getName());
		}
	}
	@Override
	public void sendMessage(Employee employee, String msg) throws InterruptedException
	{
		if (participants.contains(employee))
		{
			System.out.println(employee.getName() +" posts:"+ msg+"Last message posted at "+LocalDateTime.now());
			Thread.sleep(1500);
		}
		else
		{
			System.out.println("An outsider named "+ employee.getName()+" trying to send some messages.");
		}
	}	
}
// The abstract class-Employee
abstract class Employee
{
	protected Mediator mediator;
	protected String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// Constructor 
	public Employee(Mediator mediator)
	{
		this.mediator = mediator;
	}
	public void sendMessage(String msg) throws InterruptedException
	{
		mediator.sendMessage(this, msg);
	}
	public abstract String employeeType();
}
// Junior Employee
class JuniorEmployee extends Employee
{
	public JuniorEmployee(Mediator mediator, String name)       
	{
		super(mediator);
		this.name = name;
	}

	@Override
	public String employeeType() 
	{
		return "JuniorEmployee";		
	}     
}

//Senior Employee
class SeniorEmployee extends Employee
{
	// Constructor 
	public SeniorEmployee(Mediator mediator, String name)        
	{
		super(mediator);
		this.name = name;
	}
	@Override
	public String employeeType() 
	{
		return "SeniorEmployee";		
	}	
}
// Unknown participant.
class Unknown extends Employee
{
	// Constructor 
	public Unknown(Mediator mediator, String name)      
	{
		super(mediator);
		this.name = name;
	}
	@Override
	public String employeeType() 
	{
		return "Outsider";		
	}	
}

public class MediatorPatternExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("***Mediator Pattern Demo***\n");

		ConcreteMediator mediator = new ConcreteMediator();

		JuniorEmployee amit = new JuniorEmployee(mediator, "Amit");
		JuniorEmployee sohel = new JuniorEmployee(mediator, "Sohel");
		SeniorEmployee raghu = new SeniorEmployee(mediator, "Raghu");

		//Registering participants
		mediator.register(amit);
		mediator.register(sohel);
		mediator.register(raghu);
		//Displaying the participant's list
		mediator.displayRegisteredEmployees();

		System.out.println("Communication starts among participants...");
		amit.sendMessage("Hi Sohel,can we discuss the mediator pattern?");
		sohel.sendMessage("Hi Amit,yup, we can discuss now.");
		raghu.sendMessage("Please get back to work quickly.");

		//An outsider/unknown person tries to participate
		Unknown unknown = new Unknown(mediator, "Jack");
		unknown.sendMessage("Hello Guys..");
	}
}

