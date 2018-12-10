package jdp2e.prototype.questions_answers;

class Student
{
    int rollNo;
    String name;
    //Instance Constructor
    public Student(int rollNo, String name)
    {
        this.rollNo = rollNo;
        this.name = name;
    }
    //Copy Constructor
    public Student( Student student)
    {
        this.name = student.name;
        this.rollNo = student.rollNo;
    }
    public void displayDetails()
    {
    	System.out.println(" Student name: " + name + ",Roll no: "+rollNo);
    }
}

class UserDefinedCopyConstructorExample {
	public static void main(String[] args) {
		System.out.println("***User defined copy constructor example in Java***\n");
		Student student1 = new Student(1, "John");
		System.out.println(" The details of Student1 is as follows:");
        student1.displayDetails();
        System.out.println("\n Copying student1 to student2 now");
        //Invoking the user-defined copy constructor
        Student student2 = new Student (student1);
        System.out.println(" The details of Student2 is as follows:");
        student2.displayDetails();
	}
}
