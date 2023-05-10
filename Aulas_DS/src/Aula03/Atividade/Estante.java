package Aula03.Atividade;

import java.util.ArrayList;

public class Estante {
	ArrayList<Livro> prateleira = new ArrayList<Livro>();
	
	
	public ArrayList<String> listar_titulos() {	
		ArrayList<String> titulos = new ArrayList<String>();
		
		for (int i = 0; i < this.prateleira.size(); i++) {
			titulos.add(this.prateleira.get(i).titulo);
		}
		
		return titulos;
	}
}
