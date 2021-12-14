package myproject2;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.ArrayList;




public class TestFX<Int> extends Application
{	

	
	
	public void start (final Stage primaryStage) throws IOException, SQLException
	{
		


		ArrayList<Wine> wine= new ArrayList<Wine>();
		
		for(int i=0; i<Database.elenco_vini().size(); i++)
		{
			wine.add(Database.elenco_vini().get(i));
			wine.get(i).print();
		}
		
		
      
		
		ArrayList<Notification> order=  new ArrayList<Notification>();
		
		
		ArrayList<Notification> notify=  new ArrayList<Notification>();
		String stampa="";
		for(int i=0; i<Database.elenco_notifiche().size(); i++)
		{
			notify.add(Database.elenco_notifiche().get(i));
			stampa=stampa+ notify.get(i).printString();
		}
		System.out.println("-"+stampa+"-");
		
				
				
		ArrayList<User> user= new ArrayList<User>();
		
		for(int i=0; i<Database.elenco_user().size(); i++)
			{
				user.add(Database.elenco_user().get(i));
				user.get(i).print();
			}
		
		
		
		for (int i=0; i<notify.size(); i++)
		{
			if(notify.get(i).getMessage().contentEquals("ha acquistato"))
			{
				order.add(notify.get(i));
			}
			
			if(notify.get(i).getMessage().contentEquals("ha aggiunto"))
			{
				for(int j=1; j<user.size(); j++)
				{
					if(notify.get(i).getMail().contentEquals(user.get(j).getEmail()))
					{
						user.get(j).getNotification().add(notify.get(i));
					}
				}
			}
			
			if(notify.get(i).getMessage().contentEquals("ha esaurito"))
			{
				user.get(0).getNotification().add(notify.get(i));
			}
		}
		
		notify.clear();
//		User admin = new User();																//1nd user
//		admin.set_user("Admin", "Admin", "admin@", "1234", true, notify);
//		user.add(admin);
//		
//		User Uy = new User();
//		Uy.set_user("UY", "UY", "UY@", "1234", false, notify);								//2rd user
//		user.add(Uy);
//				
//		User Uz = new User();
//		Uz.set_user("UZ", "UZ", "UZ@", "1234", false, notify);								 //3rd user
//		user.add(Uz);
			
		
	
//		Wine tmp = new Wine();																
//		tmp.set_wine("UX", 2016, "Rosso", "Piemonte", 1000, 10);
//		wine.add(tmp);				  												 //1st Wine
//		
//		Wine UY = new Wine();
//		UY.set_wine("UY", 2019, "Bianco", "Toscana ", 4000, 15);
//		wine.add(UY);															   //2nd Wine
//		
		
		System.out.println("\n\n");
		
		
		
		
		
		Stage NoUserStage = new Stage();
		BorderPane borderNoUser = new BorderPane();
		
		
		
		HBox hboxTop = new HBox();
		hboxTop.setPadding(new Insets(20, 12, 15, 12));
	    hboxTop.setSpacing(10);
	    hboxTop.setAlignment(Pos.CENTER);
	    hboxTop.setStyle("-fx-background-color: #336699;");
	    borderNoUser.setTop(hboxTop);
	    Button buttonWineList = new Button("Lista Vini");
	    buttonWineList.setPrefSize(100, 20);
	    Button buttonSearchWine = new Button("Cerca vino");
	    buttonSearchWine.setPrefSize(100, 20);
	    Button buttonSigIn = new Button("Iscriviti");
	    buttonSigIn.setPrefSize(100, 20);
	    Button buttonLogIn = new Button("Accedi");
	    buttonLogIn.setPrefSize(100, 20);
	    hboxTop.getChildren().addAll(buttonWineList, buttonSearchWine, buttonSigIn, buttonLogIn);
	    
	    
	    
	    /******************LISTA VINI*******************/
	    
	    buttonWineList.setOnAction((e1) ->{
    		
	    	GridPane gridTable = new GridPane();
    		final Text WineList = new Text();
    		gridTable.add(WineList, 1, 6);
    		final Text table = new Text();
    		gridTable.add(table, 1, 6);
    	 	HBox hboxCentre = new HBox(gridTable);
    	 	gridTable.setHgap(10);
    	    gridTable.setVgap(10);
    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
    	 	WineList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    		
            String wineList="";
    	 	for (int i1=0; i1<wine.size(); i1++)	{	    	    		    		    	            
            wineList=wineList+wine.get(i1).printString();
    	 	}
    	 	System.out.println("-"+wineList+"-");
            WineList.setText(wineList);
            
            hboxCentre.setPadding(new Insets(15, 12, 15, 12));
    	    hboxCentre.setSpacing(10);
    	   
    	  
    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"), 
    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    	    
    	    hboxCentre.setBackground(new Background(image));
    	    borderNoUser.setCenter(hboxCentre);
    	    hboxCentre.setAlignment(Pos.CENTER);
    	
	    });
	    
	    
	    
	    /******************CERCA VINO*******************/
	    
	    buttonSearchWine.setOnAction((e1) ->{
	    	
	    	GridPane gridTable = new GridPane();
    		final Text WineList = new Text();
    		gridTable.add(WineList, 1, 6);
    		final Text table = new Text();
    		gridTable.add(table, 1, 6);
    	 	HBox hboxCentre = new HBox(gridTable);
    	 	gridTable.setHgap(10);
    	    gridTable.setVgap(10);
    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
    	    WineList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

    	    Text scenetitle = new Text("Inserisci il nome e l'anno del vino che vuoi cercare:");
    	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    	    gridTable.add(scenetitle, 0, 0, 2, 1);

    	    Label WineName = new Label("Nome:");
    	    gridTable.add(WineName, 0, 1);

    	    TextField wNBox = new TextField();
    	    gridTable.add(wNBox, 1, 1);
    	    
    	    
    	    Label WineYear = new Label("Anno:");
    	    gridTable.add(WineYear, 0, 2);

    	    TextField wYBox = new TextField();
    	    gridTable.add(wYBox, 1, 2);

    	    
    	    final Text actiontarget = new Text();
    	    gridTable.add(actiontarget, 1, 6);

    	    
    	    	   
    	    

    	    Button btn   = new Button("Cerca");
    	    HBox   hbBtn = new HBox(10);
    	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    	    hbBtn.getChildren().add(btn);
    	    gridTable.add(hbBtn, 1, 4);
    	    
    	    
    	    btn.setOnAction((e) -> {
    	    	Boolean validation=false;
    	    	for(int i=0; i<wine.size(); i++)
    	    	{
    	    		if(wNBox.getText().contentEquals(wine.get(i).getName()) &&
    	    		   Integer.parseInt((wYBox.getText()))==wine.get(i).getYear()) 
    	    		{
    	    			String Winelist="\n"+(wine.get(i).getName() +" "+ wine.get(i).getNote()+" "+wine.get(i).getNumberBottle()+" "
    	            			+ ""+wine.get(i).getNumberBottleMade()+" "+wine.get(i).getOrigin()+" "+wine.get(i).getYear()+"\n");
    	 	            WineList.setText(Winelist);
    	 	            validation=true;
    	    		}
    	    		
    	    		
    	    	}
    	    	if(validation==false)
    	    	{
    	    		WineList.setText("Vino non trovato");    	    		
    	    	}
    	    	
    	    });
    	    
    	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
    	    hboxCentre.setSpacing(10);
    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    	    
    	    hboxCentre.setBackground(new Background(image));
    	    borderNoUser.setCenter(hboxCentre);
    	    hboxCentre.setAlignment(Pos.CENTER);
	    	
	    });
	    
	    
	    
	    /******************REGISTRAZIONE*******************/
	    
	    buttonSigIn.setOnAction((e1) ->{
    		
    		GridPane gridTable = new GridPane();
    		final Text WineList = new Text();
    		gridTable.add(WineList, 1, 6);
    		final Text table = new Text();
    		gridTable.add(table, 1, 6);
    	 	HBox hboxCentre = new HBox(gridTable);
    	 	
    	 	gridTable.setHgap(10);
    	    gridTable.setVgap(10);
    	    gridTable.setPadding(new Insets(25, 25, 25, 25));


    	    Text scenetitle = new Text("Registrazione:");
    	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    	    gridTable.add(scenetitle, 0, 0, 2, 1);

    	    Label Name = new Label("Nome:");
    	    gridTable.add(Name, 0, 1);

    	    TextField uName = new TextField();
    	    gridTable.add(uName, 1, 1);
    	    
    	    
    	    
    	    Label Surname = new Label("Cognome:");
    	    gridTable.add(Surname, 0, 2);

    	    TextField uSurname = new TextField();
    	    gridTable.add(uSurname, 1, 2);
    	    
    	    
    	    
    	    Label Email = new Label("Email:");
    	    gridTable.add(Email, 0, 3);

    	    TextField uEmail = new TextField();
    	    gridTable.add(uEmail, 1, 3);
    	    
    	    
    	    
    	    Label Passw = new Label("Password:");
    	    gridTable.add(Passw, 0, 4);

    	    TextField uPass = new TextField();
    	    gridTable.add(uPass, 1, 4);
    	    
    	    
    	    final Text actiontarget = new Text();
    	    gridTable.add(actiontarget, 1, 6);
    	    
    	    Button btn   = new Button("Invia");
    	    HBox   hbBtn = new HBox(10);
    	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    	    hbBtn.getChildren().add(btn);
    	    gridTable.add(hbBtn, 1, 5);
    	    
    	    
    	    btn.setOnAction((e) -> {
    	    	
    	    	boolean validation=false;
    	    	
    	    	if (uName.getText().contentEquals("") || uSurname.getText().contentEquals("") || uEmail.getText().contentEquals("") || uPass.getText().contentEquals("")) 
    	    	{
					validation=true;
					WineList.setText("Compilare tutti i campi");
					validation=true;
				}
    	    	
    	    	for(int i=0; i<user.size(); i++)
    	    	{
    	    		if(uEmail.getText().contentEquals(user.get(i).getEmail())) 
    	    		{
    	    			WineList.setText("Utente già registrato");
    	    			validation=true;
    	    		}
    	    	}
    	    	    	    	
    	    	if(validation==false)
	    		{
    	    		User Ux = new User();																//add new user
    	    		Ux.set_user(uName.getText(), uSurname.getText(), uEmail.getText(), uPass.getText(), false);
    	    		user.add(Ux);
    	    		validation=true;  		
					WineList.setText("Utente inserito correttamente");
					Database.nuovoUser(Ux);   //aggiorno database utenti
	    		}
					
    	    });

    	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
    	    hboxCentre.setSpacing(10);
    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    	    
    	    hboxCentre.setBackground(new Background(image));
    	    borderNoUser.setCenter(hboxCentre);
    	    hboxCentre.setAlignment(Pos.CENTER);
    	
	    });
	    
	    
	    
	    
	    
	    /******************LOGIN*******************/
	    
	    buttonLogIn.setOnAction(new EventHandler<ActionEvent>() {
	    	
	    	
            public void handle(ActionEvent event) {
	    		
	    		Stage secondaryStage = new Stage();
	    		secondaryStage.setTitle("Login");
	    	    GridPane grid = new GridPane();
	    	    grid.setAlignment(Pos.CENTER);
	    	    grid.setHgap(10);
	    	    grid.setVgap(10);
	    	    grid.setPadding(new Insets(25, 25, 25, 25));


	    	    Text scenetitle = new Text("Welcome");
	    	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    	    grid.add(scenetitle, 0, 0, 2, 1);

	    	    Label userName = new Label("Mail:");
	    	    grid.add(userName, 0, 1);

	    	    TextField uNBox = new TextField();
	    	    grid.add(uNBox, 1, 1);

	    	    Label pw = new Label("Password:");
	    	    grid.add(pw, 0, 2);

	    	    PasswordField pwBox = new PasswordField();
	    	    grid.add(pwBox, 1, 2);

	    	    final Text actiontarget = new Text();
	    	    grid.add(actiontarget, 1, 6);

	    	    
	    	    Button btnBack   = new Button("Indietro");
	    	    HBox   hbBtnBack = new HBox(10);
	    	    hbBtnBack.setAlignment(Pos.BOTTOM_RIGHT);
	    	    hbBtnBack.getChildren().add(btnBack);
	    	    grid.add(hbBtnBack, 1, 5);

	    	    btnBack.setOnAction((e) -> {
		    	      NoUserStage.show();
		    	      secondaryStage.hide();
		    	    });
	    	    

	    	    Button btn   = new Button("Sign in");
	    	    HBox   hbBtn = new HBox(10);
	    	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    	    hbBtn.getChildren().add(btn);
	    	    grid.add(hbBtn, 1, 4);

	    	    btn.setOnAction((e) -> {
	    	    	
	    	    	for(int i=0; i<user.size(); i++)
	    	    	{
	    	    		if(user.get(i).getPassw().contentEquals(pwBox.getText()) &&		//LOGIN AVVENUTA CON SUCCESSO
	    	    				user.get(i).getEmail().contentEquals(uNBox.getText())) 
	    	    		{
		    	      		secondaryStage.hide();								
		    	      		if (user.get(i).getType())							//AMMINISTATORE
		    	      		{
		    	      			NoUserStage.hide();
		    		    		Stage adminStage = new Stage();
		    		    		BorderPane borderAdmin = new BorderPane();
		    		    		
		    		    		
		    		    		HBox hboxTop = new HBox();
		    		    		hboxTop.setPadding(new Insets(20, 12, 15, 12));
		    		    	    hboxTop.setSpacing(10);
		    		    	    hboxTop.setAlignment(Pos.CENTER);
		    		    	    hboxTop.setStyle("-fx-background-color: #336699;");
		    		    	    
		    		    		borderAdmin.setTop(hboxTop);
		    		    		Button buttonWineList = new Button("Lista Vini");
		    		    	    buttonWineList.setPrefSize(100, 20);
		    		    	    Button buttonViewNotify = new Button("Notifiche");
		    		    	    buttonViewNotify.setPrefSize(100, 20);
		    		    	    Button buttonAddWine = new Button("Aggiungi vino");
		    		    	    buttonAddWine.setPrefSize(100, 20);
		    		    	    Button buttonOrderList = new Button("Lista ordini");
		    		    	    buttonOrderList.setPrefSize(100, 20);
		    		    	    Button buttonBack = new Button("Indietro");
		    		    	    buttonBack.setPrefSize(100, 20);
		    		    	    hboxTop.getChildren().addAll(buttonWineList, buttonViewNotify, buttonAddWine,
		    		    	    						  buttonOrderList, buttonBack);
		    		    	    
		    		    	    
		    		    	    /*****************AGGIORNO LISTA NOTIFICHE*****************/
		    		    	    for (int i1=0; i1<notify.size(); i1++)
		    		    		{
		    		    			if(notify.get(i1).getMessage().contentEquals("ha acquistato"))
		    		    			{
		    		    				order.add(notify.get(i1));
		    		    			}
		    		    			
		    		    			if(notify.get(i1).getMessage().contentEquals("ha aggiunto"))
		    		    			{
		    		    				for(int j=1; j<user.size(); j++)
		    		    				{
		    		    					if(notify.get(i1).getMail().contentEquals(user.get(j).getEmail()))
		    		    					{
		    		    						user.get(j).getNotification().add(notify.get(i1));
		    		    					}
		    		    				}
		    		    			}
		    		    			
		    		    			if(notify.get(i1).getMessage().contentEquals("ha esaurito") || notify.get(i1).getMessage().contentEquals("q insufficente"))
		    		    			{
		    		    				user.get(0).getNotification().add(notify.get(i1));
		    		    			}
		    		    		}
		    		    	    
		    		    	    
		    		    	    /*****************LISTA VINI*****************/
		    		    	    buttonWineList.setOnAction((e1) ->{
		    		    	    		
		    		    	    	GridPane gridTable = new GridPane();
		    		        		final Text WineList = new Text();
		    		        		gridTable.add(WineList, 1, 6);
		    		        		final Text table = new Text();
		    		        		gridTable.add(table, 1, 6);
		    		        		gridTable.setHgap(10);
			    		    	    gridTable.setVgap(10);
			    		    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
		    		        	 	HBox hboxCentre = new HBox(gridTable);
		    		        	 	WineList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    		        	 	
		    		        		
		    		                String wineList="";
		    		        	 	for (int i1=0; i1<wine.size(); i1++)	{	    	    		    		    	            
		    		                wineList=wineList+wine.get(i1).printString();
		    		        	 	}
		    		                
		    		                WineList.setText(wineList);
		    		        	

		    		        	

		    		        	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
		    		        	    hboxCentre.setSpacing(10);
		    		        	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
		    		        	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		    		        	    
		    		        	    hboxCentre.setBackground(new Background(image));
		    		        	    borderAdmin.setCenter(hboxCentre);
		    		        	    hboxCentre.setAlignment(Pos.CENTER);
		    		    	    	
		    		    	    });
		    		    	    
		    		    	    
		    		    	    /*****************VISUALIZZA NOTIFICHE*****************/
		    		    	    
		    		    	    buttonViewNotify.setOnAction((e1) ->{
		    		    	    	
		    		    	    	GridPane gridTable = new GridPane();
	    		    	    		final Text NotificationList = new Text();
	    		    	    		gridTable.add(NotificationList, 1, 6);
	    		    	    		final Text table = new Text();
	    		    	    		gridTable.add(table, 1, 6);
	    		    	    		gridTable.setHgap(10);
			    		    	    gridTable.setVgap(10);
			    		    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
	    		    	    	 	HBox hboxCentre = new HBox(gridTable);
	    		    	    	 	
	    		    	    	 	NotificationList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    		    	              		    	    		    		    	            
	    		    	            NotificationList.setText(user.get(0).stampaNotification());
	    		    	           
    		    	    
			    		    	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
			    		    	    hboxCentre.setSpacing(10);
			    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
			    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			    		    	    
			    		    	    hboxCentre.setBackground(new Background(image));
			    		    	    borderAdmin.setCenter(hboxCentre);
			    		    	    hboxCentre.setAlignment(Pos.CENTER);
		    		    	    	
		    		    	    });
		    		    	    
		    		    	    
		    		    	    
		    		    	    
		    		    	    /*****************AGGIUNGI VINO*****************/
		    		    	    
		    		    	    buttonAddWine.setOnAction((e1) ->{
		    		        		
		    		        		GridPane gridTable = new GridPane();
		    		        		final Text WineList = new Text();
		    		        		gridTable.add(WineList, 1, 6);
		    		        		final Text table = new Text();
		    		        		gridTable.add(table, 1, 6);
		    		        		gridTable.setHgap(10);
			    		    	    gridTable.setVgap(10);
			    		    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
		    		        	 	HBox hboxCentre = new HBox(gridTable);
		    		        	 	WineList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    		        	 	
		    		        	 	gridTable.setHgap(10);
		    		        	    gridTable.setVgap(10);
		    		        	    gridTable.setPadding(new Insets(25, 25, 25, 25));


		    		        	    Text scenetitle1 = new Text("Inserisci nuovo vino:");
		    		        	    scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    		        	    grid.add(scenetitle1, 0, 0, 2, 1);

		    		        	    Label Name = new Label("Nome:");
		    		        	    gridTable.add(Name, 0, 1);
		    		        	    TextField vName = new TextField();
		    		        	    gridTable.add(vName, 1, 1);
		    		        	    //String SvName= vName.getText();
		    		        	    
		    		        	    
		    		        	    Label Year = new Label("Anno:");
		    		        	    gridTable.add(Year, 0, 2);
		    		        	    TextField vYear = new TextField();
		    		        	    gridTable.add(vYear, 1, 2);
		    		        	    
		    		        	    
		    		        	    final Text actiontarget1 = new Text();
		    		        	    gridTable.add(actiontarget1, 1, 2);
		    		        	    
		    		        	    Button btn1   = new Button("submit");
		    		        	    HBox   hbBtn1 = new HBox(10);
		    		        	    hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
		    		        	    hbBtn1.getChildren().add(btn1);
		    		        	    gridTable.add(hbBtn1, 1, 3);
		    		        	    
		    		        	    
		    		        	    btn1.setOnAction((e2) -> {
		    		        	    				    		        	    
			    		        		
										boolean flag=false;
										
										GridPane gridTable1 = new GridPane();
										final Text Message = new Text();
										gridTable.add(Message, 1, 6);
										HBox hboxCentre1 = new HBox(gridTable1);
							
										gridTable1.setHgap(10);
			    		        	    gridTable1.setVgap(10);
			    		        	    gridTable1.setPadding(new Insets(25, 25, 25, 25));
			    		        			    		        	    
			    		        	    
		    		        	    	for(int i1=0; i1<wine.size(); i1++)									//if wine already exist
										{
		    		        	    		
											if(vName.getText().contentEquals(wine.get(i1).getName()) &&
					    		    	    		   Integer.parseInt((vYear.getText()))==wine.get(i1).getYear())
											{
												
												flag=true;
														    		        	 
					    		        	 	
												Message.setText("Vino trovato!\nQuante bottiglie vuoi aggiungere?: ");
												
												Label Quantity = new Label("Quantità:");
												gridTable1.add(Quantity, 0, 1);

					    		        	    TextField vQuantity = new TextField();
					    		        	    gridTable1.add(vQuantity, 1, 1);
					    		        	    
					    		        	    final Text actiontarget11 = new Text();
					    		        	    gridTable1.add(actiontarget11, 1, 2);
					    		        	    
					    		        	    
					    		        	    
					    		        	    System.out.println("-"+vQuantity.getText()+"-"+wine.get(i1).getNumberBottle()+"-");
					    		        	    
					    		        	    
					    		        	    
					    		        	    String wine_note = wine.get(i1).getNote();
												String wine_origin = wine.get(i1).getOrigin();
												int bottle_made = wine.get(i1).getNumberBottleMade();
 
												int k=i1;
												ArrayList<Notification> NotifyTMP=  new ArrayList<Notification>();
												
												Button quantity   = new Button("Inserisci");
					    		        	    HBox   hbBtn11 = new HBox(10);
					    		        	    hbBtn11.setAlignment(Pos.BOTTOM_RIGHT);
					    		        	    hbBtn11.getChildren().add(quantity);
					    		        	    gridTable1.add(hbBtn11, 1, 5);
												
												quantity.setOnAction((e21) -> {
					    		        	    	
													GridPane gridTable2 = new GridPane();
													final Text Message1 = new Text();
													gridTable2.add(Message1, 1, 6);
													HBox hboxCentre2 = new HBox(gridTable2);
													Message1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
													
													gridTable2.setHgap(10);
						    		        	    gridTable2.setVgap(10);
						    		        	    gridTable2.setPadding(new Insets(25, 25, 25, 25));
						    		        	    
						    		        	    int available_bottle = wine.get(k).getNumberBottle()+Integer.parseInt(vQuantity.getText());
						    		        	    
						    		        	    wine.get(k).set_wine(vName.getText(), Integer.parseInt(vYear.getText()), wine_note, 
						    		        	    					 wine_origin, bottle_made, available_bottle);     //aggiorno lista di vini
					    		        	   	    
					    		        	   	    
					    		        	   	    
					    		        	   	    Database.modificaVino(wine.get(k));			//aggiorno database
					    		        	   	    
					    		        	   	    Message1.setText("Vino aggiunto");
					    		        	   	    
					    		        	   	    
					    		        	   	 for(int i11=0; i11<user.get(0).size(); i11++)								//check if there a notify with the same wine that i just add
													{
														String name1=user.get(0).nameWineNotification(i11);
														String mail=user.get(0).mailWineNotification(i11);
														String message=user.get(0).messageWineNotification(i11);
														int bottleNotify= user.get(0).quantityWineNotification(i11);
														int yearNotify= user.get(0).yearWineNotification(i11);
														
														System.out.println("-"+vName.getText()+"-"+name1+"-");
														
														if(vName.getText().contentEquals(name1))
														{
																for(int i111=1; i111<user.size(); i111++)
																{
																	if(user.get(i111).getEmail().contentEquals(mail))
																	{
																		//int available_bottle = wine.get(k).getNumberBottle()+Integer.parseInt(vQuantity.getText());
																		Notification tmp1 = new Notification();		
																		System.out.println("-"+name1+"-"+Integer.parseInt(vYear.getText())+"-"+wine.get(k).getNumberBottle()+"-");
																		tmp1.set_Notification(mail, "Vino aggiunto", name1, Integer.parseInt(vYear.getText()), 
																				wine.get(k).getNumberBottle());	//update the notification list of the user
																		notify.clear();
																		notify.add(tmp1);
																		user.get(i111).set_notification(notify);
																		Database.cancellaNotifica(tmp1);
																		Database.aggiungiNotifica(tmp1);  //aggiorno database user
																	}
																}
												
														}
														else
														{
															Notification tmp1 = new Notification();										
															tmp1.set_Notification(mail, message, name1, yearNotify, bottleNotify);
															NotifyTMP.add(tmp1);
														}	
													}
						    		        	    user.get(0).getNotification().clear();
						    		        	    user.get(0).set_notification(NotifyTMP);

					    		        	   	    
					    		        	   	    
					    		        	   	    
					    		        	   	    
					    		        	   	    hboxCentre2.setPadding(new Insets(15, 12, 15, 12));
							    		    	    hboxCentre2.setSpacing(10);
							    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
							    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"), 
							    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
							    		    	    
							    		    	    hboxCentre2.setBackground(new Background(image));
							    		    	    borderAdmin.setCenter(hboxCentre2);
							    		    	    hboxCentre2.setAlignment(Pos.CENTER);
					    		        	    });
												
																	    		        	    
					    		        	    
					    		        	    											
					    		        	    }
											hboxCentre1.setPadding(new Insets(15, 12, 15, 12));
					    		    	    hboxCentre1.setSpacing(10);
					    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
					    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"), 
					    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
					    		    	    
					    		    	    hboxCentre1.setBackground(new Background(image));
					    		    	    borderAdmin.setCenter(hboxCentre1);
					    		    	    hboxCentre1.setAlignment(Pos.CENTER); 
											
										}

		    		        	    
		    		        	    if(flag==false)							//VINO NON CONTENUTO IN MEMORIA
		    		        	    {
		    		        	    	
			    		        	 	
		    		        	    	
		    		        	    	Label NumberBottle = new Label("Numero di bottiglie:");
			    		        	    gridTable1.add(NumberBottle, 0, 1);

			    		        	    TextField vNumberBottle = new TextField();
			    		        	    gridTable1.add(vNumberBottle, 1, 1);
		    		        	    	
		    		        	    	
			    		        	    Label Note = new Label("Note:");
			    		        	    gridTable1.add(Note, 0, 2);

			    		        	    TextField vNote = new TextField();
			    		        	    gridTable1.add(vNote, 1, 2);
			    		        	    
			    		        	    
			    		        	    
			    		        	    Label Origin = new Label("Origine:");
			    		        	    gridTable1.add(Origin, 0, 3);

			    		        	    TextField vOrigin = new TextField();
			    		        	    gridTable1.add(vOrigin, 1, 3);
			    		        	    
			    		        	    
			    		        	    
			    		        	    Label BottleMade = new Label("Bottiglie prodotte:");
			    		        	    gridTable1.add(BottleMade, 0, 4);

			    		        	    TextField vBottleMade = new TextField();
			    		        	    gridTable1.add(vBottleMade, 1, 4);
			    		        	    
			    		        	    
			    		        	    final Text actiontarget11 = new Text();
			    		        	    gridTable1.add(actiontarget11, 1, 10);
			    		        	    
			    		        	    Button btn11   = new Button("Inserisci");
			    		        	    HBox   hbBtn11 = new HBox(10);
			    		        	    hbBtn11.setAlignment(Pos.BOTTOM_RIGHT);
			    		        	    hbBtn11.getChildren().add(btn11);
			    		        	    gridTable1.add(hbBtn11, 1, 11);
			    		        	    
			    		        	   
										btn11.setOnAction((e21) -> { 
											
											GridPane gridTable2 = new GridPane();
											final Text Message1 = new Text();
											gridTable2.add(Message1, 1, 6);
											HBox hboxCentre2 = new HBox(gridTable2);
											Message1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
											
											gridTable2.setHgap(10);
				    		        	    gridTable2.setVgap(10);
				    		        	    gridTable2.setPadding(new Insets(25, 25, 25, 25));
				    		        	    
				    		        	    Wine newWine = new Wine();																//update order list
											System.out.println("-"+vName.getText()+"-"+vYear.getText()+"-"+vNote.getText()+"-"+vOrigin.getText()+"-"+Integer.parseInt(vBottleMade.getText())+5+"-"+Integer.parseInt(vNumberBottle.getText())+"-");
											
											newWine.set_wine(vName.getText(), Integer.parseInt(vYear.getText()), vNote.getText(), 
															 vOrigin.getText(), Integer.parseInt(vBottleMade.getText()), 
															 Integer.parseInt(vNumberBottle.getText()));
											
											wine.add(newWine);                    //aggiorno lista di vini
			    		        	   	    
											Database.nuovoVino(newWine);          //aggiorno database vini
											
											
											Message1.setText("Vino aggiunto");
											
			    		        	    
			    		        	   	    hboxCentre2.setPadding(new Insets(15, 12, 15, 12));
					    		    	    hboxCentre2.setSpacing(10);
					    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
					    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
					    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
					    		    	    
					    		    	    hboxCentre2.setBackground(new Background(image));
					    		    	    borderAdmin.setCenter(hboxCentre2);
					    		    	    hboxCentre2.setAlignment(Pos.CENTER);
					
			    		        	    });
										
										hboxCentre1.setPadding(new Insets(15, 12, 15, 12));
				    		    	    hboxCentre1.setSpacing(10);
				    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
				    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
				    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
				    		    	    
				    		    	    hboxCentre1.setBackground(new Background(image));
				    		    	    borderAdmin.setCenter(hboxCentre1);
				    		    	    hboxCentre1.setAlignment(Pos.CENTER); 
										
		    		        	    }
		    		        	    		        	
		    		    	    });
		    		        	    
		    		        	    
		    		        	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
			    		    	    hboxCentre.setSpacing(10);
			    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
			    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
			    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			    		    	    
			    		    	    hboxCentre.setBackground(new Background(image));
			    		    	    borderAdmin.setCenter(hboxCentre);
			    		    	    hboxCentre.setAlignment(Pos.CENTER);
		    		    	    });
		    		    	    
		    		    	    
		    		    	    
		    		    	    
		    		    	    
		    		    	    /*****************LISTA DI TUTTI GLI ORDINI*****************/
		    		    	        
	    		    	    	buttonOrderList.setOnAction((e1) ->{
	    		    	    		
	    		    	    		GridPane gridTable = new GridPane();
	    		    	    		final Text OrderList = new Text();
	    		    	    		gridTable.add(OrderList, 1, 6);
	    		    	    		final Text table = new Text();
	    		    	    		gridTable.add(table, 1, 6);
	    		    	    		gridTable.setHgap(10);
			    		    	    gridTable.setVgap(10);
			    		    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
	    		    	    		OrderList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    		    	    		
	    		    	    	 	HBox hboxCentre = new HBox(gridTable);
	    		    	    	 	String orderlist="";
	    		    	    	 	for (int i1=0; i1<order.size(); i1++)	{	    	    		    		    	            
	    		    	            orderlist=orderlist+order.get(i1).printString();
	    		    	    	 	}
	    		    	    	 	
	    		    	    	 	OrderList.setText(orderlist);
	    		    	    	 	
    		    	    
			    		    	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
			    		    	    hboxCentre.setSpacing(10);
			    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
			    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
			    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			    		    	    
			    		    	    hboxCentre.setBackground(new Background(image));
			    		    	    borderAdmin.setCenter(hboxCentre);
			    		    	    hboxCentre.setAlignment(Pos.CENTER);
	    		    	    	    	
	    		    	    			    		    	        		    	   	
		    		    	    });
		    		    	    
		    		    	    
	    		    	    	/*****************LOGOUT*****************/
		    		    	    
	    		    	    	buttonBack.setOnAction((e1) ->{
	    		    	    		
	    		    	    		NoUserStage.show();
	    				    	    secondaryStage.hide();
	    				    	    adminStage.hide();
	    		    	    	});
	    		    	    	
	    		    	    	
		    		    	    Scene scene = new Scene(borderAdmin, 740, 550);
		    		    		adminStage.setScene(scene);
		    		    		adminStage.setTitle("Wine Shop");
		    		    		adminStage.show();
		    		    	   
		    	      		}
		    	      		
		    	      		
		    	      		if(!user.get(i).getType())							//USER
		    	      		{
		    	      			NoUserStage.hide();
			    		    	Stage UserStage = new Stage();
			    		    	BorderPane borderUser = new BorderPane();
			    		    	
			    		    		
			    		    	HBox hboxTop = new HBox();
			    		    	hboxTop.setPadding(new Insets(20, 12, 15, 12));
			    		    	hboxTop.setSpacing(10);
			    		    	hboxTop.setAlignment(Pos.CENTER);
			    		    	hboxTop.setStyle("-fx-background-color: #336699;");
			    		    	    
			    		    	borderUser.setTop(hboxTop);
			    		    	
			    		    	Button buttonWineList = new Button("Lista Vini");
			    		    	buttonWineList.setPrefSize(100, 20);
			    		    	Button buttonViewNotify = new Button("Notifiche");
			    		    	buttonViewNotify.setPrefSize(100, 20);
			    		    	Button buttonSearchWine = new Button("Cerca vino");
			    		    	buttonSearchWine.setPrefSize(100, 20);
			    		    	Button buttonBuyWine = new Button("Acquista vino");
			    		    	buttonBuyWine.setPrefSize(100, 20);
			    		    	
			    		    	Button buttonBack = new Button("Indietro");
			    		    	buttonBack.setPrefSize(100, 20);
			    		    	hboxTop.getChildren().addAll(buttonWineList, buttonViewNotify, buttonSearchWine, buttonBuyWine, buttonBack);
			    		    	
			    		    	int k=i;       //posizione utente nella lista di utenti
			    		    	
			    		    	
			    		    	
			    		    	/*****************AGGIORNO LISTA NOTIFICHE*****************/
		    		    	    for (int i1=0; i1<notify.size(); i1++)
		    		    		{
		    		    					    		    			
		    		    			if(notify.get(i1).getMessage().contentEquals("ha aggiunto"))
		    		    			{
		    		    					if(notify.get(i1).getMail().contentEquals(user.get(i).getEmail()))
		    		    					{
		    		    						user.get(i).getNotification().add(notify.get(i1));
		    		    					}
		    		    			}
		    		    			
		    		    		}
		    		    	    
			    		    	/*****************LISTA DEI VINI*****************/
			    		    	
			    		    	buttonWineList.setOnAction((e1) ->{
			    		    		
			    		    		GridPane gridTable = new GridPane();
			    		    		final Text WineList = new Text();
			    		    		gridTable.add(WineList, 1, 6);
			    		    		final Text table = new Text();
			    		    		gridTable.add(table, 1, 6);
			    		    		gridTable.setHgap(10);
			    		    	    gridTable.setVgap(10);
			    		    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
			    		    	 	HBox hboxCentre = new HBox(gridTable);
			    		    	 	WineList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			    		    		
			    		            String wineList="";
			    		    	 	for (int i1=0; i1<wine.size(); i1++)	{	    	    		    		    	            
			    		            wineList=wineList+wine.get(i1).printString();
			    		    	 	}
			    		            
			    		            WineList.setText(wineList);
			    		    	

			    		    	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
			    		    	    hboxCentre.setSpacing(10);
			    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
			    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
			    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			    		    	    
			    		    	    hboxCentre.setBackground(new Background(image));
			    		    	    borderUser.setCenter(hboxCentre);
			    		    	    hboxCentre.setAlignment(Pos.CENTER);
			    		    	
			    			    });
			    		    	
			    		    	
			    		    	/*****************VISUALIZZA NOTIFICHE*****************/
			    		    	
			    		    	buttonViewNotify.setOnAction((e1) ->{
		    		    	    	
		    		    	    	GridPane gridTable = new GridPane();
	    		    	    		final Text NotificationList = new Text();
	    		    	    		gridTable.add(NotificationList, 1, 6);
	    		    	    		final Text table = new Text();
	    		    	    		gridTable.add(table, 1, 6);
	    		    	    	 	HBox hboxCentre = new HBox(gridTable);
	    		    	    	 	gridTable.setHgap(10);
			    		    	    gridTable.setVgap(10);
			    		    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
			    		    	    
	    		    	    	 	NotificationList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    		    	              		    	    		    		    	            
	    		    	            NotificationList.setText(user.get(k).stampaNotification());
	    		    	           
    		    	    
			    		    	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
			    		    	    hboxCentre.setSpacing(10);
			    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
			    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
			    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			    		    	    
			    		    	    hboxCentre.setBackground(new Background(image));
			    		    	    borderUser.setCenter(hboxCentre);
			    		    	    hboxCentre.setAlignment(Pos.CENTER);
		    		    	    	
		    		    	    });
			    		    	
			    		    	
			    		    	
			    		    	
			    		    	/*****************CERCA VINO*****************/
			    		    	
			    		    	buttonSearchWine.setOnAction((e1) ->{
			    			    	
			    			    	GridPane gridTable = new GridPane();
			    		    		final Text WineList = new Text();
			    		    		gridTable.add(WineList, 1, 6);
			    		    		final Text table = new Text();
			    		    		gridTable.add(table, 1, 6);
			    		    	 	HBox hboxCentre = new HBox(gridTable);
			    		    	 	gridTable.setHgap(10);
			    		    	    gridTable.setVgap(10);
			    		    	    gridTable.setPadding(new Insets(25, 25, 25, 25));
			    		    	    WineList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			    		    	    

			    		    	    Text scenetitle1 = new Text("Inserisci il nome e l'anno del vino che vuoi cercare:");
			    		    	    scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			    		    	    gridTable.add(scenetitle1, 0, 0, 2, 1);

			    		    	    Label WineName = new Label("Nome:");
			    		    	    gridTable.add(WineName, 0, 1);

			    		    	    TextField wNBox = new TextField();
			    		    	    gridTable.add(wNBox, 1, 1);
			    		    	    
			    		    	    
			    		    	    Label WineYear = new Label("Anno:");
			    		    	    gridTable.add(WineYear, 0, 2);

			    		    	    TextField wYBox = new TextField();
			    		    	    gridTable.add(wYBox, 1, 2);

			    		    	    
			    		    	    final Text actiontarget1 = new Text();
			    		    	    gridTable.add(actiontarget1, 1, 6);

			    		    	    
			    		    	    	   
			    		    	    

			    		    	    Button btn1   = new Button("Cerca");
			    		    	    HBox   hbBtn1 = new HBox(10);
			    		    	    hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
			    		    	    hbBtn1.getChildren().add(btn1);
			    		    	    gridTable.add(hbBtn1, 1, 4);
			    		    	    
			    		    	    
			    		    	    btn1.setOnAction((e11) -> {
			    		    	    	Boolean validation=false;
			    		    	    	for(int i1=0; i1<wine.size(); i1++)
			    		    	    	{
			    		    	    		if(wNBox.getText().contentEquals(wine.get(i1).getName()) &&
			    		    	    		   Integer.parseInt((wYBox.getText()))==wine.get(i1).getYear()) 
			    		    	    		{
			    		    	    			String Winelist="\n"+(wine.get(i1).getName() +" "+ wine.get(i1).getNote()+" "+wine.get(i1).getNumberBottle()+" "
			    		    	            			+ ""+wine.get(i1).getNumberBottleMade()+" "+wine.get(i1).getOrigin()+" "+wine.get(i1).getYear()+"\n");
			    		    	 	            WineList.setText(Winelist);
			    		    	 	            validation=true;
			    		    	    		}
			    		    	    		
			    		    	    		
			    		    	    	}
			    		    	    	if(validation==false)
			    		    	    	{
			    		    	    		WineList.setText("Vino non trovato");    	    		
			    		    	    	}
			    		    	    	
			    		    	    });
			    		    	    
			    		    	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
			    		    	    hboxCentre.setSpacing(10);
			    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
			    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
			    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			    		    	    
			    		    	    hboxCentre.setBackground(new Background(image));
			    		    	    borderUser.setCenter(hboxCentre);
			    		    	    hboxCentre.setAlignment(Pos.CENTER);
			    			    	
			    			    });
			    		    	
			    		    	
			    		    	int u=i;			//salvo la posizione dell'utente nell'array di utenti 
			    		    	
			    		    	/*****************ACQUISTA VINO*****************/
			    		    	
			    		    	buttonBuyWine.setOnAction((e1) ->{
		    		    	    	
		    		    	    	GridPane gridTable = new GridPane();
	    		    	    		final Text NotificationList = new Text();
	    		    	    		gridTable.add(NotificationList, 1, 6);
	    		    	    		final Text table = new Text();
	    		    	    		gridTable.add(table, 1, 6);
	    		    	    		
	    		    	    	 	HBox hboxCentre = new HBox(gridTable);
	    		    	    	 	NotificationList.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    		    	    	 	
	    		    	    	 	
	    		    	    	 	gridTable.setHgap(10);
		    		        	    gridTable.setVgap(10);
		    		        	    gridTable.setPadding(new Insets(25, 25, 25, 25));


		    		        	    Text scenetitle1 = new Text("Acquisto vino:");
		    		        	    scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    		        	    grid.add(scenetitle1, 0, 0, 2, 1);

		    		        	    Label Name = new Label("Nome:");
		    		        	    gridTable.add(Name, 0, 1);

		    		        	    TextField vName = new TextField();
		    		        	    gridTable.add(vName, 1, 1);
		    		        	    //String SvName=vName.getText();
		    		        	    
		    		        	    
		    		        	    Label Year = new Label("Anno:");
		    		        	    gridTable.add(Year, 0, 2);

		    		        	    TextField vYear = new TextField();
		    		        	    gridTable.add(vYear, 1, 2);
		    		        	    
		    		        	    
		    		        	    final Text actiontarget1 = new Text();
		    		        	    gridTable.add(actiontarget1, 1, 2);
		    		        	    
		    		        	    Button btn1   = new Button("submit");
		    		        	    HBox   hbBtn1 = new HBox(10);
		    		        	    hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
		    		        	    hbBtn1.getChildren().add(btn1);
		    		        	    gridTable.add(hbBtn1, 1, 3);
		    		        	    
		    		        	    
		    		        	    btn1.setOnAction((e2) -> {
		    		        	    				    		        	    
			    		        		
										boolean flag=true;
										GridPane gridTable1 = new GridPane();
										final Text Message = new Text();
										gridTable.add(Message, 1, 6);
			    		        		
			    		        				    		        	    
			    		        	    
		    		        	    	for(int i1=0; i1<wine.size(); i1++)									
										{
											if(vName.getText().contentEquals(wine.get(i1).getName()) &&
					    		    	    		   Integer.parseInt((vYear.getText()))==wine.get(i1).getYear()) 
											{
												
												gridTable1.add(Message, 1, 1);
					    		        		final Text table1 = new Text();
					    		        		gridTable1.add(table1, 1, 2);
					    		        	 	HBox hboxCentre1 = new HBox(gridTable1);
					    		        	 	table1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
					    		        	 	
					    		        	 	gridTable1.setHgap(10);
					    		        	    gridTable1.setVgap(10);
					    		        	    gridTable1.setPadding(new Insets(25, 25, 25, 25));
												
					    		        	 						    		        	 												
												//Message.setText("Vino trovato!\nQuante bottiglie vuoi acquistare?: ");
												
												Label Quantity = new Label("Quantità:");
					    		        	    gridTable1.add(Quantity, 0, 1);

					    		        	    TextField vQuantity = new TextField();
					    		        	    gridTable1.add(vQuantity, 0, 2);
					    		        	    
					    		        	    final Text actiontarget11 = new Text();
					    		        	    gridTable1.add(actiontarget11, 1, 1);
					    		        	    
					    		        	    Button quantity   = new Button("Inserisci");
					    		        	    HBox   hbBtn11 = new HBox(10);
					    		        	    hbBtn11.setAlignment(Pos.BOTTOM_RIGHT);
					    		        	    hbBtn11.getChildren().add(quantity);
					    		        	    gridTable1.add(hbBtn11, 1, 5);
					    		        	    
					    		        	    flag=false;
					    		        	    
					    		        	    int j=i1;
					    		        	    quantity.setOnAction((e22) -> {
					    		        	    	
					    		        	    	if(wine.get(j).getNumberBottle()-Integer.parseInt(vQuantity.getText())>0)
					    		        	    	{
					    		        	    		String wine_name = wine.get(j).getName();					
														int wine_year1 = wine.get(j).getYear();
														String noteV = wine.get(j).getNote();
														String wine_origin = wine.get(j).getOrigin();
														int bottle_made = wine.get(j).getNumberBottleMade();
														int available_bottle = wine.get(j).getNumberBottle()-Integer.parseInt(vQuantity.getText()); 										//update remaining number of bottle in the store
														
														System.out.println("-"+wine_name+"-"+wine_year1+"-"+noteV+"-"+wine_origin+"-"+bottle_made+"-"+available_bottle+"-");
														
														wine.get(j).set_wine(wine_name, wine_year1, noteV, wine_origin, bottle_made, available_bottle);		//set wine
														
														
														Database.modificaVino(wine.get(j));    //aggiorno database vini
														
														Notification tmp1 = new Notification();																//update order list
														tmp1.set_Notification(user.get(u).getEmail(), "ha acquistato", wine_name, wine_year1, Integer.parseInt(vQuantity.getText()));
														order.add(tmp1);
														System.out.print("-"+tmp1+"-");
														
														Database.aggiungiNotifica(tmp1);  		//aggiorno database ordini
														
														GridPane gridTable2 = new GridPane();
														final Text Message1 = new Text();
														gridTable.add(Message1, 1, 6);
														gridTable2.add(Message1, 1, 1);
							    		        		final Text table2 = new Text();
							    		        		gridTable1.add(table2, 1, 2);
							    		        		Message1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
							    		        		
							    		        	 	HBox hboxCentre2 = new HBox(gridTable2);
														gridTable2.setHgap(10);
							    		        	    gridTable2.setVgap(10);
							    		        	    gridTable2.setPadding(new Insets(25, 25, 25, 25));	
					    		        	    		
					    		        	    		Message1.setText("Vino acquistato correttamente!");
					    		        	    		
					    		        	    		hboxCentre2.setPadding(new Insets(15, 12, 15, 12));
								    		    	    hboxCentre2.setSpacing(10);
								    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
								    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
								    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
								    		    	    
								    		    	    hboxCentre2.setBackground(new Background(image));
								    		    	    borderUser.setCenter(hboxCentre2);
								    		    	    hboxCentre2.setAlignment(Pos.CENTER);
														
					    		        	    	}
					    		        	    	
					    		        	    	else if(wine.get(j).getNumberBottle()-Integer.parseInt(vQuantity.getText())==0)							//if quantity of wine in the store is the same of the request
													{
														String wine_name = wine.get(j).getName();
														int wine_year1 = wine.get(j).getYear();
														String wine_note = wine.get(j).getNote();
														String wine_origin = wine.get(j).getOrigin();
														int bottle_made = wine.get(j).getNumberBottleMade();
														//int available_botle = wine[b].getNumberBottle()-Integer.parseInt(vQuantity.getText()); 											//update remaining number of bottle in the store
														wine.get(j).set_wine(wine_name, wine_year1, wine_note, wine_origin, bottle_made, 0);		//set wine
														
														Database.modificaVino(wine.get(j));    //aggiorno database
														
														
														System.out.println("-"+wine_name+"-"+wine_year1+"-"+wine_note+"-"+wine_origin+"-"+bottle_made+"-0-");
														
														Notification tmp1 = new Notification();										
														tmp1.set_Notification(user.get(u).getEmail(), "ha esaurito", wine_name, wine_year1, 0);
														notify.clear();
														notify.add(tmp1);
														user.get(0).set_notification(notify);											//Update admin's notification list
														Database.aggiungiNotifica(tmp1);
														
														Notification tmp11 = new Notification();									//update order list
														tmp11.set_Notification(user.get(u).getEmail(),"ha acquistato", wine_name, wine_year1, Integer.parseInt(vQuantity.getText()));
														Database.aggiungiNotifica(tmp11);  		//aggiorno database
														
														System.out.print("-"+tmp1+"-");
														System.out.print("-"+tmp11+"-");
														
																												
														GridPane gridTable2 = new GridPane();
														final Text Message1 = new Text();
														gridTable.add(Message1, 1, 6);
														gridTable2.add(Message1, 1, 1);
							    		        		final Text table2 = new Text();
							    		        		gridTable1.add(table2, 1, 2);
							    		        		Message1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
							    		        		
							    		        	 	HBox hboxCentre2 = new HBox(gridTable2);
														gridTable2.setHgap(10);
							    		        	    gridTable2.setVgap(10);
							    		        	    gridTable2.setPadding(new Insets(25, 25, 25, 25));
					    		        	    		
					    		        	    		Message1.setText("Vino acquistato correttamente!");
					    		        	    		
					    		        	    		hboxCentre2.setPadding(new Insets(15, 12, 15, 12));
								    		    	    hboxCentre2.setSpacing(10);
								    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
								    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
								    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
								    		    	    
								    		    	    hboxCentre.setBackground(new Background(image));
								    		    	    borderUser.setCenter(hboxCentre2);
								    		    	    hboxCentre2.setAlignment(Pos.CENTER);
															
													}
					    		        	    	
					    		        	    	else if(wine.get(j).getNumberBottle()-Integer.parseInt(vQuantity.getText())<0)			//if quantity of wine in the store is less than the request
													{
					    		        	    		String wine_name = wine.get(j).getName();
														int wine_year1 = wine.get(j).getYear();
														Notification tmp1 = new Notification();											//Update admin's notification list
														tmp1.set_Notification(user.get(u).getEmail(),"q insufficente", wine_name, wine_year1, Integer.parseInt(vQuantity.getText()));
														notify.clear();
														notify.add(tmp1);
														user.get(0).set_notification(notify);
														
														Database.aggiungiNotifica(tmp1);
														System.out.print("-"+tmp1+"-");
					    		        	    		
														
														GridPane gridTable2 = new GridPane();
														final Text Message1 = new Text();
														gridTable.add(Message1, 1, 6);
														gridTable2.add(Message1, 1, 1);
							    		        		final Text table2 = new Text();
							    		        		Message1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
							    		        		
							    		        		gridTable1.add(table2, 1, 2);
							    		        	 	HBox hboxCentre2 = new HBox(gridTable2);
														gridTable2.setHgap(10);
							    		        	    gridTable2.setVgap(10);
							    		        	    gridTable2.setPadding(new Insets(25, 25, 25, 25));
					    		        	    		
					    		        	    		Message1.setText("La quantità di bottiglie disponibili non è sufficiente, \n\nle verrà notificato quando sarà nuovamente disponibile...");
																												
														hboxCentre2.setPadding(new Insets(15, 12, 15, 12));
								    		    	    hboxCentre2.setSpacing(10);
								    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
								    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
								    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
								    		    	    
								    		    	    hboxCentre.setBackground(new Background(image));
								    		    	    borderUser.setCenter(hboxCentre2);
								    		    	    hboxCentre2.setAlignment(Pos.CENTER);
														
													}
					    		        	    	
					    		        	    	
					    		        	    });
					    		        	    
					    		        	    
					    		        	    hboxCentre1.setPadding(new Insets(15, 12, 15, 12));
						    		    	    hboxCentre1.setSpacing(10);
						    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
						    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
						    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
						    		    	    
						    		    	    hboxCentre1.setBackground(new Background(image));
						    		    	    borderUser.setCenter(hboxCentre1);
						    		    	    hboxCentre1.setAlignment(Pos.CENTER);
					    		        	    
											}
											
											}
		    		        	    	if(flag)
		    		        	    	{
		    		        	    		Message.setText("vino non trovato!");
		    		        	    								
		    		        	    	}
	    		    	           
			    		    	    		    		    	    	
		    		    	    });
		    		        	    hboxCentre.setPadding(new Insets(15, 12, 15, 12));
			    		    	    hboxCentre.setSpacing(10);
			    		    	    BackgroundSize backgroundSize = new BackgroundSize(900, 700, true, true, true, false);
			    		    	    BackgroundImage image = new BackgroundImage( new Image("file:sfondo_completo.png"),
			    		    	    		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			    		    	    
			    		    	    hboxCentre.setBackground(new Background(image));
			    		    	    borderUser.setCenter(hboxCentre);
			    		    	    hboxCentre.setAlignment(Pos.CENTER);
			    		    	    
			    		    });
			    		    	
			    		    	
			    		    	
			    		    	/*****************LOGOUT*****************/
		    		    	    
	    		    	    	buttonBack.setOnAction((e1) ->{
	    		    	    		
	    		    	    		NoUserStage.show();
	    				    	    secondaryStage.hide();
	    				    	    UserStage.hide();
	    		    	    	});
	    		    	    	
	    		    	    	
			    		    	
			    		    	Scene scene = new Scene(borderUser, 740, 550);
		    		    		UserStage.setScene(scene);
		    		    		UserStage.setTitle("Wine Shop");
		    		    		UserStage.show();
		    	      		}
		    	      		
	    	    		}
	    	    		else
	    	    		{
	    	    			actiontarget.setFill(Color.FIREBRICK);
		    	      		actiontarget.setText("Login fallito riprovare");
	    	    		}
	    	    	}
	    	    });

	    	    Scene scene = new Scene(grid, 300, 275);
	    	    secondaryStage.setScene(scene);
	    	    secondaryStage.show();
            }
	    	
	    });

	    Scene scene = new Scene(borderNoUser, 740, 550);
		NoUserStage.setScene(scene);
		NoUserStage.setTitle("Wine Shop");
		NoUserStage.show();
		
				
	}
}

