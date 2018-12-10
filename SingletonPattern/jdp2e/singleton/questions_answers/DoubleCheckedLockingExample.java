package jdp2e.singleton.questions_answers;

final class MakeACaptain2
{
	private static MakeACaptain2 captain; 
	//We make the constructor private to prevent the use of "new"
	static int numberOfInstance=0;
	private MakeACaptain2() { 
		numberOfInstance++;
		System.out.println("Number of instances at this moment="+ numberOfInstance);
	}	

	public static  MakeACaptain2 getCaptain(){
		if (captain == null) {
			synchronized (MakeACaptain2.class) {
				// Lazy initialization
				if (captain == null){ 
					captain = new MakeACaptain2();	    	 
					System.out.println("New captain is elected for your team."); 
				} 
				else
				{ 
					System.out.print("You already have a captain for your team.");
					System.out.println("Send him for the toss.");
				} 
			}			 
		}
		return captain;
	}
}
public class DoubleCheckedLockingExample {
	public static void main(String[] args) {
		System.out.println("***Singleton Pattern Demo With Double Checked Locking***\n");		
		System.out.println("Trying to make a captain for your team:");
		//Constructor is private.We cannot use "new" here.
		//MakeACaptain2 c3 = new MakeACaptain();//error
		MakeACaptain2 c1 = MakeACaptain2.getCaptain();		
		System.out.println("Trying to make another captain for your team:");
		MakeACaptain2 c2 = MakeACaptain2.getCaptain();
		if (c1 == c2) 
		{ 
			System.out.println("c1 and c2 are same instance."); 
		}						
	}
}
