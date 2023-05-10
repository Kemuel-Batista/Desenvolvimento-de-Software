package Aula03;

import java.util.ArrayList;

public class consumidor_mao {
	public static void main(String[] args) {
		Dedo d; // Instanciando o objeto d
		d = new Dedo();
		d.posicao = 1;
		
		Mao m = new Mao();
		m.lado = "Direito";
		
		m.dedos.add(d);
		
		d = new Dedo(); // Construindo outro objeto Dedo, portando com um novo object id
		d.posicao = 2;
		m.dedos.add(d);
		
		d = new Dedo();
		d.posicao = 3;
		m.dedos.add(d);		
		
		for (int i = 0; i < m.dedos.size(); i++) {
			System.out.println(m.dedos.get(i).posicao);
		}
	}
}