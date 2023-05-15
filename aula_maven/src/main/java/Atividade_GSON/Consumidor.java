package Atividade_GSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Consumidor {

	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();
		
		Banco banco = new Banco("Banco Itáu");
		
		Conta conta = new Conta("CC");
		Cliente cliente = new Cliente("123456", "Kemuel Batista", "kemuel@gmail.com");
		Cliente cliente2 = new Cliente("126", "Kemuel 2", "kemuel2-0@gmail.com");
		cliente.abrirConta(conta);
		cliente2.abrirConta(conta);
		
		banco.adicionarCliente(cliente);
		banco.adicionarCliente(cliente2);
		
		String banco_json = gson.toJson(banco);
		System.out.println(banco_json);
		
		Banco banco_map = gson.fromJson(banco_json, Banco.class);
		System.out.println("ID Banco: " + banco_map.id + " Nome Banco: " + banco.nome_banco);
		
		System.out.println("Lista de Clientes do Banco: " + banco_map.nome_banco);
		for (int i = 0; i < banco_map.clientes.size(); i++) {
			System.out.println("Nome Cliente: " + banco_map.clientes.get(i).nome);
			System.out.println("CPF Cliente: " + banco_map.clientes.get(i).cpf);
			System.out.println("Email Cliente: " + banco_map.clientes.get(i).email);
			
			for(int j = 0; j < banco_map.clientes.get(i).contas.size(); j++) {
				System.out.println("Conta: " + banco_map.clientes.get(i).contas.get(j).numero);
			}
		}
	}
}