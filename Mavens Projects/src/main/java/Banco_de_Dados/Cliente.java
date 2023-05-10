package Banco_de_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
	private Connection conn;
	PreparedStatement ps = null;
	
	public int id;
	public String nome;
	public String cpf;
	public String email;
	
	public Cliente() {
		MySqlConnection mysqlconnection = new MySqlConnection();
		conn = mysqlconnection.GetConnection();
	}
	
	public Cliente (int id, String nome, String cpf, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public void getListClientes() {
		try {
			String sql = "SELECT * FROM clientes";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				
				System.out.println("ID: " + id + "\nCPF: " + cpf + "\nNome: " + nome + "\nEmail: " + email);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ocorreu um erro ao buscar os dados da lista: " + e.getMessage());
		}
	}
	
	public void CadastrarCliente(Cliente cliente) {
		try {
			String sql = "INSERT INTO clientes (id, cpf, nome, email) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cliente.id);
			ps.setString(2, cliente.cpf);
			ps.setString(3, cliente.nome);
			ps.setString(4, cliente.email);
			
			int linhasAfetadas = ps.executeUpdate();
			
			if(linhasAfetadas > 0) {
				System.out.println("Registro inserido com sucesso!");
            } else {
                System.out.println("Não foi possível inserir o registro.");
            }
			ps.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível executar a instrução SQL.");
		}
	}
	
	public void AlterarCliente(String cpf, String Nome, int id) {
		try {
			String sql = "UPDATE clientes SET cpf=?, nome=? WHERE id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cpf);
			ps.setString(2, Nome);
			ps.setInt(3, id);
			
			int linhasAfetadas = ps.executeUpdate();
			
			if(linhasAfetadas > 0) {
				System.out.println("Registro inserido com sucesso!");
            } else {
                System.out.println("Não foi possível inserir o registro.");
            }
			
			ps.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível executar a instrução SQL.");
		}
	}
}
