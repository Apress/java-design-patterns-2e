package jdp2e.strategy.demo;

public class Boat extends Vehicle
{
	public Boat()
	{
		transportMedium= new WaterTransport();
	}
	@Override
	public void showMe() {
		System.out.println("I am a boat.");
		
	}
}
