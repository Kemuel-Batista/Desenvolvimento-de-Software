package Aula03;

import java.util.ArrayList;

public class Exemplo_Lista {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add("Elemento 1");
		lista.add("Elemento 2");
		
		System.out.println(lista.size());
		System.out.println(lista.get(0));
		
		ArrayList<String> lista2 = new ArrayList<String>();
		lista2 = (ArrayList<String>) lista.clone();
		
		System.out.println(lista.get(1));
		lista2.remove(1);
		System.out.println(lista2.size());
		
		ArrayList<Float> salarios = new ArrayList<Float>();
		salarios.add((float) 1500.00);
		salarios.add((float) 5000.00);
		salarios.add((float) 5000);
		salarios.add((float) 7000);
		salarios.add((float) 7000);
		salarios.add((float) 7000);
		salarios.add((float) 7000);
		
		System.out.println(salarios.get(3));
		
		for (int i = 0; i < salarios.size(); i++) {
				System.out.println(salarios.get(i));
		}	
	}

}
