package jdp2e.iterator.demo;

interface Subjects
{
	Iterator createIterator();        
}
class Arts implements Subjects
{
	private String[] papers;

	public Arts()
	{           
		papers = new String[] { "English","History", "Geography","Psychology" };
	}

	public Iterator createIterator()
	{
		return new ArtsIterator(papers);
	}
}
interface Iterator
{
	void first();//Reset to first element
	String next();//To get the next element
	String currentItem();//To retrieve the current element	
	boolean hasNext();//To check whether there is any next element or not.
}
class ArtsIterator implements Iterator
{
	private String[] papers;
	private int position;
	public ArtsIterator(String[] papers)
	{
		this.papers = papers;
		position = 0;
	}
	@Override
	public void first()
	{
		position = 0;
	}
	@Override
	public String next()
	{
		//System.out.println("Currently pointing to: "+ this.currentItem());
		return papers[position++];
	}	
	@Override
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
}

public class IteratorPatternExample {

	public static void main(String[] args) {
		System.out.println("***Iterator Pattern Demo***");        
		Subjects artsSubjects = new Arts();

		Iterator iteratorForArts = artsSubjects.createIterator();		
		System.out.println("\n Arts subjects are as follows:");		
		while (iteratorForArts.hasNext())
		{
			System.out.println(iteratorForArts.next());
		}
		//Moving back to first element
		iteratorForArts.first();
		System.out.println(" Currently pointing back to: "+ iteratorForArts.currentItem());		
	}
}
