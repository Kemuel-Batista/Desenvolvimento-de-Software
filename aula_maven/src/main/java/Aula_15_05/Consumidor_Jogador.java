package Aula_15_05;

public class Consumidor_Jogador {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jogador j = Jogador.getInstance();
		j.id = 1;
		j.nome = "Kemuel";
		
		System.out.println(j.nome);
		
		Jogador k = Jogador.getInstance();	
		System.out.println(k.nome);
	}
}