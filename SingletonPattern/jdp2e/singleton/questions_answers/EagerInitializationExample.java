package jdp2e.singleton.questions_answers;

class MakeACaptain
{
    //Early initialization
    private static final MakeACaptain captain = new MakeACaptain();          
    //We make the constructor private to prevent the use of "new"  
    private MakeACaptain() 
    {
    	System.out.println("A captain is elected for your team."); 
    }
    /* Global point of access.The method getCaptain() is a public static method*/
    public static MakeACaptain getCaptain()
    { 
    	System.out.println("You have a captain for your team."); 
    	return captain;
    }
    public static void dummyMethod()
    { 
    	System.out.println("It is a dummy method");    	
    }    
}

public class EagerInitializationExample {
	public static void main(String[] args) {
		System.out.println("***Singleton Pattern Demo With Eager Initialization***\n");
		MakeACaptain.dummyMethod();
		/*System.out.println("Trying to make a captain for your team:");
		MakeACaptain c1 = MakeACaptain.getCaptain();		
		System.out.println("Trying to make another captain for your team:");
		MakeACaptain c2 = MakeACaptain.getCaptain();
			if (c1 == c2) 
			{ 
				System.out.println("c1 and c2 are same instance."); 
			}*/
	}
}