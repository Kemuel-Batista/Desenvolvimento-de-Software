package Aula_Heranca_01_06;

public class Polimorfismo {
	public void processar(Aluno a) {
		a.salvar();
	}
	
	public void processar(Professor p) {
		p.salvar();
	}
}