package Atividade_Hierarquia_12_06;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {
    static Connection conn = null;

    static Connection getConnection() {
        if (conn == null) {
            String url = "jdbc:mysql://localhost:3306/bd_hierarquia";
            String username = "root";
            String password = "01021993";

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