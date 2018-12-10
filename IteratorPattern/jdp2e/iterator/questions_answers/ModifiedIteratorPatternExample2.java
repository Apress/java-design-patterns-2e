package jdp2e.iterator.questions_answers;
import java.util.Iterator;
import java.util.LinkedList;

class Employee
{
	private String name;
	private int id;
	private double salary;
	public Employee(String name, int id, double salary )
	{
		this.name=name;
		this.id=id;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString(){
		return "Employee Name: "+this.getName()+", ID: "+this.getId()+ " and salary: "+this.getSalary()+"$";
	}
}
interface DataBase
{
	EmployeeIterator createIterator(); 
}
class EmployeeDatabase implements DataBase
{
	private LinkedList<Employee> employeeList;

	public EmployeeDatabase()
	{           
		employeeList = new LinkedList<Employee>();		
		employeeList.add(new Employee("Ron",1, 1000.25));
		employeeList.add(new Employee("Jack",2, 2000.5));
		employeeList.add(new Employee("Ambrose",3, 3000.75));
		employeeList.add(new Employee("Jian",4, 2550.0));
		employeeList.add(new Employee("Alex",5, 753.83));		
	}	
	public EmployeeIterator createIterator()
	{
		return new EmployeeIterator(employeeList);
	}
}

class EmployeeIterator implements Iterator<Employee>
{
	private LinkedList<Employee> employeeList;
	private int position;
	public EmployeeIterator(LinkedList<Employee> employeeList)
	{
		this.employeeList= employeeList;
		position = 0;
	}
	//@Override
	public void first()
	{
		position = 0;
	}	

	//@Override
	public Employee currentItem()
	{
		return employeeList.get(position);
	}	

	@Override
	public Employee next() 
	{
		return employeeList.get(position++);
	}
	@Override
	public boolean hasNext() {
		if(position >= employeeList.size())
			return false;
		return true;
	}
}

public class ModifiedIteratorPatternExample2 {

	public static void main(String[] args) {
		System.out.println("***Modified Iterator Pattern Demo.Example-2.***");        
		DataBase employeesList = new EmployeeDatabase();

		EmployeeIterator iteratorForEmployee = employeesList.createIterator();
		System.out.println("\n -----Employee details are as follows-----\n");		

		while (iteratorForEmployee.hasNext())
		{
			System.out.println(iteratorForEmployee.next());
		}	

	}
}




