package Atividade_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Clientes {
	Connection conn = MySqlConnection.getConnection();
	PreparedStatement ps = null;
	
	public String nome;
	public String cpf;
	public String email;
	
	public Clientes () {}
	
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
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ocorreu um erro ao buscar os dados do cliente: " + e.getMessage());
		}
	}
	
	public void save(int id) {
		if(id == 0) {
			// SALVAR CLIENTE NO BANCO
			try {
				String sql = "INSERT INTO clientes (cpf, nome, email) VALUES (?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, this.cpf);
				ps.setString(2, this.nome);
				ps.setString(3, this.email);
				
				int linhasAfetadas = ps.executeUpdate();
				
				if(linhasAfetadas > 0) {
					System.out.println("Registro inserido com sucesso!");
	            } else {
	                System.out.println("Não foi possível inserir o registro.");
	            }
			} catch (SQLException e) {
				System.out.println("Não foi possível executar a instrução SQL.");
			}
		} else {
			// UPDATE
			try {
				String sql = "UPDATE clientes SET cpf=?, nome=?, email=? WHERE id=?";
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, this.cpf);
				ps.setString(2, this.nome);
				ps.setString(3, this.email);
				ps.setInt(4, id);
				
				int linhasAfetadas = ps.executeUpdate();
				
				if(linhasAfetadas > 0) {
					System.out.println("Registro atualizado com sucesso!");
	            } else {
	                System.out.println("Não foi possível inserir o registro.");
	            }
			} catch (SQLException e) {
				System.out.println("Não foi possível executar a instrução SQL.");
			}
		}
	}

	public void delete(int id) {
	    try {
	        String sql = "DELETE FROM clientes WHERE id=?";
	        ps = conn.prepareStatement(sql);
	        
	        ps.setInt(1, id);
	        
	        int linhasAfetadas = ps.executeUpdate();
	        
	        if (linhasAfetadas > 0) {
	            System.out.println("Registro deletado com sucesso!");
	        } else {
	            System.out.println("Não foi possível deletar o registro.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Não foi possível executar a instrução SQL.");
	    }
	}
}