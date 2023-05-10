package Aula01;

public class Calculadora {
	public double fator_1;
	public double fator_2;
	private double soma;
	
	public double somar(double valor1, double valor2) {
		soma = valor1 + valor2;
		return (soma);
	}
	
	public double soma_zera(double valor1, double valor2) {
		zerar_n1();
		return (valor1 + valor2);
	}
	
	private void zerar_n1() {
		// Metodo exemplo que altera o valor de n1 para zero
		this.fator_1 = 0;
	}
}
