package Aula06_Gerenciamento_Conta;

import java.util.ArrayList;

public class Banco {
    ArrayList<Cliente> clientes = new ArrayList<>();

    public boolean adicionarCliente(Cliente cliente) {
        boolean status = false;

        boolean clienteJaExiste = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).cpf.equals(cliente.cpf)) {
                clienteJaExiste = true;
                break;
            }
        }

        if (!clienteJaExiste) {
            clientes.add(cliente);
            status = true;
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Cliente já cadastrado!");
        }

        return status;
    }

    public double totalDepositado() {
        double saldoTotal = 0;

        for (int i = 0; i < clientes.size(); i++) {
            for (int j = 0; j < clientes.get(i).contas.size(); j++) {
                saldoTotal += clientes.get(i).contas.get(j).getSaldo();
            }
        }

        return saldoTotal;
    }

}
