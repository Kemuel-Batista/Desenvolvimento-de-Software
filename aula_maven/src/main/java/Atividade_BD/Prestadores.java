package Atividade_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prestadores {
	Connection conn = MySqlConnection.getConnection();
	PreparedStatement ps = null;
	
	public String nome;
	public int id_servico;
	
	public Prestadores() {}
	
	public void findOne(int cliente_id) {
		 try {
	        String sql = "SELECT pr.id, pr.nome, sv.nome as nome_servico, sv.valor as valor_servico FROM prestadores pr LEFT OUTER JOIN prestadores_servicos ps ON pr.id = ps.id_prestador LEFT OUTER JOIN servicos as sv ON sv.id = ps.id_servico WHERE pr.id=?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, cliente_id);
	        ResultSet rs = ps.executeQuery();

	        boolean isFirstRow = true;
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nome_prestador = rs.getString("nome");
	            String nome_servico = rs.getString("nome_servico");
	            Float valor = rs.getFloat("valor_servico");
	            
	            if (isFirstRow) {
	                System.out.println("ID: " + id);
	                System.out.println("Nome: " + nome_prestador);
	                isFirstRow = false;
	            }
	            
	            System.out.println("---------- SERVIÇO ------------");
	            System.out.println("Nome do Serviço: " + nome_servico);
	            System.out.println("Valor do Serviço: " + valor);
	            System.out.println("--------------------------------");
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        System.out.println("Ocorreu um erro ao buscar os dados dos prestadores: " + e.getMessage());
	    }
	}
	
	public void save(int id, int id_servico) {
	    if (id == 0) {
	        // SALVAR PRESTADOR NO BANCO
	    	try {
	    	    String sql = "INSERT INTO prestadores (nome) VALUES (?)";
	    	    ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    	    ps.setString(1, this.nome);
	    	    
	    	    int linhasAfetadas = ps.executeUpdate();
	    	    
	    	    if (linhasAfetadas > 0) {
	    	        System.out.println("Registro de prestador inserido com sucesso!");

	    	        // Obtém o ID do prestador inserido
	    	        ResultSet generatedKeys = ps.getGeneratedKeys();
	    	        if (generatedKeys.next()) {
	    	            int prestadorId = generatedKeys.getInt(1);

	    	            // Insere na tabela prestadores_servicos
	    	            String sqlPrestadoresServicos = "INSERT INTO prestadores_servicos (id_prestador, id_servico) VALUES (?, ?)";
	    	            PreparedStatement psPrestadoresServicos = conn.prepareStatement(sqlPrestadoresServicos);
	    	            psPrestadoresServicos.setInt(1, prestadorId);
	    	            psPrestadoresServicos.setInt(2, this.id_servico);

	    	            int linhasAfetadasPrestadoresServicos = psPrestadoresServicos.executeUpdate();

	    	            if (linhasAfetadasPrestadoresServicos > 0) {
	    	                System.out.println("Registro inserido na tabela prestadores_servicos com sucesso!");
	    	            } else {
	    	                System.out.println("Não foi possível inserir o registro na tabela prestadores_servicos.");
	    	            }

	    	            psPrestadoresServicos.close();
	    	        } else {
	    	            System.out.println("Não foi possível obter o ID do prestador inserido.");
	    	        }
	    	    } else {
	    	        System.out.println("Não foi possível inserir o registro de prestador.");
	    	    }
	    	    
	    	    ps.close();
	    	} catch (SQLException e) {
	    	    System.out.println("Não foi possível executar a instrução SQL." + e.getMessage());
	    	}
	    } else {
	        // UPDATE
	    	try {
	            // Verifica se o id_servico é diferente de 0
	            if (id_servico != 0) {
	                // Atualiza o registro da tabela prestadores_servicos
	                String sqlUpdateServico = "UPDATE prestadores_servicos SET id_servico=? WHERE id_prestador=?";
	                PreparedStatement psUpdateServico = conn.prepareStatement(sqlUpdateServico);
	                psUpdateServico.setInt(1, id_servico);
	                psUpdateServico.setInt(2, id);
	                psUpdateServico.executeUpdate();
	                
	                int linhasAfetadas = psUpdateServico.executeUpdate();

	                if (linhasAfetadas > 0) {
	                    System.out.println("Registro dos servicos do Prestador atualizado com sucesso!");
	                } else {
	                    System.out.println("Não foi possível atualizar o registro.");
	                }
	                
	                psUpdateServico.close();
	            }

	            // Verifica se o nome do prestador não é vazio
	            if (!this.nome.equals("")) {
	                // Atualiza o nome do prestador na tabela prestadores
	                String sqlUpdatePrestador = "UPDATE prestadores SET nome=? WHERE id=?";
	                PreparedStatement psUpdatePrestador = conn.prepareStatement(sqlUpdatePrestador);
	                psUpdatePrestador.setString(1, this.nome);
	                psUpdatePrestador.setInt(2, id);
	                int linhasAfetadas = psUpdatePrestador.executeUpdate();

	                if (linhasAfetadas > 0) {
	                    System.out.println("Registro do Prestador atualizado com sucesso!");
	                } else {
	                    System.out.println("Não foi possível atualizar o registro.");
	                }

	                psUpdatePrestador.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Não foi possível executar a instrução SQL." + e.getMessage());
	        }
	    }
	}
	
	public void delete(int id) {
	    try {
	        // Delete registros relacionados na tabela prestadores_servicos
	        String sqlDeleteServicos = "DELETE FROM prestadores_servicos WHERE id_prestador=?";
	        PreparedStatement psDeleteServicos = conn.prepareStatement(sqlDeleteServicos);
	        psDeleteServicos.setInt(1, id);
	        psDeleteServicos.executeUpdate();
	        psDeleteServicos.close();

	        // Delete registro da tabela prestadores
	        String sqlDeletePrestador = "DELETE FROM prestadores WHERE id=?";
	        PreparedStatement psDeletePrestador = conn.prepareStatement(sqlDeletePrestador);
	        psDeletePrestador.setInt(1, id);
	        int linhasAfetadas = psDeletePrestador.executeUpdate();

	        if (linhasAfetadas > 0) {
	            System.out.println("Registro deletado com sucesso!");
	        } else {
	            System.out.println("Não foi possível deletar o registro.");
	        }

	        psDeletePrestador.close();
	    } catch (SQLException e) {
	        System.out.println("Não foi possível executar a instrução SQL." + e.getMessage());
	    }
	}
	
	public void adicionarServico(int id_prestador, int id_servico) {
		try {
    	    String sql = "INSERT INTO prestadores_servicos (id_prestador, id_servico) VALUES (?,?)";
    	    ps = conn.prepareStatement(sql);
    	    ps.setInt(1, id_prestador);
    	    ps.setInt(2, id_servico);
    	    
    	    int linhasAfetadas = ps.executeUpdate();
    	    
    	    if (linhasAfetadas > 0) {
    	        System.out.println("Registro de novo serviço inserido com sucesso!");
    	    } else {
    	    	System.out.println("Não foi possível inserir novo serviço ao prestador!");
    	    }
		} catch (SQLException e) {
	        System.out.println("Não foi possível executar a instrução SQL." + e.getMessage());
	    }
	}
}