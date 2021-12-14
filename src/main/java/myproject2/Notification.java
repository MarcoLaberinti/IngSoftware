package myproject2;

public class Notification {
	
	private String mail;
	private String message;
	private String name;
	private int year;
	private int quantity;
	
	public Notification()
	{
		this.mail="";
		this.message="";
		this.name="";
		this.year=0;
		this.quantity=0;
	}
	
	public Notification(final String Ma, final String Me, final String Na, final int Ye, final int Qu)
	{
		mail=Ma;
		message=Me;
		name=Na;
		year=Ye;
		quantity=Qu;
	}
	
	
	public void set_Notification(final String Ma, final String Me, final String Na, final int Ye, final int Qu)
	{
		this.mail=Ma;
		this.message=Me;
		this.name=Na;
		this.year=Ye;
		this.quantity=Qu;
	}
		
	public void print()
	{
		System.out.println(mail+"	"+message+"	"+name+"	"+year+"	"+quantity);
	}
	
	public String printString()
	{
		String Notification=mail+" "+message+" "+name+"	"+year+" "+quantity+"\n";
		return Notification;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public String getMail()
	{
		return mail;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public int getYear()
	{
		return year;
	}

}
