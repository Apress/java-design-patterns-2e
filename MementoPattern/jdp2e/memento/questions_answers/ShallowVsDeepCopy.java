package jdp2e.memento.questions_answers;
class EmpAddress implements Cloneable
{
	String address;	
	public EmpAddress(String address)
	{
		this.address=address;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	@Override
	public String toString()
	{
		return  this.address;
	}
	@Override
	public Object clone() throws CloneNotSupportedException 
	{
		//Shallow Copy
		return super.clone();
	}
}
class Employee implements Cloneable
{
	int id;
	String name;
	EmpAddress empAddress;
	public Employee(int id,String name,EmpAddress empAddress)
	{
		this.id=id;
		this.name=name;
		this.empAddress=empAddress;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public EmpAddress getAddress() 
	{
		return this.empAddress;
	}
	public void setAddress(EmpAddress newAddress) 
	{
		this.empAddress=newAddress;
	}
	@Override
	public String toString()
	{
		return "EmpId=" +this.id+ " EmpName="+ this.name+ " EmpAddressName="+ this.empAddress;
	}
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		//Shallow Copy
		//return super.clone();
		
		//For deep copy
		Employee employee = (Employee) super.clone();		 
		employee.empAddress = (EmpAddress) empAddress.clone(); 
        return employee;
	}
}

public class ShallowVsDeepCopy {

	public static void main(String[] args) throws CloneNotSupportedException  {
		System.out.println("***Shallow vs Deep Copy Demo***\n");
		EmpAddress initialAddress=new EmpAddress("21, abc Road, USA");
		Employee emp=new Employee(1,"John",initialAddress);
		System.out.println("emp1 object is as follows:");
		System.out.println(emp);
		Employee empClone=(Employee)emp.clone();
		System.out.println("empClone object is as follows:");
		System.out.println(empClone);
		System.out.println("\n Now changing the name, id and address of the emp object ");
		emp.setId(10);
		emp.setName("Sam");
		emp.empAddress.setAddress("221, xyz Road, Canada");
		System.out.println("Now emp1 object is as follows:");
		System.out.println(emp);
		System.out.println("And emp1Clone object is as follows:");
		System.out.println(empClone);
	}

}
