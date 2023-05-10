package Aula01;

public class Consumidor_Pessoa {

	public static void main(String[] args) {
		Pessoa professor = new Pessoa();
		
		professor.nome = "Pedro";
		professor.sobrenome = "de Lara";
		
		System.out.println(professor.mostrar_nome_completo(professor.nome, professor.sobrenome));
		professor.setSalario(1000);
		System.out.println(professor.mostrar_nome_completo(professor.nome, professor.sobrenome));
		System.out.println(professor.getSalario());
		professor.setSalario(2000);
		System.out.println(professor.mostrar_nome_completo(professor.nome, professor.sobrenome));
		System.out.println(professor.getSalario());
	}
}
