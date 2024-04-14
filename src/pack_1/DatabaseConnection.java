

package pack_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
	private static Connection connection;

    public static Connection getConnection() {
        
    	try {
            
    		String url = "jdbc:mysql://localhost:3306/ENSA_DB";
            String user = "ENSA";
            String password = "ENSAKh-197";
            
            connection = DriverManager.getConnection(url, user, password);
            
            return connection;
        
    	} 
    	
    	catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}






