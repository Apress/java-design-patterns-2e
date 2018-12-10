package jdp2e.proxy.modified.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Abstract class Subject
abstract class Subject
{
	public abstract void doSomeWork();
}
//ConcreteSubject class
class ConcreteSubject extends Subject
{
	@Override
	public void doSomeWork() 
	{
		System.out.println("doSomeWork() inside ConcreteSubject is invoked.");
	}
}

/**
 * @author sarcarv
 * Proxy Class:It will try to invoke the doSomeWork() 
 * of a ConcreteSubject instance *
 */
class ModifiedProxy extends  Subject
{
	static Subject cs;
	//String[] registeredUsers;
	String currentUser;
	List<String> registeredUsers;
	//Or, simply create this mutable list in one step
	//List<String> registeredUsers=new ArrayList<String>(Arrays.asList( "Admin","Rohit","Sam"));
	public ModifiedProxy(String currentUser)
	{
		//Registered users are Admin, Rohit and Sam only.
		registeredUsers = new ArrayList<String>();
		registeredUsers.add("Admin");
		registeredUsers.add("Rohit");
		registeredUsers.add("Sam");		
		this.currentUser = currentUser;
	}
	@Override
	public void doSomeWork() 
	{
		System.out.println("\n Proxy call happening now...");
		System.out.println(currentUser+" wants to invoke a proxy method.");
		if (registeredUsers.contains(currentUser))
		{
			//Lazy initialization:We'll not instantiate until the method is called
			if (cs == null)
			{
				cs = new ConcreteSubject();				
			}
			//Allow the registered user to invoke the method
			cs.doSomeWork();
		}
		else
		{
			System.out.println("Sorry "+ currentUser+ " , you do not have access rights.");
		}
	}
}

/**
 * @author sarcarv
 * The client is talking to a ConcreteSubject instance 
 * through a proxy method.
 */
public class ModifiedProxyPatternExample {

	public static void main(String[] args) {
		System.out.println("***Modified Proxy Pattern Demo***\n");
		//Admin is an authorized user
		ModifiedProxy px1 = new ModifiedProxy("Admin");
		px1.doSomeWork();
		//Robin is an unauthorized user
		ModifiedProxy px2 = new ModifiedProxy("Robin");
		px2.doSomeWork();

	}

}
