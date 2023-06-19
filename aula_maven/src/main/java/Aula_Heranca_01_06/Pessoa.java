package Aula_Heranca_01_06;

public abstract class Pessoa {
	// Classe abstrata = Classe que pode ser herdada mas não se cria objetos dela (instanciar)
	// Classe concreta = podemos instanciar ela normalmente
	// a abstração serve para esconder a superclasse
	public String matricula;
	public String cpf;
	public String nome;
	public String email;
	
	public boolean find_one() {
		System.out.println();
		return true;
	}
	
	public boolean salvar() {
		System.out.println("Salvar da super classe: " + this.cpf);
		return true;
	}
	
	public boolean deletar(){
		System.out.println();
		return true;
	}
	
	public boolean liberar() {
		return true;
	}
}
