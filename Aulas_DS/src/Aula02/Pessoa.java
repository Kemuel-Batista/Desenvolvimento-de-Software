package Aula02;

public class Pessoa {
	public String nome = "";
	public String cpf = "";
	public double media = 0;
	private String resultado;
	
	public String show_resultado() {
		if(this.media > 6) {
			this.resultado = "Aprovado";
		} else {
			this.resultado = "Reprovado";
		}
		
		return this.resultado;
	}
}