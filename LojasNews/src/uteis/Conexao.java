
package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:myslq://localhost:3306/nome_do_banco";
    private static final String user = "seu_usuario";
    private static final String password = "sua_senha";
    
    public static Connection getConnection() {
        Connection conexao = null;

		try {
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conexao;
    }
}
