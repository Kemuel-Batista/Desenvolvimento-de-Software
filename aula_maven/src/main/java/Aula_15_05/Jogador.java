package Aula_15_05;

public class Jogador {
	public int id;
	public String nome;
	static Jogador instance;
	
	// Passo 1: O construtor padrão deve ser inacessivel pelos consumidores
	private Jogador() {
		
	}
	
	static Jogador getInstance() {
		if(instance == null) {
			instance = new Jogador(); // Constroi um objeto do tipo jogador
		}
		return instance;
	}
}