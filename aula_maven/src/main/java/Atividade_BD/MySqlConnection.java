package Atividade_BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	static Connection conn = null;
	
	static String url = "jdbc:mysql://localhost:3306/empresa_coisas_coisas";
	static String username = "root";
	static String password = "";
	
	private MySqlConnection() {}
	
	public static Connection getConnection() {
		if(conn == null) {
			return conexao(url, username, password);
		}
		return conn;
	}
	
	private static Connection conexao(String url, String username, String password) {
		try {
			conn = DriverManager.getConnection(url, username, password);
			
			return conn;
		} catch (Exception e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados: " + e.getMessage());
			
			return null;
		}
	}
}