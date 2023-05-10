package Aula02;

public class ContaPoupanca {
	public String Banco;
	public String Agencia;
	public String Conta;
	public String Tipo;
	private double Saldo;
	
	
	public String show_salario() {		
		return "O seu salário é de " + this.Saldo;
	}
	
	public String depositar(double valor) {
		this.Saldo += Saldo + valor;
		
		String resultado = "Deposito realizado! Seu novo saldo é de " + this.Saldo;
		
		return resultado;
	}
	
	public boolean sacar(double valor) {
		if(valor > this.Saldo) {
			return false;
		} else {
			this.Saldo -= this.Saldo - valor;
			
			return true;
		}
	}
}