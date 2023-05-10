package Aula06_Gerenciamento_Conta;

public class Conta {
    public static int numeroBase = 1;
    public int numero;
    public String tipo;
    private double saldo;

    public Conta(String tipo) {
        this.numero = numeroBase++;
        this.tipo = tipo;
        this.saldo = 0;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String depositar(double valor) {
    	this.saldo += valor;
    	return "Depósito de R$" + valor + " realizado com sucesso na conta " + this.numero;
    }

    public String sacar(double valor) {
        if (this.saldo < valor) {
            return "Saldo insuficiente na conta " + this.numero;
        }
        saldo -= valor;
        return "Saque de R$" + valor + " realizado com sucesso na conta " + this.numero;
    }

    public String mostrarSaldo() {
        return "Saldo da conta " + this.numero + ": R$" + this.saldo;
    }

}