package jdp2e.proxy.demo;

// Abstract class Subject
abstract class Subject
{
	public abstract void doSomeWork();
}
// ConcreteSubject class
class ConcreteSubject extends Subject
{
	@Override
	public void doSomeWork() 
	{
		System.out.println("doSomeWork() inside ConcreteSubject is invoked.");
	}
}

/**
 * @author sarcarv
 * Proxy Class:It will try to invoke the doSomeWork() 
 * of a ConcreteSubject instance *
 */
class Proxy extends  Subject
{
	static Subject cs;
	@Override
	public void doSomeWork() 
	{
		System.out.println("Proxy call happening now...");
		//Lazy initialization:We'll not instantiate until the method is called
		if (cs == null)
		{
			cs = new ConcreteSubject();			
		}
		cs.doSomeWork();

	}
}

/**
 * @author sarcarv
 * The client is talking to a ConcreteSubject instance 
 * through a proxy method.
 */
public class ProxyPatternExample {
	public static void main(String[] args) {
		System.out.println("***Proxy Pattern Demo***\n");
		Proxy px = new Proxy();
		px.doSomeWork();	

	}
}
