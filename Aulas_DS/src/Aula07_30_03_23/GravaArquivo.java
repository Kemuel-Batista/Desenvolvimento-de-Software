package Aula07_30_03_23;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class GravaArquivo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Segue abaixo o que você já escreveu no arquivo: ");
			
			FileInputStream fileinput = new FileInputStream("C:\\Users\\Aluno\\Documents\\texto.txt");
			InputStreamReader readfile = new InputStreamReader(fileinput);
			BufferedReader reader = new BufferedReader(readfile);
	        String linha = reader.readLine();
	        while(linha != null) {
	            System.out.println(linha);
	            linha = reader.readLine();
	        }
	        
	        System.out.println("Vamos acrescentar mais uma linha no arquivo:");
			
			System.out.println("Digite o seu Nome: ");
			teclado = new Scanner(System.in);
			String nome = teclado.nextLine();
			
			FileWriter arquivo = new FileWriter("C:\\Users\\Aluno\\Documents\\texto.txt", true);
			arquivo.write("Nome: " + nome + "\n");
			
			// Chega um momento em que o que vai ser escrito não vai gravar, ele fica alocado em outra 
			// parte da memória
			arquivo.flush();
			arquivo.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}