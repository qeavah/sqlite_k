package sqlite_k;

import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqliteDB db = new SqliteDB();
		Object[][] obiekt = new Object[10][10];
		obiekt = (Object[][]) db.getObjectData();
			
		for (int i=1;i<=3;i++) {
			System.out.println("");
			for (int j=1;j<=4;j++)
			System.out.print(obiekt[i][j]+" ");
		}
		
		
		db.closeDB();
		
		

		

	}
	


}


