package Aula09;

import java.util.ArrayList;

public class Consumidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		//cliente = new Cliente("141874", "Kemuel", "kemuellima20@gmail.com","81985745857");
		
		/*String resultado = cliente.SalvarNovoCliente(cliente);
		
		System.out.println(resultado); */
		
		String profile = cliente.getProfile("1418");
		
		System.out.println(profile);
		
		ArrayList<Cliente> clientes = Cliente.getAll();
		if (clientes != null) {
			for (int i = 0; i < clientes.size(); i++) {
			    Cliente clienteList = clientes.get(i);
			    System.out.println(clienteList.cpf + " - " + clienteList.nome + " - " + clienteList.email + " - " + clienteList.telefone);
			}
		} else {
		    System.out.println("Não foi possível obter a lista de clientes.");
		}
	}

}