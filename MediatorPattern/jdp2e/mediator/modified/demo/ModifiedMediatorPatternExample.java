package jdp2e.mediator.modified.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

interface Mediator
{
	void register(Employee employee);	
	void sendMessage(Employee fromEmployee, Employee toEmployee,String msg) throws InterruptedException;	
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
		System.out.println("At present ,registered Participants are:");
		for (Employee employee: participants)
		{

			System.out.println(employee.getName());
		}
	}
	@Override
	public void sendMessage(Employee fromEmployee,Employee toEmployee,String msg) throws InterruptedException
	{
		//if( fromEmployee.getClass().getSimpleName().equals("UnauthorizedUser"))
		if( fromEmployee.employeeType()=="UnauthorizedUser")
		{
			System.out.println("[ALERT Everyone] An outsider named "+ fromEmployee.getName()+" trying to send some messages to "+ toEmployee.getName());
			fromEmployee.receive(fromEmployee, ",you are not allowed to enter here.");
		}
		else if (participants.contains(fromEmployee))
		{
			System.out.println("-----"+fromEmployee.getName() +" posts some message at: "+LocalDateTime.now()+"-----");
			Thread.sleep(1000);
			//No need to inform everyone or himself
			//Only let the target receiver know
			if(participants.contains(toEmployee))
			{
				toEmployee.receive(fromEmployee,msg);	
			}
			//If target receipient does not exist
			else
			{
				System.out.println(fromEmployee.getName() +" , your target recipient does not exist");
			}
		}
		//An outsider tries to send message.
		else
		{
			System.out.println("[ALERT] An unregistered employee named "+ fromEmployee.getName()+" trying to send some messages to "+ toEmployee.getName());
			System.out.println(fromEmployee.getName()+", you need to register yourself first.");
		}
	}	
}
// Employee
abstract class Employee
{
	private Mediator mediator;
	protected String name;
	private boolean authorizedUser;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// Constructor 
	public Employee(Mediator mediator, String name, boolean authorizedUser)
	{
		this.mediator = mediator;
		this.name=name;
		this.authorizedUser=authorizedUser;
		if(authorizedUser)
		{
			mediator.register(this);
		}
	}
	//The following method name need not be same as the Mediator's method name
	public void send(Employee toFriend,String msg) throws InterruptedException
	{
		mediator.sendMessage(this,toFriend, msg);
	}
	//public abstract void receive(Friend fromFriend,String message);

	public void receive(Employee fromFriend,String message) 
	{
		System.out.println(this.name+" received a message : " + message +" from an employee "+ fromFriend.getName() +".");

	}
	public abstract String employeeType();
}
//A concrete friend
class ConcreteEmployee extends Employee
{

	public ConcreteEmployee(Mediator mediator, String name,boolean authorizedUser)       
	{
		super(mediator,name, authorizedUser);		
	}
	@Override
	public String employeeType() 
	{
		return "ConcreteEmployee";		
	}	
}
//Unauthorized user
class UnauthorizedUser extends Employee
{
	public UnauthorizedUser(Mediator mediator, String name)       
	{
		//The user is always treated an unauthorized user.So, the flag is false always.
		super(mediator,name, false);		
	}

	@Override
	public void receive(Employee fromEmployee,String message) 
	{
		System.out.println(this.name + message);

	}
	@Override
	public String employeeType() 
	{
		return "UnauthorizedUser";		
	}
}

public class ModifiedMediatorPatternExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("***Mediator Pattern Demo***\n");

		ConcreteMediator mediator = new ConcreteMediator();

		Employee Amit = new ConcreteEmployee(mediator, "Amit", true);
		Employee Sohel = new ConcreteEmployee(mediator, "Sohel",true);
		Employee Raghu = new ConcreteEmployee(mediator, "Raghu",true);
		//Unauthorized user
		Employee Jack = new ConcreteEmployee(mediator, "Jack",false);
		//Only two parameter needed to pass in the following case.
		Employee Divya = new UnauthorizedUser(mediator, "Divya");

		//Displaying the participant's list
		mediator.displayRegisteredEmployees();

		System.out.println("Communication starts among participants...");
		Amit.send(Sohel,"Hi Sohel,can we discuss the mediator pattern?");
		Sohel.send(Amit,"Hi Amit,Yup, we can discuss now.");
		//Boss sending messages to each of them individually
		Raghu.send(Amit,"Please get back to work quickly.");
		Raghu.send(Sohel,"Please get back to work quickly.");

		//An unregistered employee(Jack) and an outsider(Divya) are also trying to participate.
		Jack.send(Amit,"Hello Guys..");
		Divya.send(Raghu, "Hi Raghu");

	}
}




