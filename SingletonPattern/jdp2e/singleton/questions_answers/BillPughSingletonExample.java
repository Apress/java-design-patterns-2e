package jdp2e.singleton.questions_answers;

class MakeACaptain1
{
	//private static MakeACaptain captain; 
	private MakeACaptain1() {
		System.out.println("A captain is elected for your team.");
	}
	//Bill Pugh solution
	private static class SingletonHelper{
		/*Nested class is referenced after getCaptain() is called*/

		private static final MakeACaptain1 captain = new MakeACaptain1();	          
	}

	public static MakeACaptain1 getCaptain()
	{
		return SingletonHelper.captain;
	}
	/*public static void dummyMethod()
	{ 
		System.out.println("It is a dummy method");    	
	}*/
}


public class BillPughSingletonExample {
	public static void main(String[] args) {
		System.out.println("***Singleton Pattern Demo With Bill Pugh's Solution***\n");
		//MakeACaptain1.dummyMethod();
		System.out.println("Trying to make a captain for your team:");
		MakeACaptain1 c1 = MakeACaptain1.getCaptain();		
		System.out.println("Trying to make another captain for your team:");
		MakeACaptain1 c2 = MakeACaptain1.getCaptain();
			if (c1 == c2) 
			{ 
				System.out.println("c1 and c2 are same instance."); 
			}
	}
}