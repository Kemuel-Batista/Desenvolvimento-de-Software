package Aula_Polimorfismo_01_06;

public class Carro_Passeio implements Veiculo {
	public String combustivel;
	private double eixos;
	
	public double getEixos() {
		return this.eixos/2;
	}
}
