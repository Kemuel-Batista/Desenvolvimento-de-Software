package Atividade_Hierarquia_12_06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Funcionario extends Pessoa {
    public double salario;
    public Date aniversario;
    public String telefone;
    public String departamento;

    @Override
    public boolean save() {
        PreparedStatement ps = null;
        Connection conn = SqlConnection.getConnection();

        boolean status = false;

        try {
            String sql = "INSERT INTO funcionario (cpf, nome, email, salario, aniversario, telefone, departamento) VALUES (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.setString(2, nome);
            ps.setString(3, email);
            ps.setDouble(4, this.salario);
            ps.setDate(5, this.aniversario);
            ps.setString(6, this.telefone);
            ps.setString(7, this.departamento);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                status = true;
            } else {
                status = false;
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível executar a instrução SQL.");
        }

        return status;
    }

    @Override
    public void find_one() {
        PreparedStatement ps = null;
        Connection conn = SqlConnection.getConnection();

        try {
            String sql = "SELECT * FROM funcionario WHERE cpf=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Float salario = rs.getFloat("salario");
                Date aniversario = rs.getDate("aniversario");
                String telefone = rs.getString("telefone");
                String departamento = rs.getString("departamento");

                System.out.println("CPF: " + cpf + "\nNome: " + nome + "\nEmail: " + email +
                        "\nSalário: " + salario + "\nAniversário: " + aniversario + "\nTelefone: "
                        + telefone + "\nDepartamento: " + departamento);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar os dados do Funcionário: " + e.getMessage());
        }
    }

    @Override
    public boolean delete() {
        PreparedStatement ps = null;
        Connection conn = SqlConnection.getConnection();

        boolean status = false;

        try {
            String sql = "DELETE FROM funcionario WHERE cpf=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, this.cpf);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                status = true;
            } else {
                status = false;
            }

            ps.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível executar a instrução SQL.");
        }

        return status;
    }
}
