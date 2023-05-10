package Atividade_GSON;

import java.util.ArrayList;

public class Cliente {
	public String cpf;
	public String nome;
	public String email;
	
	public ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public Cliente(String cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	
	 public boolean abrirConta(Conta conta) {
	        boolean status = false;

	        if (this.contas.size() != 0) {
	            for (int i = 0; i < this.contas.size(); i++) {
	                if (this.contas.get(i).tipo.equals(conta.tipo)) {
	                    status = false;
	                } else {
	                    this.contas.add(conta);
	                    status = true;
	                    return status;
	                }
	            }
	        } else {
	            this.contas.add(conta);
	            status = true;
	        }

	        return status;
	    }
}
