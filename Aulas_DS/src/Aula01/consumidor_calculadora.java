package Aula01;

public class consumidor_calculadora {

	public static void main(String[] args) {
		Calculadora calc = new Calculadora(); // INSTANCIA E CONSTROI UM OBJETO DO TIPO CALCULADORA
		Calculadora c = new Calculadora(); 
		
		calc.fator_1 = 10;
		calc.fator_2 = 10;
		
		System.out.println(calc.somar(calc.fator_1, calc.fator_2));
		System.out.println(c);
		System.out.println(calc.soma_zera(calc.fator_1,calc.fator_2));
	}

}
