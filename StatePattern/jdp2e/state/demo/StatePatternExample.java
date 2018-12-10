package jdp2e.state.demo;
interface PossibleState
{
	void pressOnButton(TV context);
	void pressOffButton(TV context);
	void pressMuteButton(TV context);
}
//Off state
class Off implements  PossibleState
{
	//User is pressing Off button when the TV is in Off state
	@Override
	public void pressOnButton(TV context)
	{
		System.out.println("You pressed On button. Going from Off to On state.");
		context.setCurrentState(new On());
		System.out.println(context.getCurrentState().toString());
	}
	//TV is Off already, user is pressing Off button again
	@Override
	public void pressOffButton(TV context)
	{
		System.out.println("You pressed Off button. TV is already in Off state.");
	}
	//User is pressing Mute button when the TV is in Off state    
	@Override
	public void pressMuteButton(TV context)
	{
		System.out.println("You pressed Mute button.TV is already in Off state, so Mute operation will not work.");
	}
	public String toString()
	{
		return "\t**TV is switched off now.**";
	} 
}
//On state
class On implements PossibleState
{
	//TV is On already, user is pressing On button again
	@Override
	public void pressOnButton(TV context)
	{
		System.out.println("You pressed On button. TV is already in On state.");
	}
	//User is pressing Off button when the TV is in On state    
	@Override
	public void pressOffButton(TV context)
	{
		System.out.println("You pressed Off button.Going from On to Off state.");
		context.setCurrentState(new Off());
		System.out.println(context.getCurrentState().toString());
	}
	//User is pressing Mute button when the TV is in On state
	@Override
	public void pressMuteButton(TV context)
	{
		System.out.println("You pressed Mute button.Going from On to Mute mode.");
		context.setCurrentState(new Mute());
		System.out.println(context.getCurrentState().toString());
	}
	public String toString()
	{
		return "\t**TV is switched on now.**";
	} 
}
//Mute state
class Mute implements PossibleState
{
	//User is pressing On button when the TV is in Mute mode
	@Override
	public void pressOnButton(TV context)
	{
		System.out.println("You pressed On button.Going from Mute mode to On state.");
		context.setCurrentState(new On());
		System.out.println(context.getCurrentState().toString());
	}
	//User is pressing Off button when the TV is in Mute mode
	@Override
	public void pressOffButton(TV context)
	{
		System.out.println("You pressed Off button. Going from Mute mode to Off state.");
		context.setCurrentState(new Off());
		System.out.println(context.getCurrentState().toString());
	}
	//TV is in mute mode already, user is pressing mute button again
	@Override
	public void pressMuteButton(TV context)
	{
		System.out.println("You pressed Mute button.TV is already in Mute mode.");            
	}
	public String toString()
	{
		return "\t**TV is silent(mute) now**";
	} 
}
class TV
{
	private PossibleState currentState;
	public TV()
	{
		//Initially TV is initialized with Off state
		this.setCurrentState(new Off());
	}
	public PossibleState getCurrentState() 
	{
		return currentState;
	}
	public void setCurrentState(PossibleState currentState) 
	{
		this.currentState = currentState;
	}
	public void pressOffButton()
	{
		currentState.pressOffButton(this);//Delegating the state
	}
	public void pressOnButton()
	{
		currentState.pressOnButton(this);//Delegating the state
	}
	public void pressMuteButton()
	{
		currentState.pressMuteButton(this);//Delegating the state
	}       
}


//Client
public class StatePatternExample {

	public static void main(String[] args) {
		System.out.println("***State Pattern Demo***\n");
		//Initially TV is Off.
		TV tv = new TV();		
		System.out.println("User is pressing buttons in the following sequence:");
		System.out.println("Off->Mute->On->On->Mute->Mute->Off\n");
		//TV is already in Off state.Again Off button is pressed.
		tv.pressOffButton();
		//TV is already in Off state.Again Mute button is pressed.
		tv.pressMuteButton();
		//Making the TV on
		tv.pressOnButton();            
		//TV is already in On state.Again On button is pressed.
		tv.pressOnButton();
		//Putting the TV in Mute mode
		tv.pressMuteButton();
		//TV is already in Mute mode.Again Mute button is pressed.
		tv.pressMuteButton();
		//Making the TV off
		tv.pressOffButton();
	}

}


