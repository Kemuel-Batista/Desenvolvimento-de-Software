package Aula02;

public class ContaPoupancaConsumidor {

	public static void main(String[] args) {
		ContaPoupanca conta = new ContaPoupanca();
		
		conta.Agencia = "789754-54";
		conta.Banco = "C6 Bank";
		conta.Tipo = "Corrente";
		
		System.out.println(conta.show_salario());
		
		System.out.println(conta.depositar(2000));
		
		if(conta.sacar(3000)) {
			System.out.println("Saque realizado. Saldo atual: " + conta.show_salario());
		} else {
			System.out.println("Erro no saque. Saldo atual: " + conta.show_salario());
		}

		if(conta.sacar(1000)) {
			System.out.println("Saque realizado. Saldo atual: " + conta.show_salario());
		} else {
			System.out.println("Erro no saque. Saldo atual: " + conta.show_salario());
		}
	

	}

}
