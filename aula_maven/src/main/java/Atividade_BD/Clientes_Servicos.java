package Atividade_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Clientes_Servicos {
	Connection conn = MySqlConnection.getConnection();
	PreparedStatement ps = null;
	
	public int id_cliente;
	public int id_servico;
	
	public Clientes_Servicos() {}
	
	public void findOne(int cliente_id) {
	    try {
	        String sql = "SELECT c.id AS id_cliente, c.nome AS nome_cliente, s.nome AS nome_servico, s.valor AS valor_servico, cs.data_registro FROM clientes c LEFT JOIN clientes_servicos cs ON c.id = cs.id_cliente LEFT JOIN servicos s ON cs.id_servico = s.id WHERE c.id = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, cliente_id);
	        ResultSet rs = ps.executeQuery();

	        boolean isFirstRow = true;
	        while (rs.next()) {
	            int id_cliente = rs.getInt("id_cliente");
	            String nome_cliente = rs.getString("nome_cliente");
	            String nome_servico = rs.getString("nome_servico");
	            float valor_servico = rs.getFloat("valor_servico");
	            Timestamp data_registro = rs.getTimestamp("data_registro");

	            if (isFirstRow) {
	                System.out.println("ID do Cliente: " + id_cliente);
	                System.out.println("Nome do Cliente: " + nome_cliente);
	                isFirstRow = false;
	            }

	            System.out.println("---------- SERVIÇO ------------");
	            System.out.println("Nome do Serviço: " + nome_servico);
	            System.out.println("Valor do Serviço: " + valor_servico);
	            System.out.println("Data de Registro: " + data_registro);
	            System.out.println("--------------------------------");
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        System.out.println("Ocorreu um erro ao buscar os dados dos clientes: " + e.getMessage());
	    }
	}

	
	public void save(int id_cliente, Clientes_Servicos cliente_servico, int id_servico) {
		if(id_cliente == 0) {
			try {
				String sql = "INSERT INTO clientes_servicos (id_cliente, id_servico) VALUES (?,?)";
	    	    ps = conn.prepareStatement(sql);
	    	    ps.setInt(1, cliente_servico.id_cliente);
	    	    ps.setInt(2, cliente_servico.id_servico);
	    	    
	    	    int linhasAfetadas = ps.executeUpdate();
	    	    
	    	    if (linhasAfetadas > 0) {
	    	        System.out.println("Novo serviço cadastrado para o cliente!");
	    	    } else {
	    	    	System.out.println("Não foi possível adicionar esse serviço ao cliente.");
	    	    }
	    	    ps.close();
			} catch (SQLException e) {
	    	    System.out.println("Não foi possível executar a instrução SQL." + e.getMessage());
	    	}
		} else {
			try {
				String sqlUpdateServico = "UPDATE clientes_servicos SET id_servico=? WHERE id_cliente=? LIMIT 1";
                ps = conn.prepareStatement(sqlUpdateServico);
                
                
				ps.setInt(1, id_servico);
				ps.setInt(2, id_cliente);
				
				int linhasAfetadas = ps.executeUpdate();
				
				if(linhasAfetadas > 0) {
					System.out.println("Serviço do cliente atualizado com sucesso!");
	            } else {
	                System.out.println("Não foi possível inserir o registro.");
	            }
			} catch (SQLException e) {
	    	    System.out.println("Não foi possível executar a instrução SQL." + e.getMessage());
	    	}
		}
	}
	
	public void delete(int id_servico) {
		try {
			String sqlDeleteServico = "DELETE FROM clientes_servicos WHERE id_servico=?";
	        PreparedStatement psDeleteServico = conn.prepareStatement(sqlDeleteServico);
	        psDeleteServico.setInt(1, id_servico);
	        
	        int linhasAfetadas = psDeleteServico.executeUpdate();

	        if (linhasAfetadas > 0) {
	            System.out.println("Servico do cliente deletado com sucesso!");
	        } else {
	            System.out.println("Não foi possível deletar o registro.");
	        }
	        psDeleteServico.close();
		} catch (SQLException e) {
	        System.out.println("Não foi possível executar a instrução SQL." + e.getMessage());
	    }
	}
	
}
