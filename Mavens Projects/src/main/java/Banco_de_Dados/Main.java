package Banco_de_Dados;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		cliente.id = 3;
		cliente.nome = "Kemuel Teste JAVA";
		cliente.email = "kemuellima@gmail.com";
		cliente.cpf = "7987456";
		
		//cliente.CadastrarCliente(cliente);
		cliente.getListClientes();
		cliente.AlterarCliente("123", "Kemuel UPDATE", 3);
		cliente.getListClientes();
	}
}