package jdp2e.mvc.model;

//The key "data" in this application
public class Employee
{
	private String empName;
	private String empId;
	public String getEmpName() {
		return empName;
	}
	public String getEmpId() {
		return empId;
	}
	public Employee(String empName, String empId)
	{
		this.empName=empName;
		this.empId=empId;
	}
	@Override
	public String toString()
	{
		return empName + "'s employee id is: "+ empId ;
	}
	@Override
	//To check uniqueness.
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee)) return false;

		Employee empObject = (Employee) o;

		if (!empName.equals(empObject.empName)) return false;
		//cannot use the following for an int
		if (!empId.equals(empObject.empId)) return false;	   
		return true;
	}
}
