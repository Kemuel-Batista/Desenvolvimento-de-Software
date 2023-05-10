package Aula06;

import java.util.Scanner;

public class ler_do_teclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String nome = "";
		System.out.println("Nome: ");
		nome = teclado.nextLine();
		
		System.out.println(nome);
	}

}
