package jdp2e.strategy.questions_answers;

abstract class Vehicle 
{
	/*//Default implementation
	public void showTransportMedium()
	{
		System.out.println("I am transporting in air.");
	}*/
	//The code that does not vary.
	public void commonJob()
	{
		System.out.println("We all can be used to transport");
	}
	public abstract void showMe();
}
interface TransportInterface
{
	void showTransportMedium();
}
class Aeroplane extends Vehicle implements TransportInterface
{
	@Override
	public void showMe() {
		System.out.println("I am an aeroplane.");

	}
	@Override
	public void showTransportMedium() {
		System.out.println("I am transporting in air.");		
	}
}
class Boat extends Vehicle implements TransportInterface
{
	@Override
	public void showMe() 
	{
		System.out.println("I am a boat.");

	}
	@Override
	public void showTransportMedium() {
		System.out.println("I am transporting in water.");
		
	}
}
class SpeedBoat extends Vehicle implements TransportInterface
{
	@Override
	public void showMe() {
		System.out.println("I am a speedboat.");

	}
	@Override
	public void showTransportMedium() {
		System.out.println("I am transporting in water with high speed.");
	}
}
public class Client {

	public static void main(String[] args) {
		Aeroplane aeroplane=new Aeroplane();
		aeroplane.showMe();
		aeroplane.showTransportMedium();
		
		Boat boat=new Boat();
		boat.showMe();
		boat.showTransportMedium();
		
		SpeedBoat speedboat=new SpeedBoat();
		speedboat.showMe();
		speedboat.showTransportMedium();
		

	}

}
