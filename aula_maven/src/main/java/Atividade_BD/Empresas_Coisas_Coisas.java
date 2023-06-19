package Atividade_BD;

public class Empresas_Coisas_Coisas {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clientes cliente;
		
		cliente = new Clientes();
		cliente.cpf = "1234";
		cliente.email = "kemuellima@gmail.com";
		cliente.nome = "Kemuel Batista";
		
		cliente.save(0);
		
		//cliente.findOne(1);
		
		//cliente.save(1);
		
		//cliente.findOne(1);
		
		//cliente.delete(1);
		
		//cliente.findOne(1);
		
		Servicos servico = new Servicos();
		servico.nome = "RE";
		servico.valor = 90.0;
		
		//servico.save(0);
		
		//servico.findOne(1);
		
		Servicos servico2 = new Servicos();
		servico2.nome = "RH";
		servico2.valor = 180.0;
		
		//servico2.save(0);
		
		//servico2.findOne(2);
		
		Prestadores prestador = new Prestadores();
		
		prestador.nome = "Kemuel 2";
		prestador.id_servico = 1;
		
		//prestador.save(0, prestador, 0);
		
		//prestador.findOne(1);
		
		//prestador.save(3, prestador, 2);
		
		//prestador.findOne(3);
		
		//prestador.adicionarServico(3, 1);
		
		//prestador.findOne(3);
		
		Clientes_Servicos cliente_servico = new Clientes_Servicos();
		
		cliente_servico.id_cliente = 1;
		cliente_servico.id_servico = 1;
		
		//cliente_servico.save(0, cliente_servico, 0);
		
		//cliente_servico.findOne(1);
		
		//cliente_servico.save(1, cliente_servico, 2);
		
		//cliente_servico.findOne(1);
	}
}