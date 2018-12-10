package jdp2e.strategy.demo;

//Client code
public class StrategyPatternExample {

	public static void main(String[] args) {
		System.out.println("***Strategy Pattern Demo***");
		Vehicle vehicleContext=new Boat();
		vehicleContext.showMe();
		vehicleContext.showTransportMedium();
		System.out.println("________");

		vehicleContext=new Aeroplane();
		vehicleContext.showMe();
		vehicleContext.showTransportMedium();		
		
		/*
		 * System.out.println("________");
		//Additional code to explain the answer of question no 3 in the "Q&A session
		vehicleContext=new SpecialVehicle();
		vehicleContext.showMe();
		vehicleContext.showTransportMedium();
		System.out.println("- - - - -");
		//Changing the behavior of Special vehicle
		vehicleContext.setTransportMedium(new WaterTransport());
		vehicleContext.showTransportMedium();
		*/
		

	}

}
