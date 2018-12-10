package jdp2e.templatemethod.questions_answers;

abstract class BasicEngineering
{
	//Making the method final to prevent overriding.
	public final void completeCourse()
	{
		//The course needs to be completed in the following sequence
		//1.Math-2.SoftSkills-3.Special Paper-4.Additional Papers(if any)
		//Common Papers:
		completeMath();
		completeSoftSkills();
		//Specialization Paper:
		completeSpecialPaper();
		if (isAdditionalPapersNeeded())
		{
			completeAdditionalPapers();
		}
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
	private void completeAdditionalPapers() 
	{
		System.out.println("4.Additional Papers are needed for this course.");		
	}
	//By default, AdditionalPapers are needed for a course.
	boolean isAdditionalPapersNeeded() 
	{
		return true;
	}	
}
class ComputerScience extends BasicEngineering
{
	@Override
	public void completeSpecialPaper() 
	{
		System.out.println("3.Object-Oriented Programming");
	}
	//Additional papers are needed for ComputerScience
	//So, there is no change for the hook method.	
}
class Electronics extends BasicEngineering
{
	@Override
	public void completeSpecialPaper()  
	{    
		System.out.println("3.Digital Logic and Circuit Theory");
	}
	//Overriding the hook method:
	//Indicating that 'AdditionalPapers' are not needed for Electronics.	
	@Override	
	public  boolean isAdditionalPapersNeeded()
	{
		return false;
	}
}

public class TemplateMethodPatternModifiedExample {

	public static void main(String[] args) {
		System.out.println("***Template Method Pattern Modified Demo***\n");
		BasicEngineering preferrredCourse = new ComputerScience();
		System.out.println("Computer Sc. course will be completed in following order:");
		preferrredCourse.completeCourse();
		System.out.println();
		preferrredCourse = new Electronics();
		System.out.println("Electronics course will be completed in following order:");
		preferrredCourse.completeCourse();
	}
}	
