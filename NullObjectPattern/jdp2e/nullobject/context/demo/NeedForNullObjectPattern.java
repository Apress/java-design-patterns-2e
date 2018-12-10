package jdp2e.nullobject.context.demo;

import java.util.ArrayList;
import java.util.List;
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
//The following class is used in Q&A session
class NullVehicle implements Vehicle
{
	@Override
	public void travel()
	{
		//Do nothing
	}
}



public class NeedForNullObjectPattern {

	public static void main(String[] args) {
		System.out.println("***Need for Null Object Pattern Demo***\n");
		String input = null;
		int totalObjects = 0;
         /*
		//Another context discussed in Q&A session
		List<Vehicle> vehicleList=new ArrayList<Vehicle>();
		vehicleList.add(new Bus());
		vehicleList.add(new Train());
		//vehicleList.add(null);
		vehicleList.add(new NullVehicle());
		for( Vehicle vehicle : vehicleList)
		{
			vehicle.travel();
		}

        */
		while (true)
		{
			System.out.println("Enter your choice( Type 'a' for Bus, 'b' for Train ) ");
			Scanner scanner=new Scanner(System.in);
			input = scanner.nextLine();
			Vehicle vehicle = null;
			switch (input.toLowerCase())
			{
			case "a":
				vehicle = new Bus();
				break;
			case "b":
				vehicle = new Train();
				break;                    
			}
			totalObjects = Bus.busCount + Train.trainCount;
			//A immediate remedy
			//if(vehicle !=null)
			//{
			vehicle.travel(); 
			//}
			System.out.println("Total number of objects created in the system is : "+ totalObjects);
			//scanner.close();		

		}



	}
}
