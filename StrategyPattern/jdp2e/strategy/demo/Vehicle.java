package jdp2e.strategy.demo;

//Context class
public abstract class Vehicle 
{
	//A context object contains reference variable/s
	//for the strategy object/s interface type
	TransportMedium transportMedium;
	public Vehicle()
	{

	}
	public void showTransportMedium()
	{
		//Delegate the task to the corresponding behavior class.
		transportMedium.transport();
	}
	//The code that does not vary.
	public void commonJob()
	{
		System.out.println("We all can be used to transport");
	}
	public abstract void showMe();

	/*
	//Additional code to explain the answer of question no 3 in the "Q&A session

	public void setTransportMedium(TransportMedium transportMedium)
	{
		this.transportMedium=transportMedium;
	}	
	*/

}
