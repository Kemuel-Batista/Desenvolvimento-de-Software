package Atividade_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Clientes {
	private Connection conn;
	PreparedStatement ps = null;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	public String nome;
	public String cpf;
	public String email;
	
	public Clientes (String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public void findOne(int cliente_id) {
		try {
			String sql = "SELECT * FROM clientes WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cliente_id);
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
			System.out.println("Ocorreu um erro ao buscar os dados do cliente: " + e.getMessage());
		}
	}
	
	public void save(int id, Clientes cliente) {
		if(id == 0) {
			// SALVAR CLIENTE NO BANCO
			try {
				String sql = "INSERT INTO clientes (cpf, nome, email, data_registro) VALUES (?,?,?,NOW())";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cliente.cpf);
				ps.setString(2, cliente.nome);
				ps.setString(3, cliente.email);
				
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
		} else {
			// UPDATE
			try {
				String sql = "UPDATE clientes SET cpf=?, nome=?, email=?, data_update=NOW() WHERE id=?";
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, cliente.cpf);
				ps.setString(2, cliente.nome);
				ps.setString(3, cliente.email);
				
				int linhasAfetadas = ps.executeUpdate();
				
				if(linhasAfetadas > 0) {
					System.out.println("Registro atualizado com sucesso!");
	            } else {
	                System.out.println("Não foi possível inserir o registro.");
	            }
				
				ps.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível executar a instrução SQL.");
			}
		}
	}
}
