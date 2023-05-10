package Aula06_Gerenciamento_Conta;

import java.util.Scanner;

public class Consumidor {
	public static void main(String[] args) {
		Scanner menu = new Scanner(System.in);
		Scanner bancomenu = new Scanner(System.in);
		Scanner clientemenu = new Scanner(System.in);

		Banco banco = new Banco();

		Conta conta;

		boolean bool = true;

		while (bool) {
			System.out.println("------------ Bem-vindo ao sistema de gerenciamento de contas bancárias --------------");
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Sou o Banco");
			System.out.println("2 - Sou um cliente");
			System.out.println("0 - Sair");

			System.out.println("Digite uma opção: ");
			int opcao = menu.nextInt();

			if (opcao == 0) {
				System.out.println("Obrigado por utilizar o sistema de gerenciamento de contas bancárias!");
				bool = false;
				break;
			}

			switch (opcao) {
				case 1:
					boolean bancoOptions = true;

					while (bancoOptions) {

						System.out.println("------------ Bem-vindo Banco ao seu sistema! --------------");
						System.out.println("1 - Mostrar Total Depositado");
						System.out.println("0 - Sair");
						System.out.println("Digite uma opção: ");
						int bancoOpcao = bancomenu.nextInt();

						if (bancoOpcao == 0) {
							System.out.println("Obrigado por utilizar o sistema de gerenciamento de contas bancárias!");
							bancoOptions = false;
							break;
						}

						switch (bancoOpcao) {
							case 1:
								System.out.println("Segue o total depositado nas contas de todos os clientes");
								System.out.println("Total em R$ " + banco.totalDepositado());

								break;
						}
					}

					break;
				case 2:
					boolean clienteOptions = true;

					while (clienteOptions) {
						System.out.println("------------ Bem-vindo Cliente ao seu sistema! --------------");
						System.out.println("1 - Cadastrar nova conta");
						System.out.println("2 - Mostrar informações das contas");
						System.out.println("3 - Realizar depósito");
						System.out.println("4 - Realizar saque");
						System.out.println("0 - Sair");

						System.out.println("Digite uma opção: ");
						int clienteOpcao = clientemenu.nextInt();

						if (clienteOpcao == 0) {
							System.out.println("Obrigado por utilizar o sistema de gerenciamento de contas bancárias!");
							clienteOptions = false;
							break;
						}

						switch (clienteOpcao) {
							case 1:
								Cliente cliente = new Cliente();

								System.out.println("Digite o CPF do cliente:");
								clientemenu = new Scanner(System.in);
								cliente.cpf = clientemenu.nextLine();

								boolean clienteJaExiste = false;
								for (int i = 0; i < banco.clientes.size(); i++) {
									if (banco.clientes.get(i).cpf.equals(cliente.cpf)) {
										clienteJaExiste = true;
										cliente = banco.clientes.get(i);
										break;
									}
								}

								if (clienteJaExiste) {
									System.out.println("CPF já cadastrado.");

									System.out.println("Digite o tipo de conta que você quer adicionar (CC ou CP):");
									clientemenu = new Scanner(System.in);
									String tipo = clientemenu.nextLine();

									conta = new Conta(tipo);

									if (cliente.abrirConta(conta)) {
										System.out.println("Conta cadastrada com sucesso!");
									} else {
										System.out.println("Esse tipo de conta já existe para o usuário informado!");
									}
								} else {
									System.out.println("Digite o nome do cliente:");
									clientemenu = new Scanner(System.in);
									cliente.nome = clientemenu.nextLine();

									System.out.println("Digite o e-mail do cliente:");
									clientemenu = new Scanner(System.in);
									cliente.email = clientemenu.nextLine();

									System.out.println("Digite o tipo de conta (CC ou CP):");
									clientemenu = new Scanner(System.in);
									String tipo = clientemenu.nextLine();

									conta = new Conta(tipo);

									if (cliente.abrirConta(conta)) {
										banco.adicionarCliente(cliente);
									}
								}
								break;
							case 2:
								if (banco.clientes.isEmpty()) {
									System.out.println("Não há clientes cadastrados!");
								} else {
									System.out.println("Digite o CPF:");
									clientemenu = new Scanner(System.in);
									String CPF = clientemenu.nextLine();

									boolean existeCliente = false;
									for (int i = 0; i < banco.clientes.size(); i++) {
										if (banco.clientes.get(i).cpf.equals(CPF)) {
											existeCliente = true;
											cliente = banco.clientes.get(i);
											break;
										}
									}

									if (existeCliente) {
										for (int i = 0; i < banco.clientes.size(); i++) {
											if (banco.clientes.get(i).cpf.equals(CPF)) {
												cliente = banco.clientes.get(i);
												System.out.println("Saldo das contas do cliente");
												System.out.println("Nome do Cliente: " + cliente.nome);
												System.out.println("CPF do Cliente: " + cliente.cpf);

												for (int j = 0; j < cliente.contas.size(); j++) {
													System.out.println(
															"Número da Conta: " + cliente.contas.get(j).numero);
													System.out.println("Tipo da Conta: " + cliente.contas.get(j).tipo);
													System.out.println(
															"Saldo da Conta: " + cliente.contas.get(j).getSaldo());
												}
												break;
											}
										}
									} else {
										System.out.println("Esse cliente não existe!");
									}
								}
								break;
							// DEPOSITO - OK
							case 3:
								System.out.println("Digite o número da conta:");
								int numeroContaDeposito = clientemenu.nextInt();

								System.out.println("Digite o valor a ser depositado:");
								double valorDeposito = clientemenu.nextDouble();

								boolean depositoRealizado = false;

								for (int i = 0; i < banco.clientes.size(); i++) {
									for (int j = 0; j < banco.clientes.get(i).contas.size(); j++) {
										if (banco.clientes.get(i).contas.get(j).numero == numeroContaDeposito) {
											banco.clientes.get(i).contas.get(j).depositar(valorDeposito);
											depositoRealizado = true;
											break;
										}
									}
								}

								if (depositoRealizado) {
									System.out.println("Deposito realizado com sucesso!");
									break;
								}

								if (!depositoRealizado) {
									System.out.println("Conta não encontrada!");
								}
								break;
							// SAQUE - OK
							case 4:
								System.out.println("Digite o número da conta:");
								int numeroContaSaque = clientemenu.nextInt();

								System.out.println("Digite o valor a ser sacado:");
								double valorSaque = menu.nextDouble();

								boolean saqueRealizado = false;

								for (int i = 0; i < banco.clientes.size(); i++) {

									for (int j = 0; j < banco.clientes.get(i).contas.size(); j++) {
										if (banco.clientes.get(i).contas.get(j).numero == numeroContaSaque) {
											banco.clientes.get(i).contas.get(j).sacar(valorSaque);
											saqueRealizado = true;
											break;
										}
									}
									if (saqueRealizado) {
										System.out.println("Saque realizado com sucesso!");
										break;
									}
								}

								if (!saqueRealizado) {
									System.out.println("Conta não encontrada!");
								}
								break;
						}
					}

					break;
			}

			switch (opcao) {

			}
		}
	}
}
