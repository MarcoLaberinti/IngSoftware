//package myproject2;
//
//import java.util.Scanner;
//import java.util.ArrayList;
//
//
//public class Test {
//	public static void main(String[] args)
//	{	
//		Scanner scan = new Scanner(System.in);
//
//		ArrayList<Notification> notify=  new ArrayList<Notification>();
//		ArrayList<Notification> order=  new ArrayList<Notification>();
//		User[] user= new User[3];
//		
//		for(int i=0; i<user.length; i++) 											   //set array of user
//		{
//			user[i]=new User();
//		}	
//		
////		user[0].set_user("Admin", "Admin", "admin@", "1234", true, notify);   //admin
////		//utenti[1].set_user("UX", "UX", "UX", "1234", false, notify);				   //1nd user
////		user[1].set_user("UY", "UY", "UY@", "1234", false, notify);  		  		   //2rd user
////		user[2].set_user("UZ", "UZ", "UZ@", "1234", false, notify);   		   		   //3rd user
//		
//		for(int i=0; i<user.length; i++) 											   //print all user
//		{
//			user[i].print();
//			System.out.println("\n\n");
//		}
//		
//		Wine[] wine= new Wine[2];
//		for(int i=0; i<wine.length; i++) 											   //set array of wine
//		{
//			wine[i]=new Wine();
//		}
//		wine[0].set_wine("UX", 2016, "Rosso", "Piemonte", 1000, 10);				   //1st Wine
//		wine[1].set_wine("UY", 2019, "Bianco", "Toscana ", 4000, 15);				   //2nd Wine
//		
//		
//		
//		for(int i=0; i<wine.length; i++) 											   //print all wine
//		{
//			wine[i].print();
//		}
//		System.out.println("\n\n");
//		
//		int exit=1;
//		while(exit==1)
//		{
//			int operation1=0;
//			System.out.println("Benvenuto, cosa vorresti fare?:"
//					+ "\n 0 - Visualizza lista vini"
//					+ "\n 1 - Cerca vino"
//					+ "\n 2 - Iscriviti"
//					+ "\n 3 - Accedi");
//			operation1 = scan.nextInt();
//			switch(operation1)
//			{
//			
//			////////////////////////Print wine list////////////////////////
//			case 0:
//				System.out.println("Nome	Anno	Note	Origine	B. prodotte	B. disponibili");
//				for(int i=0; i<wine.length; i++)
//				{
//					wine[i].print();
//				}
//				break;
//			
//			/////////////////////////Search wine//////////////////////////
//			case 1:
//				int year=0;
//				String name="";
//				boolean flag=true;
//				System.out.println("Inserisci il nome del vino");
//				name = scan.next();
//				System.out.println("Inserisci l'anno");
//				year = scan.nextInt();
//				System.out.println("Nome	Anno	Note	Origine	B. prodotte	B. disponibili");
//				for(int i=0; i<wine.length; i++)
//				{
//					if(wine[i].getName().contentEquals(name) && wine[i].getYear()==year)
//					{
//						wine[i].print();
//						flag=false;
//						break;
//					}
//				}
//				if(flag)
//				{
//					System.out.println("vino non trovato!");
//				}
//				break;
//			
//			
//			////////////////////////Registration////////////////////////
//			case 2:
//				int last_pos=user.length;								
//				User[] tmp= new User[last_pos+1];										//tmp array
//				System.arraycopy(user, 0, tmp, 0, last_pos);							//copy array user in tmp
//				user=tmp;														
//				
//				last_pos=user.length;
//				user[last_pos-1] = new User();				
//				
//					System.out.println("inserire nome: ");								//set new user
//					name = scan.next();
//					System.out.println("inserire cognome: ");
//					String surname = scan.next();
//					System.out.println("inserire email: ");	
//					String email = scan.next();
//					System.out.println("inserire password: ");
//					String passw = scan.next();
//					user[last_pos-1].set_user(name, surname, email, passw, false, notify); //add new user
//					System.out.println("socio inserito correttamente: "
//							+ "\n"
//							+ "\n"
//							+ "-----------------------------"
//							+ "\n\n");
//				break;
//			
//			/////////////////Log-in////////////////////
//			case 3:
//				int exit1=1;
//				while(exit1!=0)
//				{
//				System.out.println("inserire email: ");						//login
//				String emailLog = scan.next();
//				System.out.println("inserire password: ");
//				String passwLog = scan.next();
//				for (int i=0; i<user.length; i++)   						
//				{
//					if((user[i].getEmail().contentEquals(emailLog)) && (user[i].getPassw().contentEquals(passwLog)))
//					{
//						if (user[i].getType())   							//if admin -> tipe==true
//						{
//							
//							int operation=0;
//							while(operation<4)
//							{
//								System.out.println("\nBenvenuto admin, che operazione vuole effettuare? "
//										+ "\n 0 - Visualizza lista vini"
//										+ "\n 1 - Visualizza notifiche ("+user[0].size()+")"
//										+ "\n 2 - Aggiungi Vino"
//										+ "\n 3 - Visualizza lista ordini"
//										+ "\n 4 - esci");
//								operation = scan.nextInt();
//								switch(operation)
//								{
//								
//								//////////////////////////Print wine list//////////////////////
//								case 0:
//									System.out.println("Nome	Anno	Note	Origine	B. prodotte	B. disponibili");
//									for(i=0; i<wine.length; i++)
//									{
//										wine[i].print();
//									}
//									break;
//								
//									
//								///////////Print notification/////////////
//								case 1:
//									System.out.println("	Nome	Anno	Quantità");
//									user[0].printNotification();
//									
//									
//									break;
//								
//									
//			  					///////////////////////////Add wine//////////////////////////
//								case 2:
//									
//									boolean flag1=false;
//									int availabe_bottle=0;
//									ArrayList<Notification> NotifyTMP=  new ArrayList<Notification>();
//									System.out.println("Inserisci nome del vino: ");
//									String wine_name = scan.next();
//									System.out.println("Inserisci l'anno del vino: ");
//									int wine_year = scan.nextInt();
//									for(int i1=0; i1<wine.length; i1++)									//if wine already exist
//									{
//										if(wine[i1].getName().contentEquals(wine_name) && wine[i1].getYear()==wine_year)
//										{ 											
//											String wine_note = wine[i1].getNote();
//											String wine_origin = wine[i1].getOrigin();
//											int bottle_made = wine[i1].getNumberBottleMade();
//											System.out.println("Vino trovato!\nQuante bottiglie vuoi aggiungere?: ");
//											int quantity=scan.nextInt();
//											availabe_bottle = wine[i1].getNumberBottle()+quantity; 
//											wine[i1].set_wine(wine_name, wine_year, wine_note, wine_origin, bottle_made, availabe_bottle);
//											System.out.println("Vino inserito correttamente!");
//											flag1=true;
//											
//											for(int i11=0; i11<user[0].size(); i11++)								//check if there a notify with the same wine that i just add
//											{
//												String name1=user[0].nameWineNotification(i11);
//												String mail=user[0].mailWineNotification(i11);
//												int bottleNotify= user[0].quantityWineNotification(i11);
//												int yearNotify= user[0].yearWineNotification(i11);
//												
//												if(wine_name.contentEquals(name1))
//												{
//														for(int i111=1; i111<user.length; i111++)
//														{
//															if(user[i111].getEmail().contentEquals(mail))
//															{
//																Notification tmp1 = new Notification();										
//																tmp1.set_Notification("Vino aggiunto", name1, wine_year, availabe_bottle);	//update the notification list of the user
//																notify.clear();
//																notify.add(tmp1);
//																user[i111].set_notification(notify);
//															}
//														}
//										
//												}
//												else
//												{
//													Notification tmp1 = new Notification();										
//													tmp1.set_Notification(mail, name1, yearNotify, bottleNotify);
//													NotifyTMP.add(tmp1);
//												}	
//											}
//											user[0].getNotification().clear();
//											user[0].set_notification(NotifyTMP);
//										}
//										
//									}
//									if (!flag1)															//if it's the first time that im using that wine
//									{
//										System.out.println("Inserisci le note: ");
//										String wine_note = scan.next();
//										System.out.println("Inserisci il vitigno: ");
//										String wine_origin = scan.next();
//										System.out.println("Inserisci la quantità di bottiglie prodotte nel vitigno: ");
//										int bottle_made = scan.nextInt();
//										System.out.println("Inserisci le bottiglie disponibili: ");
//										availabe_bottle = scan.nextInt();
//									
//										last_pos=wine.length;								
//										Wine[] tmpW= new Wine[last_pos+1];								//tmpW array
//										System.arraycopy(wine, 0, tmpW, 0, last_pos);					//copy array user in tmpW
//										wine=tmpW;	
//										wine[wine.length-1]= new Wine();
//									
//										wine[wine.length-1].set_wine(wine_name, wine_year, wine_note, wine_origin, bottle_made, availabe_bottle);
//										System.out.println("Vino inserito correttamente!");
//										break;
//									}
//									break;
//									
//									
//								
//									
//								////////////////////////Show order history//////////////////////
//								case 3:
//									System.out.println("	Nome	Anno	Quantità");
//									for (int i1=0; i1<order.size(); i1++)
//										order.get(i1).print();
//									break;
//									
//									
//								case 4:
//									operation=4;
//									exit1=0;
//									break;
//									
//								}
//								
//							}
//						}
//						else												//type == false -> user
//						{
//							int operation=0;
//							while(operation<4)
//							{
//								System.out.println("\nBenvenuto, che operazione vuole effettuare? "
//										+ "\n 0 - Visualizza lista vini"
//										+ "\n 1 - Visualizza notifiche ("+user[i].size()+")"
//										+ "\n 2 - Cerca Vino"
//										+ "\n 3 - Acquista Vino"
//										+ "\n 4 - esci");
//								operation = scan.nextInt();
//								switch(operation)
//								{
//								
//								//////////////Show wine list//////////////////
//								case 0: 
//									System.out.println("Nome	Anno	Note	Origine	B. prodotte	B. disponibili");
//									for(int k=0; k<wine.length; k++)
//									{
//										wine[k].print();
//									}
//									break;
//									
//								///////////////Show user notification/////////////////	
//								case 1:
//									System.out.println("Stato		Nome	Anno	Quantità");
//									user[i].printNotification();
//									user[i].getNotification().clear();					//Clear notification list
//									
//			
//									break;
//									
//									
//								////////////////////Search wine///////////////////////
//								case 2:
//									int wine_year=0;
//									String Wine_name="";
//									boolean flag2=true;
//									System.out.println("Inserisci il nome del vino");
//									Wine_name = scan.next();
//									System.out.println("Inserisci l'anno");
//									wine_year = scan.nextInt();
//									System.out.println("Nome	Anno	Note	Origine	B. prodotte	B. disponibili");
//									for(int i1=0; i1<wine.length; i1++)
//									{
//										if(wine[i1].getName().contentEquals(Wine_name) && wine[i1].getYear()==wine_year)
//										{
//											wine[i1].print();
//											flag2=false;
//											
//											break;
//										}
//										
//									}
//									
//									if(flag2)
//									{
//										System.out.println("vino non trovato!");
//									}
//									break;
//								
//								////////////////////Buy wine/////////////////////	
//								case 3:
//									wine_year=0;
//									Wine_name="";
//									System.out.println("Inserisci il nome del vino");						//name of the wine the user is looking for
//									Wine_name = scan.next();
//									System.out.println("Inserisci l'anno");									//year of the wine the user is looking for
//									wine_year = scan.nextInt();
//									boolean flag1=false;
//									for(int i1=0; i1<wine.length; i1++)
//									{
//										if(wine[i1].getName().contentEquals(Wine_name) && wine[i1].getYear()==wine_year)    //searching the wine in the store
//										{
//											flag1=true;
//											int quantity=0;
//											System.out.println("Inserisci la quantità: ");					//quantity needed
//											quantity = scan.nextInt();
//											System.out.println("confermare: 		(true/false)");
//											boolean validation=scan.nextBoolean();
//											if (validation)
//											{
//												if(wine[i1].getNumberBottle()-quantity>0) 					//if quantity of wine in the store greater than the request
//												{
//													
//													String wine_name = wine[i1].getName();					
//													int wine_year1 = wine[i1].getYear();
//													String noteV = wine[i1].getNote();
//													String wine_origin = wine[i1].getOrigin();
//													int bottle_made = wine[i1].getNumberBottle();
//													int available_bottle = wine[i1].getNumberBottle()-quantity; 										//update remaining number of bottle in the store
//													wine[i1].set_wine(wine_name, wine_year1, noteV, wine_origin, bottle_made, available_bottle);		//set wine
//													
//													Notification tmp1 = new Notification();																//update order list
//													tmp1.set_Notification(user[i].getEmail(), Wine_name, wine_year1, quantity);
//													order.add(tmp1);
//													System.out.println("Vino acquistato correttamente!");
//													flag1=true;
//													break;
//													
//												}
//													
//												if(wine[i1].getNumberBottle()-quantity==0)							//if quantity of wine in the store is the same of the request
//												{
//													String wine_name = wine[i1].getName();
//													int wine_year1 = wine[i1].getYear();
//													String wine_note = wine[i1].getNote();
//													String wine_origin = wine[i1].getOrigin();
//													int bottle_made = wine[i1].getNumberBottle();
//													int available_botle = wine[i1].getNumberBottle()-quantity; 											//update remaining number of bottle in the store
//													wine[i1].set_wine(wine_name, wine_year1, wine_note, wine_origin, bottle_made, available_botle);		//set wine
//													
//													Notification tmp1 = new Notification();										
//													tmp1.set_Notification("esaurito", Wine_name, wine_year, 0);
//													notify.clear();
//													notify.add(tmp1);
//													user[0].set_notification(notify);											//Update admin's notification list
//													
//													Notification tmp11 = new Notification();									//update order list
//													tmp11.set_Notification(user[i].getEmail(), Wine_name, wine_year, quantity);
//													order.add(tmp11);
//													
//													System.out.println("Vino acquistato correttamente!");
//													flag1=true;
//													break;
//													
//												}
//												
//												if(wine[i1].getNumberBottle()-quantity<0)							//if quantity of wine in the store is less than the request
//												{
//													System.out.println("La quantità di bottiglie non è disponibili non è sufficiente, \nvuole ricevere una notifica quando sarà nuovamente disponibile?				(true/false)");
//													boolean validation1 = scan.nextBoolean();						//ask if i want to be notified when the bottle will be enough again
//													if (validation1)
//													{
//														Notification tmp1 = new Notification();											//Update admin's notification list
//														tmp1.set_Notification(user[i].getEmail(), Wine_name, wine_year, quantity);
//														notify.clear();
//														notify.add(tmp1);
//														user[0].set_notification(notify);
//														break;
//													}
//													
//												}
//												
//											}
//											else
//												break;
//										}
//									}
//									if (!flag1)
//									{
//										System.out.println("vino non trovato!");
//										break;
//									}
//									
//									
//								case 4:
//									exit1=0;
//									break;
//									
//								
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//		scan.close();
//}
//}
//		
//		