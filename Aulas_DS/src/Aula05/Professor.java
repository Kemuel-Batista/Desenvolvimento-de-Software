package Aula05;

public class Professor {
	public String cpf;
	public String matricula;
	public String nome;
	public String email;
	
	//Construtor padrão
	Professor(){
		
	}
	
	// Construtor com argumentos
	public Professor(String cpf, String matricula, String nome, String email) {
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
	}
	
	Professor(String cpf){
		if(cpf.equals("888")){
			this.nome = "Pedro";
			this.email = "kemuel@gmail.com";
		}
	}
}
