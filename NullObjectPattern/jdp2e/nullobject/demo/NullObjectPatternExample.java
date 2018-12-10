package jdp2e.nullobject.demo;
import java.util.Scanner;

interface Vehicle
{
	void travel();
}
class Bus implements Vehicle
{
	public static int busCount = 0;
	public Bus()
	{
		busCount++;
	}
	@Override
	public void travel()
	{
		System.out.println("Let us travel with a bus");
	}	
}
class Train implements Vehicle
{
	public static int trainCount = 0;
	public Train()
	{
		trainCount++;
	}
	@Override
	public void travel()
	{
		System.out.println("Let us travel with a train");
	}
}
class NullVehicle implements Vehicle
{
	//Early initialization
	private static  NullVehicle instance = new NullVehicle();
	public static int nullVehicleCount;
	//Making constructor private to prevent the use of "new"  
	private NullVehicle() 
	{
		nullVehicleCount++;
		System.out.println(" A null vehicle object created.Currently null vehicle count is :  "+nullVehicleCount);
	}
	// Global point of access.
	public static NullVehicle getInstance()
	{
		//System.out.println("We already have an instance now. Use it.");
		return instance;
	}
	@Override
	public void travel()
	{
		//Do Nothing
	}    
}

public class NullObjectPatternExample  {

	public static void main(String[] args) {
		System.out.println("***Null Object Pattern Demo***\n");
		String input = "dummyInputToStartProcessing";		
		int totalObjects = 0;
		Scanner scanner;
		while(!input.toLowerCase().contains("exit"))
		{
			System.out.println("Enter your choice( Type 'a' for Bus, 'b' for Train.Type 'exit' to close the application. ) ");
			scanner=new Scanner(System.in);
			if(scanner.hasNextLine())
			{
				input = scanner.nextLine();
			}
			Vehicle vehicle = null;
			switch (input.toLowerCase())
			{
			case "a":
				vehicle = new Bus();
				break;
			case "b":
				vehicle = new Train();
				break;
		    case "exit":
				System.out.println("Closing the application");
				vehicle = NullVehicle.getInstance();				
				break;				
			default:
				System.out.println("Invalid input");
				vehicle =  NullVehicle.getInstance();				             
				//break;
			}
			totalObjects = Bus.busCount + Train.trainCount+NullVehicle.nullVehicleCount;
			//A immediate remedy
			//if(vehicle !=null)
			//{
			vehicle.travel(); 
			//}
			System.out.println("Total number of objects created in the system is : "+ totalObjects);			
		}

	}
}

