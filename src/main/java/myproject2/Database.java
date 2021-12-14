package myproject2;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Database {
	
	
	
	/**
	 * 
	 * GETSIONE TABELLA VINI
	 * 
	 */

	public static ArrayList<Wine> elenco_vini() throws SQLException{
		
		ArrayList<Wine> wine= new ArrayList<Wine>();
		
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		// Creo la connessione al database
		cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");
		// peer è il nome del database

		sql = "SELECT * FROM wine;";
		// ________________________________query
		try {
			st = (Statement) cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				Wine w= new Wine();
				w.set_wine(rs.getString("nome"), rs.getInt("anno"), rs.getString("note"), rs.getString("origine"), rs.getInt("nBottleP"), rs.getInt("nBottle"));
				wine.add(w);
			}
			
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
		
		return wine;
		
	}
	
	public static void nuovoVino(Wine w) {
		Connection cn;
		Statement st;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");

			String nome = StringEscapeUtils.escapeJava(w.getName());
			int anno = w.getYear();
			String note = StringEscapeUtils.escapeJava(w.getNote());
			String origine = StringEscapeUtils.escapeJava(w.getOrigin());
			int nBottleP = w.getNumberBottleMade();
			int nBottle = w.getNumberBottle();

			sql = "insert into wine (nome, anno, note, origine, nBottleP, nBottle) values "
					+ "('" + nome + "','" + anno + "','" + note + "','" + origine + "','" + nBottleP+ 
					"','" + nBottle+ "')";
			System.out.println(sql);
			// ________________________________query

			st = (Statement) cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}
	
	public static void modificaVino(Wine w) {
		
		
		Connection cn;
		Statement st;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch
		try {
			// Creo la connessione al database
			cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");

			// Inserisco nelle variabili i valori da modificare
			String nome = StringEscapeUtils.escapeJava(w.getName());
			int anno = w.getYear();
			int nBottle = w.getNumberBottle();

			sql = "update wine set nBottle='" + nBottle + "' where nome='" + nome +"' and anno='" + anno +"'";
			
			System.out.println(sql); // stampa la query
			// ________________________________query

			st = (Statement) cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}
	
	
	/**
	 * 
	 * GETSIONE TABELLA UTENTI
	 * 
	 */
	
	public static ArrayList<User> elenco_user() throws SQLException{
		
		ArrayList<User> user= new ArrayList<User>();
		
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		// Creo la connessione al database
		cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");
		// peer è il nome del database
		
		sql = "SELECT * FROM user;";
		// ________________________________query
		try {
			st = (Statement) cn.createStatement(); // creo sempre uno statement sulla connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				User u= new User();
				u.set_user(rs.getString("nome"), rs.getString("cognome"), rs.getString("email"), rs.getString("passw"), rs.getBoolean("type"));
				user.add(u);
			}
			
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
		
		return user;
	}	
	
	public static void nuovoUser(User u) {
		
		Connection cn;
		Statement st;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");

			String nome = StringEscapeUtils.escapeJava(u.getName());
			String cognome = StringEscapeUtils.escapeJava(u.getSurname());
			String email = StringEscapeUtils.escapeJava(u.getEmail());
			String passw = StringEscapeUtils.escapeJava(u.getPassw());
			boolean type = u.getType();
			
			int Type=1;
			if(type)
			{
				Type=1;
			}
			else
			{
				Type=0;
			}

			sql = "insert into user (nome, cognome, email, passw, type) values "
					+ "('" + nome + "','" + cognome + "','" + email + "','" + passw + "','" + Type+ 
					"')";
			
			
			System.out.println(sql);
			// ________________________________query

			st = (Statement) cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}
		
	
	/**
	 * 
	 * GETSIONE TABELLA notifiche
	 * 
	 */
	
	public static void aggiungiNotifica(Notification o) {
		
		
		Connection cn;
		Statement st;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");

			String nome = StringEscapeUtils.escapeJava(o.getName());
			String email = StringEscapeUtils.escapeJava(o.getMail());
			String messaggio = StringEscapeUtils.escapeJava(o.getMessage());
			int anno = o.getYear();
			int quantity = o.getQuantity();

			sql = "insert into notifiche (mail, messaggio, nome, anno, quantità) values "
					+ "('" + email + "','"+ messaggio + "','" + nome + "','" + anno + "','" + quantity + "')";
			System.out.println(sql);
			// ________________________________query

			st = (Statement) cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}

	public static void cancellaNotifica(Notification o) {
		
		
		Connection cn;
		Statement st;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");

			
			String email = StringEscapeUtils.escapeJava(o.getMail());
			
			sql = "DELETE FROM notifiche WHERE mail='"+email+"'";
			System.out.println(sql);
			// ________________________________query

			st = (Statement) cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}
	
	public static ArrayList<Notification> elenco_notifiche() throws SQLException{
	
	ArrayList<Notification> notifiche= new ArrayList<Notification>();
	
	Connection cn;
	Statement st;
	ResultSet rs;
	String sql;
	// ________________________________connessione
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("ClassNotFoundException: ");
		System.err.println(e.getMessage());
	} // fine try-catch

	// Creo la connessione al database
	cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enoteca?user=root&password=");
	// peer è il nome del database
	
	sql = "SELECT * FROM notifiche;";
	// ________________________________query
	try {
		st = (Statement) cn.createStatement(); // creo sempre uno statement sulla connessione
		rs = st.executeQuery(sql); // faccio la query su uno statement
		while (rs.next() == true) {
			Notification n= new Notification();
			n.set_Notification(rs.getString("mail"), rs.getString("messaggio"), rs.getString("nome"),  rs.getInt("anno"), rs.getInt("quantità"));
			notifiche.add(n);
		}
		
	} catch (SQLException e) {
		System.out.println("errore:" + e.getMessage());
	} // fine try-catch
	cn.close(); // chiusura connessione
	
	return notifiche;
}




}	

