package Atividade_Hierarquia_12_06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Funcionario extends Pessoa {
    public double salario;
    public Date aniversario;
    public String telefone;
    public String departamento;

    Connection conn = SqlConnection.getConnection();

    @Override
    public boolean save() {
        PreparedStatement ps = null;

        boolean status = false;

        try {
            String sql = "INSERT INTO professores (cpf, nome, email, matricula) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.setString(2, nome);
            ps.setString(3, email);
            ps.setString(4, matricula);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Registro inserido com sucesso!");
            } else {
                System.out.println("Não foi possível inserir o registro.");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível executar a instrução SQL.");
        }

        return status;
    }

    @Override
    public void find_one() {

    }

    @Override
    public boolean delete() {
        boolean status = false;

        return status;
    }
}
