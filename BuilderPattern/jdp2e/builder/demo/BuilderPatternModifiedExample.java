package jdp2e.builder.demo;

//The common interface
interface ModifiedBuilder
{
	/*All these methods return type is ModifiedBuilder.
	 * This will help us to apply method chaining */
	ModifiedBuilder startUpOperations(String startUpMessage);
	ModifiedBuilder buildBody(String bodyType);
	ModifiedBuilder insertWheels(int noOfWheels);
	ModifiedBuilder addHeadlights(int noOfHeadLights);
	ModifiedBuilder endOperations(String endOperationsMessage);
	/*Combine the parts and make the final product.*/
	ProductClass constructCar();
	//Optional method:To get the already constructed object
	ProductClass getConstructedCar();
}
//Car class
class CarBuilder implements ModifiedBuilder
{
	private String startUpMessage="Start building the product";//Default start-up message
	private String  bodyType="Steel";//Default body
	private int noOfWheels=4;//Default number of wheels
	private int  noOfHeadLights=2;//Default number of head lights
	private String  endOperationsMessage="Product creation completed";//Default finish up message
	ProductClass product;
	@Override
	public ModifiedBuilder startUpOperations(String startUpMessage) 
	{
		this.startUpMessage=startUpMessage;
		return this;
	}

	@Override
	public ModifiedBuilder buildBody(String bodyType) 
	{
		this.bodyType=bodyType;
		return this;
	}

	@Override
	public ModifiedBuilder insertWheels(int noOfWheels) 
	{
		this.noOfWheels=noOfWheels;		
		return this;
	}

	@Override
	public ModifiedBuilder addHeadlights(int noOfHeadLights) 
	{
		this.noOfHeadLights=noOfHeadLights;
		return this;
	}
	@Override
	public ModifiedBuilder endOperations(String endOperationsMessage) 
	{	this.endOperationsMessage=endOperationsMessage;
	return this;
	}

	@Override
	public ProductClass constructCar() {

		product= new ProductClass(this.startUpMessage,this.bodyType,this.noOfWheels,this.noOfHeadLights,this.endOperationsMessage);
		return product;
	}

	@Override
	public ProductClass getConstructedCar() 
	{		
		return product;
	}	
}

//Product class 
final class ProductClass
{
	private String startUpMessage;	
	private String  bodyType;
	private int noOfWheels;
	private int  noOfHeadLights;
	private String  endOperationsMessage;
	public ProductClass(final String startUpMessage, String bodyType, int noOfWheels, int noOfHeadLights,
			String endOperationsMessage) {
		this.startUpMessage = startUpMessage;
		this.bodyType = bodyType;
		this.noOfWheels = noOfWheels;
		this.noOfHeadLights = noOfHeadLights;
		this.endOperationsMessage = endOperationsMessage;
	}
	/*There is no setter methods used here to promote immutability.
	Since the attributes are private and there is no setter methods, the keyword "final"
	is not needed to attach with the attributes.
	 */	
	@Override
	public String toString() {
		return "Product Completed as:\n startUpMessage=" + startUpMessage + "\n bodyType=" + bodyType + "\n noOfWheels="
				+ noOfWheels + "\n noOfHeadLights=" + noOfHeadLights + "\n endOperationsMessage=" + endOperationsMessage
				;
	}

}
//Director class 
public class BuilderPatternModifiedExample {

	public static void main(String[] args) {
		System.out.println("***Modified Builder Pattern Demo***");
		/*Making a custom car (through builder)
		  Note the steps:
		  Step1:Get a builder object with required parameters
		  Step2:Setter like methods are used.They will set the optional fields also.
		  Step3:Invoke the constructCar() method to get the final car.
		 */
		final ProductClass customCar1 = new CarBuilder().addHeadlights(5)
				.insertWheels(5)
				.buildBody("Plastic")
				.constructCar();
		System.out.println(customCar1);
		System.out.println("--------------");
		/* Making another custom car (through builder) with a different 
		 * sequence and steps.
		 */
		ModifiedBuilder carBuilder2=new CarBuilder();
		final ProductClass customCar2 = carBuilder2.insertWheels(7)
				.addHeadlights(6)
				.startUpOperations("I am making my own car")
				.constructCar();		
		System.out.println(customCar2);
		System.out.println("--------------");

		/*customCar2 = carBuilder2.insertWheels(70)//error because customCar2 is final
				.addHeadlights(6)
				.startUpOperations("I am making my own car")
				.constructCar();		
		System.out.println(customCar2);	*/
		//Verifying the getConstructedCar() method
		final ProductClass customCar3=carBuilder2.getConstructedCar();		
		System.out.println(customCar3);

	}
}
