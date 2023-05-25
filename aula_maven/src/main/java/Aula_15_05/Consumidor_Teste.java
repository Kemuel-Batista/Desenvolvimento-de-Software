package Aula_15_05;

public class Consumidor_Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teste t1 = new Teste();
		t1.var_publica = 1;
		t1.var_statica = 1;
		
		System.out.println("Publica (t1) " + t1.var_publica);
		System.out.println("Estática (t1) " + t1.var_statica);
		
		Teste t2 = new Teste();
		System.out.println("Publica (t2) " + t2.var_publica);
		System.out.println("Estática (t2) " + t2.var_statica);
	}

}
