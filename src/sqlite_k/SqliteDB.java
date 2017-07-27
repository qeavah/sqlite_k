package sqlite_k;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteDB {

	Connection c = null;
	Statement stmt = null;
	
	SqliteDB(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:my_database.sqlite");
			System.out.println("Connected to DB");
			c.close();
		} catch (Exception e) {
			System.out.println("Error:" + " " + e.getMessage()+" ");
		}
	}
	
}
