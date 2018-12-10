package jdp2e.decorator.demo;
abstract class Component
{
	public abstract void makeHouse();

}
class ConcreteComponent extends Component
{
	public void makeHouse()
	{            
		System.out.println("Original House is complete. It is closed for modification.");            
	}
}

abstract class AbstractDecorator extends Component
{
	protected Component component ;
	public void setTheComponent(Component c)
	{
		component = c;
	}
	public void makeHouse()
	{
		if (component != null)
		{
			component.makeHouse();//Delegating the task
		}
	}
}
//A floor decorator
class FloorDecorator extends AbstractDecorator
{
	public  void makeHouse()
	{   
		super.makeHouse();		
		//Decorating now.
		System.out.println("***Floor decorator is in action***");
		addFloor();
		//You can put additional stuffs as per your need
	}
	private void addFloor()
	{
		System.out.println("I am making an additional floor on top of it.");
	}
}
//A paint decorator
class PaintDecorator extends AbstractDecorator
{
	public void makeHouse()
	{
		super.makeHouse();	
		//Decorating now.
		System.out.println("***Paint decorator is in action now***");
		paintTheHouse();
		//You can add additional stuffs as per your need
	}
	private void paintTheHouse()
	{
		System.out.println("Now I am painting the house.");         
	}
}

public class DecoratorPatternExample {

	public static void main(String[] args) {
		System.out.println("***Decorator pattern Demo***\n");
		//AbstractDecorator abstractDecorator = new AbstractDecorator();//Compile time error
		ConcreteComponent withoutDecorator = new ConcreteComponent();
		withoutDecorator.makeHouse();
		System.out.println("_________________"); 

		//Using a decorator to add floor
		System.out.println("Using a Floor decorator now."); 
		//FloorDecorator floorDecorator = new FloorDecorator();
		AbstractDecorator floorDecorator = new FloorDecorator();
		floorDecorator.setTheComponent(withoutDecorator);
		floorDecorator.makeHouse();
		System.out.println("_________________"); 

		//Using a decorator to add floor to original house and then paint it.
		System.out.println("Using a Paint decorator now."); 
		//PaintDecorator paintDecorator = new PaintDecorator();
		AbstractDecorator paintDecorator = new PaintDecorator();
		//Adding results from floor decorator
		paintDecorator.setTheComponent(floorDecorator);
		paintDecorator.makeHouse();
		System.out.println("_________________");
		

	}
}
