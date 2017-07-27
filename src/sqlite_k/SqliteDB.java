package sqlite_k;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SqliteDB {
	private static final String[][] Object = null;

	public boolean status=false;

	Connection c = null;
	Statement stmt = null;
	
	SqliteDB(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:my_database.sqlite");
			//System.out.println("Connected to DB");	
		} catch (Exception e) {
			System.out.println("Error:" + " " + e.getMessage()+" ");
		}
	}
	
	public boolean statusDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:my_database.sqlite");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void printDB() {
		try {
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM list");
			int id=0;
			while (rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("Name");
				String password = rs.getString("Password");
				int age = rs.getInt("age");			
				System.out.print(id + " " + name + " " + password + " " + age + " ");
			}
			
		}catch (Exception e) {
			System.out.println("Error:" + " " + e.getMessage()+" ");

		}
	}
	
	public ResultSet getAge() {
		try {
		this.stmt = c.createStatement();
		ResultSet age = stmt.executeQuery("SELECT Age FROM list");
		return age;
		} catch (Exception e) {
			System.out.println("Error:" + " " + e.getMessage()+" ");
			return null;
		}
		
	}
	
	public ResultSet getData() {
		try {
			this.stmt = c.createStatement();
			ResultSet data = stmt.executeQuery("SELECT * FROM list");
			return data;
			
		} catch (Exception e) {
			System.out.println("Error:" + " " + e.getMessage()+" ");
			return null;
		}
	} // end getData
	
	
	public Object getObjectData() {
		try {
			this.stmt = c.createStatement();
			ResultSet data = stmt.executeQuery("SELECT * FROM list");			
			Object[][] obiekt = new Object[10][10];

			int i=1;
			while (data.next()) {	
				obiekt[i][1]=data.getString("Id");
				obiekt[i][2]=data.getString("Name");
				obiekt[i][3]=data.getString("Password");
				obiekt[i][4]=data.getString("Age");	
				i++;	
			}
			for (int k=1;k<=3;k++) {
				System.out.println("");
				for (int j=1;j<=4;j++)
				System.out.print(obiekt[k][j]+" ");
			}
			
			return obiekt;
		} catch (Exception e) {
			System.out.println("Error1:" + " " + e.getMessage());
			return null;
		}
	} // end getObjectData
	
	public void closeDB() {
		try {
			c.close();
			
		} catch (Exception e) {
			System.out.println("Error:" + " " + e.getMessage()+" ");
		}
	} //end closeDB


	
}
