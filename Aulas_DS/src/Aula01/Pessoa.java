package Aula01;

public class Pessoa {
	public String cpf;
	public String nome;
	public String sobrenome;
	private double salario;
	
	public String mostrar_nome_completo(String nome_pessoa, String sobrenome_pessoa) {
		return (nome_pessoa + " " + sobrenome_pessoa);
	}
	
	public double getSalario() {
        return salario;
    }

    public void setSalario(double novo_salario) {
        this.salario = novo_salario;
    }
}
