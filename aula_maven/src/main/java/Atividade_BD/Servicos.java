package Atividade_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Servicos {
	Connection conn = MySqlConnection.getConnection();
	PreparedStatement ps = null;
	
	public String nome;
	public double valor;
	
	public Servicos() {}
	
	public void findOne(int cliente_id) {
		try {
			String sql = "SELECT * FROM servicos WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cliente_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				Float valor = rs.getFloat("valor");
				
				System.out.println("ID: " + id + "\nNome: " + nome + "\nValor: " + valor);
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ocorreu um erro ao buscar os dados do cliente: " + e.getMessage());
		}
	}
	
	public void save(int id, Servicos servico) {
	    if (id == 0) {
	        // SALVAR CLIENTE NO BANCO
	        try {
	            String sql = "INSERT INTO servicos (nome, valor) VALUES (?,?)";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, servico.nome);
	            ps.setDouble(2, servico.valor);
	            
	            int linhasAfetadas = ps.executeUpdate();
	            
	            if (linhasAfetadas > 0) {
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
	            String sql = "UPDATE servicos SET nome=?, valor=? WHERE id=?";
	            ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, servico.nome);
	            ps.setDouble(2, servico.valor);
	            ps.setInt(3, id);
	            
	            int linhasAfetadas = ps.executeUpdate();
	            
	            if (linhasAfetadas > 0) {
	                System.out.println("Registro atualizado com sucesso!");
	            } else {
	                System.out.println("Não foi possível atualizar o registro.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Não foi possível executar a instrução SQL.");
	        }
	    }
	}
	
	public void delete(int id) {
	    try {
	        String sql = "DELETE FROM servicos WHERE id=?";
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
