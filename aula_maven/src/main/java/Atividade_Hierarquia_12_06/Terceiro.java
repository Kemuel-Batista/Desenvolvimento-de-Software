package Atividade_Hierarquia_12_06;

public class Terceiro extends Pessoa {
    public boolean ativo;
    public boolean situacao;

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

    public boolean inativar() {
        return this.ativo = false;
    }

    public boolean encerrar_contrato() {
        return this.situacao = false;
    }
}
