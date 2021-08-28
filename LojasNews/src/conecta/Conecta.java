package conecta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {
    
    public Connection getConnection(){
        
        String URL = "jdbc:mysql://localhost/lojas_news";
        String USER = "root";
        String PASS = "";
        
        try {
            
            return DriverManager.getConnection(URL ,USER,PASS);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     
    }
    
}
