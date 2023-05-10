package Aula04;

import java.util.ArrayList;

public class Turma {
	public int numero;
	public Professor professor = new Professor();
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public ArrayList<String> listar_turma() {	
		ArrayList<String> turma = new ArrayList<String>();
		
		for (int i = 0; i < this.alunos.size(); i++) {
			turma.add("Nome: " + this.alunos.get(i).nome);
			turma.add("CPF: " + this.alunos.get(i).cpf);
		}
		
		return turma;
	}
}
