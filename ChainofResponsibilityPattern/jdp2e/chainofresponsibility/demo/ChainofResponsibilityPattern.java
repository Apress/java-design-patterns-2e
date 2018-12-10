package jdp2e.chainofresponsibility.demo;

enum MessagePriority
{
	NORMAL,
	HIGH
}
class Message
{
	public String text;
	public MessagePriority priority;
	public Message(String msg, MessagePriority p)
	{
		text = msg;
		this.priority = p;
	}
}

interface Receiver
{
	boolean handleMessage(Message message);
	void nextErrorHandler(Receiver nextReceiver);
}
class IssueRaiser
{
	public Receiver setFirstReceiver;
	public void setFirstErrorHandler(Receiver firstErrorHandler)
	{
		this.setFirstReceiver = firstErrorHandler;
	}
	public void raiseMessage(Message message)
	{
		if (setFirstReceiver != null)
			setFirstReceiver.handleMessage(message);
	}
}
//FaxErrorHandler class
class FaxErrorHandler implements Receiver
{
	private Receiver nextReceiver;
	@Override
	public void nextErrorHandler(Receiver nextReceiver)
	{
		this.nextReceiver = nextReceiver;
	}
	@Override
	public boolean handleMessage(Message message)
	{
		if (message.text.contains("Fax"))
		{
			System.out.println(" FaxErrorHandler processed " +message.priority +" priority issue :"+ message.text);
			return true;
		}
		else
		{
			if (nextReceiver != null)
				nextReceiver.handleMessage(message);
		}
		return false;
	}	
}
//EmailErrorHandler class
class EmailErrorHandler implements Receiver
{
	private Receiver nextReceiver;
	@Override
	public void nextErrorHandler(Receiver nextReceiver)
	{
		this.nextReceiver = nextReceiver;
	}
	@Override
	public boolean handleMessage(Message message)
	{
		if (message.text.contains("Email"))
		{
			System.out.println(" EmailErrorHandler processed "+message.priority+ " priority issue: "+message.text);
			return true;
		}
		else
		{
			if (nextReceiver != null)
				nextReceiver.handleMessage(message);
		}
		return false;
	}
}
//Client code
public class ChainofResponsibilityPattern {

	public static void main(String[] args) {
		System.out.println("\n ***Chain of Responsibility Pattern Demo***\n");
		/* Forming the chain as IssueRaiser->FaxErrorhandler->EmailErrorHandler */
		Receiver faxHandler, emailHandler;            
		//Objects of the chains
		IssueRaiser issueRaiser = new IssueRaiser();		
		faxHandler = new FaxErrorHandler();
		emailHandler = new EmailErrorHandler();
		//Making the chain
		//Starting point:IssueRaiser will raise issues and set the first handler
		issueRaiser.setFirstErrorHandler(faxHandler);
		//FaxErrorHandler will pass the error to EmailHandler if needed. 
		faxHandler.nextErrorHandler(emailHandler);
		//EmailErrorHandler will be placed at the last position in the chain
		emailHandler.nextErrorHandler(null);	

		Message m1 = new Message("Fax is going slow.", MessagePriority.NORMAL);
		Message m2 = new Message("Emails are not reaching.", MessagePriority.HIGH);
		Message m3 = new Message("In Email, CC field is disabled always.", MessagePriority.NORMAL);
		Message m4 = new Message("Fax is not reaching destinations.", MessagePriority.HIGH);

		issueRaiser.raiseMessage(m1);
		issueRaiser.raiseMessage(m2);
		issueRaiser.raiseMessage(m3);
		issueRaiser.raiseMessage(m4);
	}
}