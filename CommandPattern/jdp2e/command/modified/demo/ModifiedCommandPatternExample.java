package jdp2e.command.modified.demo;

/**
 * @author sarcarv
 *In general, an undo operation involves complex logic.
 *But for simplicity, in this example,I assume that 
 *executeDo() can either add 2 with a given integer or it can switch on a machine.
 *Similarly executeUnDo() can either subtract 2 from a given number() or,
 *it will switch off a machine.But you cannot go beyond the initialized value */
 
interface Command
{
	void executeDo();
	void executeUnDo();
}
class AdditionCommand implements Command
{
	private Receiver receiver;
	public AdditionCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	@Override
	public void executeDo()
	{
		receiver.performDo();    
	}
	@Override
	public void executeUnDo()
	{		
		receiver.performUnDo();		
	}	
}
class PowerCommand implements Command
{
	private Receiver receiver;
	public PowerCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	@Override
	public void executeDo()
	{
		receiver.performDo();    
	}
	@Override
	public void executeUnDo()
	{
		receiver.performUnDo();		
	}	
}

//To deal with multiple receivers , we are using interfaces here
interface Receiver
{
	//It will add 2 with a number or switch on the m/c
	void performDo();
	//It will subtract 2 from a number or switch off the m/c
	void performUnDo();  
}
//Receiver Class
class Receiver1 implements Receiver
{
	private int myNumber;

	public int getMyNumber() 
    {
		return myNumber;
	}
	public void setMyNumber(int myNumber) 
	{
		this.myNumber = myNumber;
	}
	public Receiver1()
	{
		myNumber = 10;
		System.out.println("Receiver1 initialized with " + myNumber);
		System.out.println("The objects of receiver1 cannot set beyond "+ myNumber);
	}
	@Override
	public void performDo()
	{
		System.out.println("Received an addition request.");
		//int presentNumber = this.myNumber;
		//this.myNumber = this.myNumber + 2;
		int presentNumber = getMyNumber();
		setMyNumber(presentNumber + 2);
		System.out.println(presentNumber +" + 2 ="+ this.myNumber);
	}
	@Override
	public void performUnDo()
	{
		System.out.println("Received an undo addition request.");
		int presentNumber = this.myNumber;
		//We started with number 10.We'll not decrease further.
		if (presentNumber > 10)
		{
			//this.myNumber = this.myNumber - 2;
			setMyNumber(this.myNumber - 2);
			System.out.println(presentNumber +" - 2 ="+ this.myNumber);
			System.out.println("\t Undo request processed.");
		}
		else
		{
			System.out.println("Nothing more to undo...");
		}
	}	
}
//Receiver2 Class

class Receiver2 implements Receiver
{
	boolean status;
	
	public Receiver2()
	{
		System.out.println("Receiver2 initialized ");
		status=false;
	}
	@Override
	public void performDo()
	{
		System.out.println("Received a system power on request.");
		if( status==false)
		{
			System.out.println("System is starting up.");
			status=true;
		}
		else
		{
			System.out.println("System is already running.So, power on request is ignored.");			
		}		
			
	}
	@Override
	public void performUnDo()
	{
		System.out.println("Received a undo request.");
		if( status==true)
		{
			System.out.println("System is currently powered on.");
			status=false;
			System.out.println("\t Undo request processed.System is switched off now.");
		}
		else
		{
			System.out.println("System is switched off at present.");
			status=true;
			System.out.println("\t Undo request processed.System is powered on now.");
		
		}
	}
}

//Invoker class

class Invoker
{
	Command commandToBePerformed;
	public void setCommand(Command command)
	{
		this.commandToBePerformed = command;
	}
	public void executeCommand()
	{
		commandToBePerformed.executeDo();
	}
	public void undoCommand()
	{
		commandToBePerformed.executeUnDo();
	}
}

//Client
public class ModifiedCommandPatternExample {
	public static void main(String[] args) {

		System.out.println("***Command Pattern Q&As***");
		System.out.println("***A simple demo with undo supported operations***\n");
		/*Client holds  both the Invoker and Command Objects*/

		//Testing receiver -Receiver1
		System.out.println("-----Testing operations in Receiver1-----");
		Receiver intendedreceiver = new Receiver1();
		Command currentCmd = new AdditionCommand(intendedreceiver);

		Invoker invoker = new Invoker();
		invoker.setCommand(currentCmd);
		System.out.println("*Testing single do/undo operation*");
		invoker.executeCommand();
		invoker.undoCommand(); 
		System.out.println("_______");
		System.out.println("**Testing a series of do/undo operations**");
		//Executed the command 2 times
		invoker.executeCommand();
		//invoker.UndoCommand();
		invoker.executeCommand();            
		//Trying to undo 3 times
		invoker.undoCommand();
		invoker.undoCommand();
		invoker.undoCommand();

		System.out.println("\n-----Testing operations in Receiver2-----");
		intendedreceiver = new Receiver2();
		currentCmd = new PowerCommand(intendedreceiver);
		invoker.setCommand(currentCmd);
		
		System.out.println("*Testing single do/undo operation*");
		invoker.executeCommand();
		invoker.undoCommand(); 
		System.out.println("_______");
		System.out.println("**Testing a series of do/undo operations**");
		//Executed the command 2 times
		invoker.executeCommand();
		invoker.executeCommand();
		//Trying to undo 3 times
		invoker.undoCommand();
		invoker.undoCommand();  
		invoker.undoCommand(); 

	}

}
