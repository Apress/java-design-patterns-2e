package jdp2e.visitor.demo;
interface OriginalInterface
{
	//The following method has a Visitor argument.
	void acceptVisitor(Visitor visitor);
}
class MyClass implements OriginalInterface
{
	//Here "myInt" is final.So, once initialized, it should not be changed.
	private final int myInt;
	public MyClass()
	{
		myInt=5;//Initial or default value
	}    
	public int getMyInt() 
	{
		return myInt;
	}
	
	@Override
	public void acceptVisitor(Visitor visitor) 
	{
		visitor.visit(this);		                
	}		
}

interface Visitor
{
	//The method to visit MyClass
	void visit(MyClass myClassObject);
}
class ConcreteVisitor implements Visitor
{
	@Override
	public void visit(MyClass myClassObject)
	{
		System.out.println("Current value of myInt="+ myClassObject.getMyInt());
		System.out.println("Visitor will make it double and display it.");
		System.out.println("Current value of myInt="+ 2*myClassObject.getMyInt());
		System.out.println("Exiting from Visitor.");
	}

}   

public class VisitorPatternExample {

	public static void main(String[] args) {
		System.out.println("***Visitor Pattern Demo***\n");
		Visitor visitor = new ConcreteVisitor();
		MyClass myClass = new MyClass();
		myClass.acceptVisitor(visitor);
	}
}
