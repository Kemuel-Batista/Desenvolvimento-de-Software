package Aula_Heranca_01_06;

public class Aluno extends Pessoa {
	public String situacao_matricula;
	
	@Override
	public boolean salvar() {
		// Aproveitar o comportamento do salvar da super classe
		super.salvar();
		System.out.println("Salvar aluno na base de dados");
		return true;
	}
}
