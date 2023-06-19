package Aula_Heranca_01_06;

public class Professor extends Pessoa {
	public String tipo_contrato;
	
	@Override
	public boolean salvar() {
		super.salvar();
		System.out.println("Salvando professor na base de dados - Comportamento especializado!");
		return true;
	}
}
