package Atividade_Hierarquia_12_06;

public abstract class Pessoa {
    public String cpf;
    public String email;
    public String nome;

    public abstract boolean save();

    public abstract void find_one();

    public abstract boolean delete();
}