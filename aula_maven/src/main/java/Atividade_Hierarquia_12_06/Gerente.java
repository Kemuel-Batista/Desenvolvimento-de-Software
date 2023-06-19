package Atividade_Hierarquia_12_06;

import java.util.Date;

public class Gerente extends Pessoa {
    public double salario;
    public Date aniversario;
    public String telefone;
    public String departamento;
    public double gratificacao;

    @Override
    public boolean save() {
        boolean status = false;

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

    public double calcularbonus() {
        double bonus = 0;

        return bonus;
    }
}
