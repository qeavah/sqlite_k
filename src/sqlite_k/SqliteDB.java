package sqlite_k;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class SqliteDB {
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
	
	public void closeDB() {
		try {
			c.close();
			
		} catch (Exception e) {
			System.out.println("Error:" + " " + e.getMessage()+" ");
		}
	}
	
}
