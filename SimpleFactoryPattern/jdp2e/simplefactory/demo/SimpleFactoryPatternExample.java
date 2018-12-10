package jdp2e.simplefactory.demo;
import java.util.Scanner;//Available Java5 onwards

interface Animal
{
	void speak();
	void preferredAction();
}    
class Dog implements Animal
{
	public void speak()
	{
		System.out.println("Dog says: Bow-Wow.");            
	}
	public void preferredAction()
	{
		System.out.println ("Dogs prefer barking...");
	}
}
class Tiger implements Animal
{
	public void speak()
	{
		System.out.println("Tiger says: Halum.");
	}
	public void preferredAction()
	{
		System.out.println("Tigers prefer hunting...");
	}
}
class SimpleFactory
{
	public Animal createAnimal()
	{
		Animal intendedAnimal=null;
		System.out.println("Enter your choice( 0 for Dog, 1 for Tiger)");
		/* To suppress the warning message:Resource leak:'input' is never closed.
		So,the following line is optional in this case */
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);		
		int choice=Integer.parseInt(input.nextLine());
		System.out.println("You have entered :"+ choice);
		switch (choice)
		{
		case 0:
			intendedAnimal = new Dog();
			break;
		case 1:
			intendedAnimal = new Tiger();
			break;
		default:
			System.out.println("You must enter either 0 or 1");
			//We'll throw a runtime exception for any other choices. 
			throw new IllegalArgumentException(" Your choice tries to create an unknown Animal");
		}

		return intendedAnimal;
	}       
}
//A client is interested to get an animal who can speak and perform an action.
class SimpleFactoryPatternExample
{
	public static void main(String[] args) 	{
		System.out.println("*** Simple Factory Pattern Demo***\n");
		Animal preferredType=null;
		SimpleFactory simpleFactory = new SimpleFactory();
		// The code that will vary based on users preference.            
		preferredType = simpleFactory.createAnimal();
		//The codes that do not change frequently.
		//These animals can speak and prefer to do some specific actions.
		preferredType.speak();
		preferredType.preferredAction();
		
	}
}
