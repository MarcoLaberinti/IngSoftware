package myproject2;

import java.util.ArrayList;
public class User {
	private String name;
	private String surname;
	private String email;
	private String passw;
	private boolean type;  //false = soci, true = amministratore
	private ArrayList<Notification> notification;
	
	public User()
	{
		this.name="";
		this.surname="";
		this.email="";
		this.passw="";
		this.type=false;
		this.notification=  new ArrayList<Notification>();
	}
	
	public void set_user(final String Na, final String Su, final String Em, final String Pa, final boolean Tp/*, final ArrayList<Notification> No*/)
	{
		this.name=Na;
		this.surname=Su;
		this.email=Em;
		this.passw=Pa;
		this.type=Tp;
		//this.notification.addAll(No);
	}
	
	public void set_notification(final ArrayList<Notification> No)
	{
		this.notification.addAll(No);
	}

	
	public void print()
	{
		System.out.println(name +" "+ surname +" "+ email +" "+ passw +" "+ type+"\n\nLe tue notifiche:\nVINO	QUANTITA'");
		for (int i=0; i<notification.size(); i++)
			System.out.println(notification.get(i));
		
	}
	
	public String printString()
	{
		String User=name +" "+ surname +" "+ email +" "+ passw +" "+ type+"\n";
		return User;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassw()
	{
		return passw;
	}
	
	public boolean getType()
	{
		return type;
	}
	
	public ArrayList<Notification> getNotification()
	{
		return notification;
	}
	
	public void printNotification()
	{
		for (int i=0; i<notification.size(); i++) {
			notification.get(i).print();
		}

	}
	
	
	
	public String stampaNotification()
	{
		String stampa="";
		for (int i=0; i<notification.size(); i++) {
			stampa= stampa + notification.get(i).getMail()+" "+notification.get(i).getMessage()+" "+notification.get(i).getName()+" "
					+ ""+notification.get(i).getQuantity()+" "+notification.get(i).getYear()+"\n";
		}
		if(stampa=="")
			return "Non è presente nessuna notifica";
		else 
			return stampa;

	}
	


	
	public int size()
	{
		return notification.size();
	}
	
	public String nameWineNotification(int i)
	{
		return notification.get(i).getName();
	}
	
	public String mailWineNotification(int i)
	{
		return notification.get(i).getMail();
	}
	public String messageWineNotification(int i)
	{
		return notification.get(i).getMessage();
	}
	
	public int quantityWineNotification(int i)
	{
		return notification.get(i).getQuantity();
	}
	
	public int yearWineNotification(int i)
	{
		return notification.get(i).getYear();
	}

}
