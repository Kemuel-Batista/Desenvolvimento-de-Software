package Atividade_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static Connection conn = null;
    
    private static String url = "jdbc:mysql://localhost:3306/empresa_coisas_coisas";
    private static String username = "root";
    private static String password = "positivo";
    
    private MySqlConnection() {}
    
    public static Connection getConnection() {
        if (conn == null) {	
        	try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.println("Não foi possível conectar ao Banco de Dados: " + e.getMessage());
            }
        }
        return conn;
    }
}
