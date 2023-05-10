package Atividade_GSON;

import java.util.ArrayList;

public class Banco {
	public static int numeroBase = 1;
	public int id;
	public String nome_banco;
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
	
	public Banco(String nome) {
		 this.id = numeroBase++;
		 this.nome_banco = nome;
	}
	
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
}
