package Aula04;

public class Consumidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Turma turma;
		
		turma = new Turma();
		
		turma.numero = 1;
	
		turma.professor.nome = "Pedro de Lara";
		
		String[] nomesAlunos = {"Maria da Silva", "Antonio Carlos", "Ana Almeida"};
		String[] cpfsAlunos = {"54564", "456465", "45646"};

		for (int i = 0; i < nomesAlunos.length && i < cpfsAlunos.length; i++) {
		    Aluno aluno = new Aluno();
		    aluno.nome = nomesAlunos[i];
		    aluno.cpf = cpfsAlunos[i];
		    turma.alunos.add(aluno);
		}
		
		System.out.println(turma.listar_turma());
	}

}
