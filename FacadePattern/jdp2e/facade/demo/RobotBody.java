package jdp2e.facade.demo;

public class RobotBody
{
	//Instruction manual -how to create a robot
	public static void createRobot()
	{
		System.out.println(" Refer the manual before creation of a robot.");
	}
	//Method to create hands of a robot
	public void createHands()
	{
		System.out.println(" Hands manufactured.");
	}
	//Method to create remaining parts (other than hands) of a robot
	public void createRemainingParts()
	{
		System.out.println(" Remaining parts (other than hands) are created.");
	}
	//Instruction manual -how to destroy a robot
	public static void destroyRobot()
	{
		System.out.println(" Refer the manual before destroying of a robot.");
	}
	//Method to destroy hands of a robot
	public void destroyHands()
	{
		System.out.println(" The robot's hands are destroyed.");
	}
	//Method to destroy remaining parts (other than hands) of a robot
	public void destroyRemainingParts()
	{
		System.out.println(" The robot's remaining parts are destroyed.");
	}

}