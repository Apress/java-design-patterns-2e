package jdp2e.strategy.demo;
//This class represents an algorithm/behavior.
public class AirTransport implements TransportMedium
{
	@Override
	public void transport()
	{
		System.out.println("I am transporting in air.");		
	}
}