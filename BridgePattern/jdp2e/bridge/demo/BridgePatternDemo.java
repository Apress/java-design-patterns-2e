package jdp2e.bridge.demo;

//Implementor
interface State
{
	void moveState();
	void hardPressed();
}
//A Concrete Implementor.
class OnState implements State
{
	@Override
	public void moveState() 
	{
		System.out.print("On State\n");
	}

	@Override
	public void hardPressed() 
	{
		System.out.print("\tThe device is already On.Do not press the button so hard.\n");

	}
}
//Another Concrete Implementor.
class OffState implements State
{
	@Override
	public void moveState()
	{
		System.out.print("Off State\n");
	}

	@Override
	public void hardPressed() 
	{
		System.out.print("\tThe device is Offline now.Do not press the off button again.\n");

	}
}
//Abstraction
abstract class ElectronicGoods
{
	//Composition - implementor
	protected State state;
	/*Alternative approach:
	  We can also pass an implementor (as input argument) inside a constructor.
	 */
	/*public ElectronicGoods(State state)
	{
		this.state = state;
	}*/
	public State getState() 
	{
		return state;
	}

	public void setState(State state) 
	{
		this.state = state;
	}
	/*Implementation specific:
	  We are delegating the implementation to the Implementor object. 
	 */
	public void moveToCurrentState() 
	{
		System.out.print("The electronic item is functioning at : ");
		state.moveState();		
	}
	public void hardButtonPressed() 
	{
		state.hardPressed();	
	}

}
//Refined Abstraction
//Television does not want to modify any superclass method.
class Television extends ElectronicGoods
{

	/*public Television(State state)
	{
		super(state);
	}*/	
}
/*DVD class also ok with the super class method.
In addition to this, it uses one additional method*/
class DVD extends ElectronicGoods
{

	/*public DVD(State state)
	{
		super(state);
	}*/
	/* Notice that following DVD specific method is coded with superclass methods 
	  but not with the implementor (State) method.So, this approach will allow to 
	  vary the abstraction and implementation independently. 
	 */
	public void doublePress() {
		hardButtonPressed();
		hardButtonPressed();
	}
}
public class BridgePatternDemo {

	public static void main(String[] args) {
		System.out.println("***Bridge Pattern Demo***");

		System.out.println("\n Dealing with a Television at present.");

		State presentState = new OnState();
		//ElectronicGoods eItem = new Television(presentState);
		ElectronicGoods eItem = new Television();
		eItem.setState(presentState);
		eItem.moveToCurrentState();
		//hard press
		eItem.hardButtonPressed();
		//Verifying Off state of the Television now
		presentState = new OffState();
		//eItem = new Television(presentState);
		eItem.setState(presentState);
		eItem.moveToCurrentState();


		System.out.println("\n Dealing with a DVD now.");
		presentState = new OnState();
		//eItem = new DVD(presentState);
		eItem = new DVD();
		eItem.setState(presentState);
		eItem.moveToCurrentState();		

		presentState = new OffState();
		//eItem = new DVD(presentState);
		eItem = new DVD();
		eItem.setState(presentState);
		eItem.moveToCurrentState();

		//hard press-A DVD specific method
		//(new DVD(presentState)).doublePress();
		((DVD)eItem).doublePress();

		/*The following line of code will cause error because 
		  a television object does not have this method.*/
		//(new Television(presentState)).doublePress();
	}
}