package jdp2e.iterator.modified.demo;

import java.util.Iterator;

interface Subjects
{
	//Iterator CreateIterator();
	ArtsIterator createIterator(); 
}
class Arts implements Subjects
{
	private String[] papers;

	public Arts()
	{           
		papers = new String[] { "English","History", "Geography","Psychology" };
	}

	//public Iterator CreateIterator()
	public ArtsIterator createIterator()
	{
		return new ArtsIterator(papers);
	}
}
/*Since you are seeing the use of Iterator interface, 
 * there is no need to define your own interface.
 */
/*interface Iterator
{
	void first();//Reset to first element
	String next();//get next element
	boolean isDone();//End of collection check
	String currentItem();//Retrieve Current Item
	
	boolean hasNext() ;
}*/
class ArtsIterator implements Iterator<String>
{
	private String[] papers;
	private int position;
	public ArtsIterator(String[] papers)
	{
		this.papers = papers;
		position = 0;
	}
	public void first()
	{
		position = 0;
	}
	public String currentItem()
	{
		return papers[position];
	}
	@Override
	public boolean hasNext() 
	{
		if(position >= papers.length)
			return false;
		return true;
	}
	@Override
	public String next() 
	{
		return papers[position++];
	}
}

public class ModifiedIteratorPatternExample {

	public static void main(String[] args) {
		System.out.println("***Modified Iterator Pattern Demo.***");         
		Subjects artsSubjects = new Arts();

		//Iterator IteratorForArts = artsSubjects.createIterator();
		ArtsIterator iteratorForArts = artsSubjects.createIterator();
		System.out.println("\nArts subjects are as follows:");		
		while (iteratorForArts.hasNext())
		{
			System.out.println(iteratorForArts.next());
		}		
		//Moving back to first element
		iteratorForArts.first();
		System.out.println("Currently pointing to: "+ iteratorForArts.currentItem());		
	}	
}

