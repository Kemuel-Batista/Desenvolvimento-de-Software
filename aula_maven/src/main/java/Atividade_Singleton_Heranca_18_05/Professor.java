package Atividade_Singleton_Heranca_18_05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor extends Pessoa {
	Connection conn = SqlConnection.getConnection();
	PreparedStatement ps = null;
	
	public String matricula;
	
	public Professor() {}
	
	@Override
	public void salvar(String cpf, String nome, String email, String matricula) {
		try {
			String sql = "INSERT INTO professores (cpf, nome, email, matricula) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.setString(2, nome);
			ps.setString(3, email);
			ps.setString(4, matricula);
			
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
	
	@Override
	public void findOne(int id) {
		try {
			String sql = "SELECT * FROM professores WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id_registro = rs.getInt("id");
				String matricula = rs.getString("matricula");
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				
				System.out.println("ID: " + id_registro + "\nMatricula: " + matricula + "\nCPF: " + cpf + "\nNome: " + nome + "\nEmail: " + email);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ocorreu um erro ao buscar os dados do Professor: " + e.getMessage());
		}
	}
	
	@Override
	public void delete(int id) {
		try {
	        String sql = "DELETE FROM professores WHERE id=?";
	        ps = conn.prepareStatement(sql);
	        
	        ps.setInt(1, id);
	        
	        int linhasAfetadas = ps.executeUpdate();
	        
	        if (linhasAfetadas > 0) {
	            System.out.println("Registro deletado com sucesso!");
	        } else {
	            System.out.println("Não foi possível deletar o registro.");
	        }
	        
	        ps.close();
	    } catch (SQLException e) {
	        System.out.println("Não foi possível executar a instrução SQL.");
	    }
	}
}