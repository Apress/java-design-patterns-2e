package jdp2e.observer.demo;

import java.util.*;

interface Observer
{
	void update(int updatedValue);
}
class ObserverType1 implements Observer
{
	String nameOfObserver;
	public ObserverType1(String name)
	{
		this.nameOfObserver = name;
	}   
	@Override
	public void update(int updatedValue) 
	{
		System.out.println( nameOfObserver+" has received an alert: Updated myValue in Subject is: "+ updatedValue);
	}
}
class ObserverType2 implements Observer
{
	String nameOfObserver;
	public ObserverType2(String name)
	{
		this.nameOfObserver = name;
	}
	@Override
	public void update(int updatedValue) 
	{
		System.out.println( nameOfObserver+" has received an alert: The current value of myValue in Subject is: "+ updatedValue);
	}
}

interface SubjectInterface
{
	void register(Observer anObserver);
	void unregister(Observer anObserver);
	void notifyRegisteredUsers(int notifiedValue);
}
class Subject implements SubjectInterface
{
	private int flag;
	public int getFlag() 
	{
		return flag;
	}
	public void setFlag(int flag) 
	{
		this.flag = flag;
		//Flag value changed. So notify registered users/observers.
		notifyRegisteredUsers(flag);
	}
	List<Observer> observerList = new ArrayList<Observer>();    
	@Override
	public void register(Observer anObserver) {
		observerList.add(anObserver);

	}
	@Override
	public void unregister(Observer anObserver) {
		observerList.remove(anObserver);		
	}
	@Override
	public void notifyRegisteredUsers(int updatedValue) 
	{
		for (Observer observer : observerList)
			observer.update(updatedValue);
	}
}
public class ObserverPatternExample {

	public static void main(String[] args) {
		System.out.println(" ***Observer Pattern Demo***\n");
		//We have 3 observers- 2 of them are ObserverType1, 1 of them is of ObserverType2
		Observer myObserver1 = new ObserverType1("Roy");
		Observer myObserver2 = new ObserverType1("Kevin");
		Observer myObserver3 = new ObserverType2("Bose");
		Subject subject = new Subject();
		//Registering the observers-Roy,Kevin,Bose
		subject.register(myObserver1);
		subject.register(myObserver2);
		subject.register(myObserver3);
		System.out.println(" Setting Flag = 5 ");
		subject.setFlag(5);           
		//Unregistering an observer(Roy))
		subject.unregister(myObserver1);
		//No notification this time Roy. Since it is unregistered.
		System.out.println("\n Setting Flag = 50 ");            
		subject.setFlag(50);
		//Roy is registering himself again
		subject.register(myObserver1);
		System.out.println("\n Setting Flag = 100 ");
		subject.setFlag(100);
	}
}
