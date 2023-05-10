package Banco_de_Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	Connection conn = null;
	
	public Connection GetConnection() {
		 try {
			String url = "jdbc:mysql://localhost:3306/bd_java";
			String username = "root";
			String password = "positivo";
			
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao estabelecer a conexão: " + e.getMessage());
		}
		return conn;
	}
	
	public void CloseConnection() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("Conexão fechada com sucesso!");
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Ocorreu um erro ao fechar a conexão: " + e2.getMessage());
			}
		}
	}
}
