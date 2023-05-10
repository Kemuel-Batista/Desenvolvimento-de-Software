package Aula09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cliente {
	public String cpf;
	public String nome;
	public String email;
	public String telefone;
	
	public Cliente (){}
	
	public Cliente(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email; 
        this.telefone = telefone;
	} 
	
	
	public String SalvarNovoCliente(Cliente cliente) {
	    try {
	        File arquivo = new File("C:\\Users\\Aluno\\Documents\\clientes.csv");
	        boolean arquivoExiste = arquivo.exists();
	        
	        FileWriter csvWriter = new FileWriter("C:\\Users\\Aluno\\Documents\\clientes.csv", true);
	        if (!arquivoExiste) {
	            csvWriter.append("cpf;nome;email;telefone\n");
	        }
	        
	        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\Aluno\\Documents\\clientes.csv"));
	        String linha;
	        while ((linha = csvReader.readLine()) != null) {
	            String[] dados = linha.split(";");
	            if (dados[0].equals(cliente.cpf)) {
	                csvReader.close();
	                csvWriter.close();
	                return "CPF já existe no arquivo!";
	            }
	        }
	        csvReader.close();

	        csvWriter.append(cliente.cpf);
	        csvWriter.append(";");
	        csvWriter.append(cliente.nome);
	        csvWriter.append(";");
	        csvWriter.append(cliente.email);
	        csvWriter.append(";");
	        csvWriter.append(cliente.telefone);
	        csvWriter.append("\n");
	        csvWriter.flush();
	        csvWriter.close();
	        return "Cliente salvo com sucesso!";
	    } catch (IOException e) {
	        throw new RuntimeException("Erro ao salvar no arquivo CSV", e);
	    }
	}
	
	public String getProfile(String cpf) {
		try {
			boolean cpfExists = false;
			String profile = "";
			
			BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\Aluno\\Documents\\clientes.csv"));
		    String linha;
		    while ((linha = csvReader.readLine()) != null) {
		        String[] dados = linha.split(";");
		        if (dados[0].equals(cpf)) {
		            profile += linha;
		            cpfExists = true;
		            break;
		        }
		    }
		    csvReader.close();
		    
		    if (!cpfExists) {
		        return "Seu CPF não existe na lista de Clientes";
		    }

		    return profile;
		} catch (IOException e) {
		    throw new RuntimeException("Erro ao salvar no arquivo CSV", e);
		}
	}
	
	public static ArrayList<Cliente> getAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\Aluno\\Documents\\clientes.csv"));
            String linha;
            while ((linha = csvReader.readLine()) != null) {
                String[] dados = linha.split(";");
                Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3]);
                clientes.add(cliente);
            }
            csvReader.close();

            return clientes;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar no arquivo CSV", e);
        }
    }
}