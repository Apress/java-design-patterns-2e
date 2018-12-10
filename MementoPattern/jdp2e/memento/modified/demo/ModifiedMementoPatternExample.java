package jdp2e.memento.modified.demo;

import java.util.ArrayList;
import java.util.List;

class Memento
{
	private int stateId;
	public Memento(int stateId)
	{
		this.stateId = stateId;
	}   
	public int getStateId() {
		return stateId;
	}
	/*This class should not have the
    setter method.We need to use this class
    to get the state of the object only.*/

	/*public void setState(String state) {
		this.state = state;
	}*/

}

/* 
// The ‘Originator’ class
//WikiPedia notes( for your reference):
//Make an object (originator) itself responsible for:
//1.Saving its internal state to a(memento) object and
//2.Restoring to a previous state from a(memento) object.
//3.Only the originator that created a memento is allowed to access it.
 */
class Originator
{
	private int stateId;
	Memento myMemento;
	public Originator()
	{
		this.stateId = 0;
		System.out.println(" Originator is created with state id : "+ stateId);
	}


	public int getStateId() 
	{
		return stateId;
	}

	public void setStateId(int stateId)	
	{		
		System.out.println(" Setting the state id of the originator to : "+ stateId);
		this.stateId= stateId;		
	}
	//Saving its internal state to a(memento) object
	public Memento saveMemento(int stateId) 
	{
		System.out.println(" Saving originator's current state id. ");
		//Create memento with the current state and return it.
		return new Memento(stateId);		
	}

	//Restoring to a previous state from a(memento) object.
	public void revertMemento(Memento previousMemento)
	{
		System.out.println(" Restoring to state id..."+ previousMemento.getStateId());
		this.stateId = previousMemento.getStateId();
		System.out.println(" Current state id of originator : "+ stateId);
	}
} 

/*
//The modified 'Caretaker' class.
//WikiPedia notes( for your reference):
//1.A client (caretaker) can request a memento from the originator 
//	 to save the internal state of the originator and
//2.Pass a memento back to the originator (to restore to a previous state)
//This enables to save and restore the internal state of an originator 
//without violating its encapsulation.
 */

public class ModifiedMementoPatternExample {

	public static void main(String[] args) {
		System.out.println("***Modified Memento Pattern Demo***\n");
		List<Memento> savedStateIds = new ArrayList<Memento>();
		//Originator is initialized with a state
		Originator originatorObject = new Originator();
		Memento mementoObject;
		originatorObject.setStateId(1);
		mementoObject=originatorObject.saveMemento(originatorObject.getStateId());
		savedStateIds.add( mementoObject);
		System.out.println(" Snapshot #1: Originator's current state id is saved in caretaker.");
		//A client or caretaker cannot set/modify the memento's state
		//mementoObject.setState("arbitratyState");//error

		//Changing the state id of Originator
		originatorObject.setStateId(2);
		mementoObject=originatorObject.saveMemento(originatorObject.getStateId());
		savedStateIds.add( mementoObject);
		System.out.println(" Snapshot #2: Originator's current state id is saved in caretaker.");

		//Changing the state id of Originator
		originatorObject.setStateId(3);
		mementoObject=originatorObject.saveMemento(originatorObject.getStateId());
		savedStateIds.add( mementoObject);
		System.out.println(" Snapshot #3: Originator's current state id is saved in caretaker (client).");

		//Reverting back to previous state id.
		//originatorObject.revertMemento(mementoObject);
		//Reverting back to specific id -say, Snapshot #1)
		//originatorObject.revertMemento(savedStateIds.get(0));

		//Roll back everything...
		System.out.println("Started restoring process...");
		for (int i = savedStateIds.size(); i > 0; i--)
		{
			originatorObject.revertMemento(savedStateIds.get(i-1));               
		}
	}
}


