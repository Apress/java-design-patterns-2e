package jdp2e.templatemethod.demo;

abstract class BasicEngineering
{
	//Making the method final to prevent overriding.
	public final void completeCourse()
	{		
		//The course needs to be completed in the following sequence
		//1.Math-2.SoftSkills-3.Special Paper
		//Common Papers:
		completeMath();
		completeSoftSkills();
		//Specialization Paper:
		completeSpecialPaper();
	}
	private void completeMath()
	{
		System.out.println("1.Mathematics");
	}
	private void completeSoftSkills()
	{
		System.out.println("2.SoftSkills");
	}
	public abstract void completeSpecialPaper();
}
class ComputerScience extends BasicEngineering
{
	@Override
	public void completeSpecialPaper() {
		System.out.println("3.Object-Oriented Programming");

	}
}
class Electronics extends BasicEngineering
{
	@Override
	public void completeSpecialPaper() 
	{    
		System.out.println("3.Digital Logic and Circuit Theory");
    }
}


public class TemplateMethodPatternExample {

	public static void main(String[] args) {
		System.out.println("***Template Method Pattern Demo***\n");
        BasicEngineering preferredCourse = new ComputerScience();
        System.out.println("Computer Sc. course will be completed in following order:");
        preferredCourse.completeCourse();
        System.out.println();
        preferredCourse = new Electronics();
        System.out.println("Electronics course will be completed in following order:");
        preferredCourse.completeCourse();
	}
}
