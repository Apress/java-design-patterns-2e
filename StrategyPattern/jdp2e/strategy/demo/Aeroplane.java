package jdp2e.strategy.demo;

public class Aeroplane extends Vehicle
{
	public Aeroplane()
	{
		transportMedium= new AirTransport();
	}

	@Override
	public void showMe() {
		System.out.println("I am an aeroplane.");

	}
}
