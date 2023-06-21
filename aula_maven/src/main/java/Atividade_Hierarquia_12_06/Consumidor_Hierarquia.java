package Atividade_Hierarquia_12_06;

import java.sql.Date;

public class Consumidor_Hierarquia {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        f1.cpf = "123456789";
        f1.email = "funcionario@example.com";
        f1.nome = "Funcionario 1";
        f1.salario = 2500.0;
        f1.aniversario = new Date();
        f1.telefone = "987654321";
        f1.departamento = "Departamento 1";

        Gerente g1 = new Gerente();
        g1.cpf = "987654321";
        g1.email = "gerente@example.com";
        g1.nome = "Gerente 1";
        g1.salario = 5000.0;
        g1.aniversario = new Date();
        g1.telefone = "123456789";
        g1.departamento = "Departamento 2";
        g1.gratificacao = 1000.0;

        Terceiro t1 = new Terceiro();
        t1.cpf = "543216789";
        t1.email = "terceiro@example.com";
        t1.nome = "Terceiro 1";
        t1.ativo = true;
        t1.situacao = true;
    }
}
