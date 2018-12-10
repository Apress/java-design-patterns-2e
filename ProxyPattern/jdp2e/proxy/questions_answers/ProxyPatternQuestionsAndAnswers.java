package jdp2e.proxy.questions_answers;


//Abstract class Subject
abstract class Subject
{
	public abstract void doSomeWork();
}
//ConcreteSubject class
class ConcreteSubject extends Subject
{
	@Override
	public void doSomeWork() 
	{
		System.out.println("doSomeWork() inside ConcreteSubject is invoked");
	}
}

/**
 * @author sarcarv
 * Proxy Class
 * It will try to invoke the doSomeWork() of a ConcreteSubject instance *
 */
class Proxy extends  Subject
{
	static Subject cs;
	static int count=0;//A counter to track the number of instances
	public Proxy()
	{
		//Instantiating inside the constructor
		cs = new ConcreteSubject();
		count ++;
	}

	@Override
	public void doSomeWork() 
	{
		System.out.println("Proxy call happening now...");
		//Lazy initialization:We'll not instantiate until the method is called
		/*if (cs == null)
		{
			cs = new ConcreteSubject();
			count ++;
		}*/
		cs.doSomeWork();
	}
}

/**
 * @author sarcarv
 * The client is talking to a ConcreteSubject instance 
 * through a proxy method.
 */
public class ProxyPatternQuestionsAndAnswers {
	public static void main(String[] args) {
		//System.out.println("***Proxy Pattern Demo without lazy instantiation***\n");
		System.out.println("***Proxy Pattern Demo with lazy instantiation***\n");
		Proxy px = new Proxy();
		px.doSomeWork();
		//2nd proxy instance
		Proxy px2 = new Proxy();
		px2.doSomeWork();

		System.out.println("Instance Count="+Proxy.count);
	}
}

