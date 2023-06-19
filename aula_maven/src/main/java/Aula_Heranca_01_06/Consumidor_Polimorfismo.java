package Aula_Heranca_01_06;

public class Consumidor_Polimorfismo {
	public static void main(String[] args) {
		Aluno a = new Aluno();
		
		a.cpf = "1234";
		a.email = "kemuel";
		
		Polimorfismo t = new Polimorfismo();
		t.processar(a);
		
		Professor prof = new Professor();
		prof.cpf = "74897";
		prof.matricula = "A010203";
		
		t.processar(prof);
	}
}