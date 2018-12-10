package jdp2e.abstractfactory.demo;

interface Dog
{
	void speak();        
	void preferredAction();
}

interface Tiger
{
	void speak();        
	void preferredAction();
}

//Types of Dogs-wild dogs and pet dogs
class WildDog implements Dog
{
	@Override
	public void speak() 
	{
		System.out.println("Wild Dog says loudly: Bow-Wow.");

	}
	@Override
	public void preferredAction()
	{
		System.out.println("Wild Dogs prefer to roam freely in jungles.\n");

	}
}
class PetDog implements Dog
{
	@Override
	public void speak() 
	{
		System.out.println("Pet Dog says softly: Bow-Wow.");		
	}
	@Override
	public void preferredAction()
	{
		System.out.println("Pet Dogs prefer to stay at home.\n");

	}        
}
//Types of Tigers-wild tigers and pet tigers
class WildTiger implements Tiger
{
	@Override
	public void speak()
	{
		System.out.println("Wild Tiger says loudly: Halum.");

	}
	@Override
	public void preferredAction()
	{
		System.out.println("Wild Tigers prefer hunting in jungles.\n");

	}
}
class PetTiger implements Tiger
{
	@Override
	public void speak() 
	{
		System.out.println("Pet Tiger says softly: Halum.");

	}
	@Override
	public void preferredAction()
	{
		System.out.println("Pet Tigers play in the animal circus.\n");
	}        
}

//Abstract Factory
interface AnimalFactory
{
	Dog createDog();
	Tiger createTiger();
}
//Concrete Factory-Wild Animal Factory
class WildAnimalFactory implements AnimalFactory
{
	@Override
	public Dog createDog()
	{
		return new WildDog();
	}
	@Override
	public Tiger createTiger()
	{
		return new WildTiger();
	}

}
//Concrete Factory-Pet Animal Factory
class PetAnimalFactory implements AnimalFactory
{
	@Override
	public Dog createDog() 
	{
		return new PetDog();
	}
	@Override
	public Tiger createTiger() 
	{
		return new PetTiger();
	}
}
//Client

class AbstractFactoryPatternExample {
	//Alternative design-shown in commented lines.
	//private AnimalFactory myAnimalFactory;
	/*public AbstractFactoryPatternExample(AnimalFactory factoryType)
	{
		this.myAnimalFactory=factoryType;
	}
	public Dog createDog()
	{
		Dog dog=myAnimalFactory.createDog();
		return dog;
	}
	public Tiger createTiger()
	{
		Tiger tiger=myAnimalFactory.createTiger();
		return tiger;
	}*/
	public static void main(String[] args) {
		AnimalFactory myAnimalFactory;
		Dog myDog;
		Tiger myTiger;
		System.out.println("***Abstract Factory Pattern Demo***\n");
		//AbstractFactoryPatternExample client=new AbstractFactoryPatternExample(new WildAnimalFactory());
		//Making a wild dog through WildAnimalFactory
		myAnimalFactory = new WildAnimalFactory();
		myDog = myAnimalFactory.createDog();            
		myDog.speak();
		myDog.preferredAction();
		//Making a wild tiger through WildAnimalFactory
		myTiger = myAnimalFactory.createTiger();        
		myTiger.speak();
		myTiger.preferredAction();

		System.out.println("******************");

		//Making a pet dog through PetAnimalFactory
		//client=new AbstractFactoryPatternExample(new PetAnimalFactory());
		myAnimalFactory = new PetAnimalFactory();		
		myDog = myAnimalFactory.createDog();            
		myDog.speak();
		myDog.preferredAction();
		//Making a pet tiger through PetAnimalFactory
		myTiger = myAnimalFactory.createTiger();        
		myTiger.speak();
		myTiger.preferredAction();

	}

}
