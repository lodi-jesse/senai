package conecta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {

	private final static String URL = "jdbc:mysql://localhost:3306/lojas_news";
	private final static String USER = "root";
	private final static String PASSWORD = "root";

	private static Connection conexao;

	public static Connection getConnection() {

		try {
			if (conexao == null || conexao.isClosed()) {
				conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				return conexao;
			}
			else
				return conexao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
