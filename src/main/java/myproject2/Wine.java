package myproject2;
//

public class Wine {
	
	private String name;
	private int year;
	private String note;
	private String origin;
	private int nBottleP;		//number of bottle made in that year
	private int nBottle;		//number of bottle available in the shop
	
	public Wine()
	{
		this.name="";
		this.year=0;
		this.note="";
		this.origin="";
		this.nBottle=0;
		this.nBottleP=0;
	}
	
	public void set_wine(final String Na, final
			int Ye, final String No, final String Or, final int nBp, final int nB)
	{
		this.name=Na;
		this.year=Ye;
		this.note=No;
		this.origin=Or;
		this.nBottleP=nBp;				//bottiglie prodotte totali
		this.nBottle=nB;
	}
	
	public void print()
	{
		System.out.println(name +"	"+ year +"	"+ note +"	"+ origin +"	"+nBottleP+"	"+ nBottle);
	}
	
	public String printString()
	{
		String Wine=name +"	"+ year +" "+ note +" "+ origin +" "+nBottleP+" "+ nBottle+"\n";
		return Wine;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getNumberBottle()
	{
		return nBottle;
	}
	
	public String getNote()
	{
		return note;
	}
	
	public String getOrigin()
	{
		return origin;
	}
	
	public int getNumberBottleMade()
	{
		return nBottleP;
	}
	
	


}
