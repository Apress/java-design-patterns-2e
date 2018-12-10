package jdp2e.singleton.demo;

 final class MakeACaptain
{
	private static MakeACaptain captain; 
	//We make the constructor private to prevent the use of "new"
	static int numberOfInstance=0;
	private MakeACaptain() { 
		numberOfInstance++;
		System.out.println("Number of instances at this moment="+ numberOfInstance);
		}	

   public static synchronized MakeACaptain getCaptain()
   //public static  MakeACaptain getCaptain()
    { 
	        
	    	 // Lazy initialization
	    	 if (captain == null) 
	    	 { 
	    		 captain = new MakeACaptain();	    	 
	    	    System.out.println("New captain is elected for your team."); 
	    	 } 
	    	 else
	    	 { 
	    		 System.out.print("You already have a captain for your team.");
	    		 System.out.println("Send him for the toss.");
	         } 
	    	 return captain;	    	 
	  }
  /* //A non-static nested class (inner class)
   public class MakeACaptainDerived extends MakeACaptain
   {
   
   }*/
}
// We cannot extend MakeACaptain.The constructor is private in this case.
//class B extends MakeACaptain{}// error
public class SingletonPatternExample {
	public static void main(String[] args) {
		System.out.println("***Singleton Pattern Demo***\n");		
		System.out.println("Trying to make a captain for your team:");
		//Constructor is private.We cannot use "new" here.
		//MakeACaptain c3 = new MakeACaptain();//error
		MakeACaptain c1 = MakeACaptain.getCaptain();		
		System.out.println("Trying to make another captain for your team:");
		MakeACaptain c2 = MakeACaptain.getCaptain();
			if (c1 == c2) 
			{ 
				System.out.println("c1 and c2 are same instance."); 
			}
			//MakeACaptain.MakeACaptainDerived derived=c1.new MakeACaptainDerived();			
	}
}
