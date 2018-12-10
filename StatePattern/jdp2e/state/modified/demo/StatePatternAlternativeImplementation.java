package jdp2e.state.modified.demo;

interface PossibleStates
{
	void pressOnButton();
	void pressOffButton();
	void pressMuteButton();
}

class Off implements  PossibleStates
{
	TV tvContext;
	//Initially we'll start from Off state
	public Off(TV context)
	{
		//System.out.println(" TV is Off now.");
		this.tvContext = context;
	}
	//Users can press any of these buttons at this state-On, Off or Mute        
	//TV is Off now, user is pressing On button 
	@Override
	public void pressOnButton()
	{
		System.out.println(" You pressed On button. Going from Off to On state");
		tvContext.setCurrentState(tvContext.getOnState());
		System.out.println(tvContext.getCurrentState().toString());
	}
	//TV is Off already, user is pressing Off button again
	@Override
	public void pressOffButton()
	{
		System.out.println(" You pressed Off button. TV is already in Off state");
	}
	//TV is Off now, user is pressing Mute button
	@Override
	public void pressMuteButton()
	{
		System.out.println(" You pressed Mute button.TV is already in Off state, so Mute operation will not work.");
	}
	public String toString()
	{
		return "\t**TV is switched off now.**";
	} 

}
class On implements PossibleStates
{
	TV tvContext;
	public On(TV context)
	{
		//System.out.println(" TV is On now.");
		this.tvContext = context;        
	}
	//Users can press any of these buttons at this state-On, Off or Mute
	//TV is On already, user is pressing On button again
	@Override
	public void pressOnButton()
	{
		System.out.println("You pressed On button. TV is already in On state.");
	}
	//TV is On now, user is pressing Off button
	@Override
	public void pressOffButton()
	{
		System.out.println(" You pressed Off button.Going from On to Off state.");
		tvContext.setCurrentState(tvContext.getOffState());
		System.out.println(tvContext.getCurrentState().toString());
	}
	//TV is On now, user is pressing Mute button
	@Override
	public void pressMuteButton()
	{
		System.out.println("You pressed Mute button.Going from On to Mute mode.");
		tvContext.setCurrentState(tvContext.getMuteState());
		System.out.println(tvContext.getCurrentState().toString());
	}
	public String toString()
	{
		return "\t**TV is switched on now.**";
	} 
}
class Mute implements PossibleStates
{
	TV tvContext;
	public Mute(TV context)
	{
		this.tvContext = context;        
	}
	//Users can press any of these buttons at this state-On, Off or Mute
	//TV is in mute, user is pressing On button
	@Override
	public void pressOnButton()
	{
		System.out.println("You pressed On button.Going from Mute mode to On state.");
		tvContext.setCurrentState(tvContext.getOnState());
		System.out.println(tvContext.getCurrentState().toString());
	}
	//TV is in mute, user is pressing Off button
	@Override
	public void pressOffButton()
	{
		System.out.println("You pressed Off button. Going from Mute mode to Off state.");
		tvContext.setCurrentState(tvContext.getOffState());
		System.out.println(tvContext.getCurrentState().toString());
	}
	//TV is in mute already, user is pressing mute button again
	@Override
	public void pressMuteButton()
	{
		System.out.println(" You pressed Mute button.TV is already in Mute mode.");            
	}
	public String toString()
	{
		return "\t**TV is silent(mute) now**";
	} 
}
class TV
{
	private PossibleStates currentState;
	private PossibleStates onState;
	private PossibleStates offState;
	private PossibleStates muteState;
	public TV()
	{
		onState=new On(this);
		offState=new Off(this);
		muteState=new Mute(this);
		setCurrentState(offState);    	
	}
	public PossibleStates getCurrentState() 
	{
		return currentState;
	}
	public void setCurrentState(PossibleStates currentState) 
	{
		this.currentState = currentState;
	}
	public void pressOffButton()
	{
		currentState.pressOffButton();
	}
	public void pressOnButton()
	{
		currentState.pressOnButton();
	}
	public void pressMuteButton()
	{
		currentState.pressMuteButton();
	}
	public PossibleStates getOnState()
	{
		return onState;
	}
	public PossibleStates getOffState()
	{
		return offState;
	}
	public PossibleStates getMuteState()
	{
		return muteState;
	}
}


//Client
public class StatePatternAlternativeImplementation {

	public static void main(String[] args) {
		System.out.println("***State Pattern Alternative Implementation Demo***\n");
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


