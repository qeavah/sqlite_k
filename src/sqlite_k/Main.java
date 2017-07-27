package sqlite_k;

import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqliteDB db = new SqliteDB();
		ResultSet age = db.getAge();
		
		try {
			System.out.println(age.getInt(1));					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


